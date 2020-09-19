package com.lumendata.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.Customer;
import com.lumendata.model.publish.ListOfSwiPersonPublishIO;
import com.lumendata.model.publish.ListOfSwiPersonPublishIOTopElmt;
import com.lumendata.model.publish.XMLHierarchyOutput;
import com.lumendata.transformation.CustomerTransformation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTransformationTest {

    @InjectMocks
    CustomerTransformation customerTransformation;

    @Test
    public void shouldTransformCustomerToSwipePerson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        Customer customer = objectMapper
                .readValue(new File("src/test/resources/customer.json"), Customer.class);
        ListOfSwiPersonPublishIO listOfSwiPersonPublishIO=
                customerTransformation.transform(customer);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLHierarchyOutput.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            StringWriter sw = new StringWriter();
            XMLHierarchyOutput xmlHierarchyOutput=new XMLHierarchyOutput();
            xmlHierarchyOutput.setAny(listOfSwiPersonPublishIO);
            jaxbMarshaller.marshal(xmlHierarchyOutput, sw);
            String xmlString = sw.toString();
        }catch (Exception exception){
           System.out.println(exception);
        }

    }
}
