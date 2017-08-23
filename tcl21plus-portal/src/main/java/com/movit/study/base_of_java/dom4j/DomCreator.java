package com.movit.study.base_of_java.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.*;

/**
 * Created by admin on 2017/3/6.
 */
public class DomCreator {

    public static String createDocument() {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("soapenv:Envelope")
                .addAttribute("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/")
                .addAttribute("xmlns:urn", "urn:greenlandgroup.com:KH:ECC");

        /**
         * 此行会报错 org.dom4j.IllegalAddException: No such namespace prefix:
         * 这个异常是说：要添加的这个元素的前缀，没有声明！这主要是在添加元素时直接用上级元素的allElement方法时出现的。例：
         * Element headerElement1 = rootElement.addElement("soapenv:Header");
         */
//        Element headerElement1 = rootElement.addElement("soapenv:Header");
//        rootElement.add(headerElement1);

        Element headerElement = DocumentHelper.createElement("soapenv:Header");
        rootElement.add(headerElement);

        Element bodyElement = DocumentHelper.createElement("soapenv:Body");
        headerElement.add(bodyElement);

        Element urn = DocumentHelper.createElement("urn:MT_REQUEST_KH");
        bodyElement.add(urn);

        Element ivType = urn.addElement("IV_TYPE");
        ivType.addText("01");

        Element ivMessage = ivType.addElement("IV_MESSAGE");
        ivMessage.addText("{\"CUSTOMER_TYPE\":\"10\",\"NAME\":\"历女士\",\"MOB_NUMBER\":\"18662246908\",\"CUSTATUS\":\"20\",\"SPELL\":\"\"," +
                "\"GENDER\":\"20\",\"BIRTHDAY\":\"\",\"IDTYPE\":\"10\",\"IDNO\":\"\",\"VISITOR\":\"10\",\"TRACKDATE\":\"\",\"REGISTERADD\":\"\"," +
                "\"GROUPCU\":\"\",\"SUCCESSRETE\":\"10\",\"COUNTRY\":\"\",\"CENSUSREGISTER\":\"\",\"ZPROJECTNO\":\"L-02007\"," +
                "\"LOGINID\":\"SD-ZHOUCHAO\",\"LDLF\":\"010\",\"METHODID\":\"R001\",\"CRM_BP_ID\":\"1005562722\",\"REFUND\":\"\"," +
                "\"READDRESS\":\"\",\"AREA\":\"\",\"LEGALPERSON\":\"\",\"LICENSE\":\"\",\"SCOPE\":\"\",\"PROFIT\":\"\"}{\"CUSTOMER_TYPE\":\"10\"," +
                "\"NAME\":\"历女士\",\"MOB_NUMBER\":\"18662246908\",\"CUSTATUS\":\"20\",\"SPELL\":\"\",\"GENDER\":\"20\",\"BIRTHDAY\":\"\"," +
                "\"IDTYPE\":\"10\",\"IDNO\":\"\",\"VISITOR\":\"10\",\"TRACKDATE\":\"\",\"REGISTERADD\":\"\",\"GROUPCU\":\"\",\"SUCCESSRETE\":\"10\"," +
                "\"COUNTRY\":\"\",\"CENSUSREGISTER\":\"\",\"ZPROJECTNO\":\"L-02007\",\"LOGINID\":\"SD-ZHOUCHAO\",\"LDLF\":\"010\"," +
                "\"METHODID\":\"R001\",\"CRM_BP_ID\":\"1005562722\",\"REFUND\":\"\",\"READDRESS\":\"\",\"AREA\":\"\",\"LEGALPERSON\":\"\"," +
                "\"LICENSE\":\"\",\"SCOPE\":\"\",\"PROFIT\":\"\"}");

        return document.asXML();
    }

    public static void main(String[] args) {

        String document = createDocument();
        File file = new File("E:/dom4j.xml");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            ByteArrayInputStream inputStream = new ByteArrayInputStream(document.getBytes());
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
            int len;
            byte[] red = new byte[1024];
            while ( (len = inputStream.read(red)) != -1) {
                outputStream.write(red, 0, len);
            }
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
