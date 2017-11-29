package com.movit.study.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/************************************************************
 * @author jerry.zheng
 * @Description
 * @date 2017-11-29 11:14
 ************************************************************/

@XmlRootElement(name = "RejectInfo")
public class RejectInfo {
    private String oppId;
    private String requestId;
    private String rejectReason;

    @XmlElement(name = "OpportunityId")
    public String getOppId() {
        return oppId;
    }

    public void setOppId(String oppId) {
        this.oppId = oppId;
    }

    @XmlElement(name = "RequestId")
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @XmlElement(name = "RejectReason")
    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
