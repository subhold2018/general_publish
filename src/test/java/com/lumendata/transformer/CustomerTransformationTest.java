package com.lumendata.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lumendata.model.Customer;
import com.lumendata.model.publish.ListOfSwiPersonPublishIO;
import com.lumendata.model.publish.ListOfSwiPersonPublishIOTopElmt;
import com.lumendata.model.publish.PersonPublishOperationInput;
import com.lumendata.model.publish.XMLHierarchyOutput;
import com.lumendata.transformation.CustomerTransformation;
import org.junit.Assert;
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
        XmlMapper xmlMapper=new XmlMapper();
        xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
      //  PersonPublishOperationInput personPublishOperationInput=new PersonPublishOperationInput();
      //  personPublishOperationInput.setListOfSwiPersonPublishIO(listOfSwiPersonPublishIO);
        String xml=xmlMapper.writeValueAsString(listOfSwiPersonPublishIO);

        System.out.println("xml->"+xml);
        Assert.assertNotNull(listOfSwiPersonPublishIO.getContact().get(0).getPartyUId());
        Assert.assertNotNull(listOfSwiPersonPublishIO.getContact()
                .get(0).getListOfCIFContactReference().getCIFContactReference().get(0).getSystemName());
        Assert.assertEquals("CS",listOfSwiPersonPublishIO.getContact()
                .get(0).getListOfCIFContactReference().getCIFContactReference().get(0).getSystemName());
    }
}
