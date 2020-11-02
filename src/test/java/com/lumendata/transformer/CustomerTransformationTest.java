package com.lumendata.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumendata.model.Customer;
import com.lumendata.model.publish.ListOfSwiPersonPublishIO;
import com.lumendata.transformation.CustomerTransformation;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

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
        ListOfSwiPersonPublishIO listOfSwiPersonPublishIO =
                customerTransformation.transform(customer);
        Assert.assertNotNull(listOfSwiPersonPublishIO.getContact().get(0).getPartyUId());
        Assert.assertNotNull(listOfSwiPersonPublishIO.getContact()
                .get(0).getListOfCIFContactReference().getCIFContactReference().get(0).getSystemName());
        Assert.assertEquals("CS", listOfSwiPersonPublishIO.getContact()
                .get(0).getListOfCIFContactReference().getCIFContactReference().get(0).getSystemName());
    }
}
