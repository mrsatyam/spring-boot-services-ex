package com.axisbank.balanceenq;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JAXBExample {
    public static void main(String[] args) throws JAXBException {
        // Create the BalInqRequest object
        BalInqRequest request = new BalInqRequest();

        // Set Header
        Header header = new Header();
        header.setRequestUUID("jaYIVPZ3");
        header.setServiceRequestId("AE.IBB.C24.TCPIP.001");
        header.setServiceRequestVersion("1.0");
        header.setChannelId("IBB");
        request.setHeader(header);

        // Set BalInqReqBody
        BalInqReqBody body = new BalInqReqBody();
        body.setValueDt("2024-09-10");
        body.setAcctCurr("INR");

        AcctInfo acctInfo = new AcctInfo();
        acctInfo.setBankId("211");
        acctInfo.setBranchId("1884");
        acctInfo.setAcctId("914010023122234");

        body.setAcctInfo(acctInfo);
        request.setBalInqReqBody(body);

        // Create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(BalInqRequest.class);
        Marshaller marshaller = context.createMarshaller();

        // Output pretty-printed XML
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal to System.out
        marshaller.marshal(request, System.out);
    }
}
