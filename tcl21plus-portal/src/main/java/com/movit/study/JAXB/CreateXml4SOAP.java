package com.movit.study.JAXB;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.utils.WebServiceSSLClient2;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.dom.DOMElement;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-11-29 10:58
 ************************************************************/
public class CreateXml4SOAP {

    public static void main(String[] args) throws JAXBException, JsonProcessingException {
        RejectInfo rejectInfo = new RejectInfo();
        rejectInfo.setOppId("71363");
        rejectInfo.setRequestId("12321321");
        rejectInfo.setRejectReason("test");

        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(RejectInfo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(rejectInfo, stringWriter);

        Entity requestEntity = DocumentHelper.createEntity(null, stringWriter.toString());
        requestEntity.setText(requestEntity.getText().substring(requestEntity.getText().indexOf("?>") + 2));

        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("soapenv:Envelope");
        rootElement.addAttribute("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        rootElement.addAttribute("xmlns:peg", "http://pegasus.webservice.opp.bfo2.sec.com/");

        DOMElement header = new DOMElement("soapenv:Header");
        rootElement.add(header);

        DOMElement body = new DOMElement("soapenv:Body");
        DOMElement subBody = new DOMElement("peg:doReject");
        subBody.add(requestEntity);
        body.add(subBody);
        rootElement.add(body);

        System.out.println(document.asXML());
        Map<String, String> response = WebServiceSSLClient2.webServiceRequest("http://localhost:8080/services/PegasusRejectSCApply?wsdl", document.asXML(), "1");

        WebServiceCommonResponse commonResponse = convertResponse(response);
        System.out.println(new ObjectMapper().writeValueAsString(commonResponse));

    }

    private static WebServiceCommonResponse convertResponse(Map<String, String> response) throws JAXBException {
        WebServiceCommonResponse commonResponse = new WebServiceCommonResponse();
        commonResponse.setType("E");

        if (response != null && response.size() > 0) {
            String responseStr = response.get("responseBody");

            if (StringUtils.isNotEmpty(responseStr)) {
                if (responseStr.contains("<return>") && responseStr.contains("</return>")) {
                    String returnObj = responseStr.substring(responseStr.indexOf("<return>"), responseStr.indexOf("</return>") + 9);
                    JAXBContext jaxbContext = JAXBContext.newInstance(WebServiceCommonResponse.class);
                    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                    commonResponse = (WebServiceCommonResponse)unmarshaller.unmarshal(new StringReader(returnObj));
                }else if (responseStr.contains("<faultstring>") && responseStr.contains("</faultstring>")) {
                    String returnObj = responseStr.substring(responseStr.indexOf("<faultstring>"), responseStr.indexOf("</faultstring>") + 13);
                    commonResponse.setMessage(returnObj);
                }else {
                    commonResponse.setMessage(responseStr);
                }
            }
        }

        return commonResponse;
    }

}
