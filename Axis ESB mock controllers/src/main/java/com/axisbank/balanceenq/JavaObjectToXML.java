package com.axisbank.balanceenq;

import com.axisbank.balanceenq.response.BalInqResponse;
import com.axisbank.balanceenq.response.BalInqRspBody;
import com.axisbank.balanceenq.response.Header;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class JavaObjectToXML {
    public static void main(String[] args) throws JAXBException {
        // Initialize JAXBContext and Marshaller
        JAXBContext context = JAXBContext.newInstance(BalInqResponse.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Create a sample BalInqResponse object and set values
        BalInqResponse response = new BalInqResponse();
        Header header = new Header();
        header.setChannelId("IB");
        response.setHeader(header);
        BalInqRspBody balInqRspBody = new BalInqRspBody();
        balInqRspBody.setStatus("Success");
        response.setBalInqRspBody(balInqRspBody);
        // Set Header and Body data...

        // Create a StringWriter to capture the XML output as a String
        StringWriter sw = new StringWriter();

        // Marshal the Java object into XML and write to StringWriter
        marshaller.marshal(response, sw);

        // Get the XML response as a String
        String xmlResponse = sw.toString();

        // Print or use the XML string as needed
        System.out.println(xmlResponse);
    }
}
