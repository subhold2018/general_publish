package com.lumendata.transformation;

import com.lumendata.model.Address;
import com.lumendata.model.Customer;
import com.lumendata.model.Phone;
import com.lumendata.model.publish.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTransformation {

    public ListOfSwiPersonPublishIOTopElmt transform(Customer customer){
        ListOfSwiPersonPublishIOTopElmt listOfSwiPersonPublishIOTopElmt=new ListOfSwiPersonPublishIOTopElmt();
        ListOfSwiPersonPublishIO listOfSwiPersonPublishIO=new ListOfSwiPersonPublishIO();
        listOfSwiPersonPublishIO.getContact().add(getCustomerData(customer));
        listOfSwiPersonPublishIOTopElmt.setListOfSwiPersonPublishIO(listOfSwiPersonPublishIO);
        return listOfSwiPersonPublishIOTopElmt;
    }

    private Contact getCustomerData(Customer customer) {
        Contact contact=new Contact();
        contact.setBirthDate(customer.getPrimaryData().getDob());
        contact.setEmailAddress(customer.getPrimaryData().getEmail());
        contact.setFirstName(customer.getPrimaryData().getFirstName());
        contact.setLastName(customer.getPrimaryData().getLastName());
        contact.setMaritalStatus(customer.getPrimaryData().getMaritalStatus());
        contact.setMaritalStatusDate(customer.getPrimaryData().getMaritalStatusDate());
        contact.setHomePhone(customer.getPrimaryData().getHomePhone());
        contact.setVABenefits(customer.getPrimaryData().getVaBenefits());
        contact.setPartyUId(customer.getSource().getGuid());
        contact.setListOfContactAlternatePhone(getPhoneData(customer.getPhones()));
        contact.setListOfCuUcmHeConstituentAddress(getAddressData(customer.getAddresses()));
        return contact;
    }

    private ListOfCuUcmHeConstituentAddress getAddressData(List<Address> addresses) {
        ListOfCuUcmHeConstituentAddress listOfCuUcmHeConstituentAddress=new ListOfCuUcmHeConstituentAddress();
        List<CuUcmHeConstituentAddress> cuUcmHeConstituentAddressList=
                listOfCuUcmHeConstituentAddress.getCuUcmHeConstituentAddress();
        addresses.forEach(cutomAddress -> {
            CuUcmHeConstituentAddress address1=new CuUcmHeConstituentAddress();
            address1.setCity(cutomAddress.getCity());
            address1.setState(cutomAddress.getState());
            address1.setCountry(cutomAddress.getCountry());
            address1.setHEAddressType(cutomAddress.getAddressType());
            address1.setPostalCode(cutomAddress.getPostalCode());
            address1.setIsPrimaryMVG(cutomAddress.getIsPrimary());
            address1.setLogicalDeleteFlg(cutomAddress.getLogicalDeleteFlg());
            address1.setStreetAddress(cutomAddress.getStreetAddress());
            address1.setStreetAddress2(cutomAddress.getStreetAddress2());
            address1.setStreetAddress3(cutomAddress.getStreetAddress3());
            address1.setStreetAddress4(cutomAddress.getStreetAddress4());
            address1.setRecordActiveFlg(cutomAddress.getRecordActiveFlag());
            cuUcmHeConstituentAddressList.add(address1);
        });
        listOfCuUcmHeConstituentAddress.getCuUcmHeConstituentAddress()
                .addAll(cuUcmHeConstituentAddressList);
        return listOfCuUcmHeConstituentAddress;
    }

    private ListOfContactAlternatePhone getPhoneData(List<Phone> phones) {
        ListOfContactAlternatePhone alternatePhone=new ListOfContactAlternatePhone();
        List<ContactAlternatePhone> contactAlternatePhone=alternatePhone.getContactAlternatePhone();
        phones.forEach(phone -> {
            ContactAlternatePhone contactAlternatePhone1=new ContactAlternatePhone();
            contactAlternatePhone1.setIsPrimaryMVG(phone.getIsPrimary());
            contactAlternatePhone1.setAlternatePhone(phone.getPhone());
            contactAlternatePhone1.setLogicalDeleteFlg(phone.getLogicalDeleteFlg());
            contactAlternatePhone1.setUseType(phone.getUseType());
            contactAlternatePhone.add(contactAlternatePhone1);
        });
        alternatePhone.getContactAlternatePhone().addAll(contactAlternatePhone);
        return alternatePhone;
    }
}
