package com.lumendata.transformation;

import com.lumendata.model.*;
import com.lumendata.model.publish.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class CustomerTransformation {

    public ListOfSwiPersonPublishIO transform(Customer customer) {
        ListOfSwiPersonPublishIO listOfSwiPersonPublishIO = new ListOfSwiPersonPublishIO();
        listOfSwiPersonPublishIO.getContact().add(getCustomerData(customer));
        return listOfSwiPersonPublishIO;
    }

    private Contact getCustomerData(Customer customer) {
        Contact contact = new Contact();
        contact.setBirthDate(customer.getPrimaryData().getDob());
        contact.setEmailAddress(customer.getPrimaryData().getEmail());
        contact.setFirstName(customer.getPrimaryData().getFirstName());
        contact.setLastName(customer.getPrimaryData().getLastName());
        contact.setMaritalStatus(customer.getPrimaryData().getMaritalStatus());
        contact.setMaritalStatusDate(customer.getPrimaryData().getMaritalStatusDate());
        contact.setHomePhone(customer.getPrimaryData().getHomePhone());
        contact.setVABenefits(customer.getPrimaryData().getVaBenefits());
        contact.setPartyUId(customer.getSource().get(0).getGuid());
        contact.setListOfContactAlternatePhone(getPhoneData(customer.getPhones()));
        contact.setListOfCuUcmHeConstituentAddress(getAddressData(customer.getAddresses()));
        contact.setListOfCuUcmHeConstituentName(getNames(customer.getNames()));
        contact.setListOfCIFContactReference(getSourceData(customer.getSource()));
        if(!CollectionUtils.isEmpty(customer.getIdentifications())) {
            contact.setListOfCuUcmHeConstituentIdentification(getIdentification(customer.getIdentifications()));
        }
        contact.setListOfContactCommunicationAddress(getEmalData(customer.getEmails()));
        if(!CollectionUtils.isEmpty(customer.getAffiliations())) {
            contact.setListOfCuUcmHeConstituentAffiliation(getAffliationData(customer.getAffiliations()));
        }
        return contact;
    }

    private ListOfCIFContactReference getSourceData(List<Source> source) {
        ListOfCIFContactReference listOfCIFContactReference=new ListOfCIFContactReference();
        List<CIFContactReference> cifContactReferences=listOfCIFContactReference.getCIFContactReference();
        source.forEach(source1 -> {
            CIFContactReference cifContactReference=new CIFContactReference();
            cifContactReference.setSystemName(source1.getSource());
            cifContactReference.setExternalId(source1.getSourceId());
            cifContactReferences.add(cifContactReference);
        });
        return listOfCIFContactReference;
    }

    private ListOfCuUcmHeConstituentAffiliation getAffliationData(List<Affiliation> affiliations) {
        ListOfCuUcmHeConstituentAffiliation listOfCuUcmHeConstituentAffiliation=
                new ListOfCuUcmHeConstituentAffiliation();
        List<CuUcmHeConstituentAffiliation> list=listOfCuUcmHeConstituentAffiliation.getCuUcmHeConstituentAffiliation();
        affiliations.forEach(affiliation -> {
            CuUcmHeConstituentAffiliation cuUcmHeConstituentAffiliation=new CuUcmHeConstituentAffiliation();
            cuUcmHeConstituentAffiliation.setOperation(affiliation.getOperation());
            cuUcmHeConstituentAffiliation.setSearchspec(affiliation.getSearchspec());
            cuUcmHeConstituentAffiliation.setIsPrimaryMVG(affiliation.getIsPrimary());
            cuUcmHeConstituentAffiliation.setLogicalDeleteFlg(affiliation.getLogicalDeleteFlg());
            cuUcmHeConstituentAffiliation.setInstitutionName(affiliation.getInstitutionName());
            cuUcmHeConstituentAffiliation.setAffiliationRank(affiliation.getAffiliationRank());
            cuUcmHeConstituentAffiliation.setAffiliationCode(affiliation.getAffiliationCode());
            cuUcmHeConstituentAffiliation.setStatusDescription(affiliation.getStatusDescription());
            cuUcmHeConstituentAffiliation.setStatus(affiliation.getStatus());
            cuUcmHeConstituentAffiliation.setEffectiveStartDate(affiliation.getEffectiveStartDate());
            cuUcmHeConstituentAffiliation.setEffectiveEndDate(affiliation.getEffectiveEndDate());
            cuUcmHeConstituentAffiliation.setPersonId(affiliation.getPersonId());
            cuUcmHeConstituentAffiliation.setInstitutionName(affiliation.getInstitutionName());
            cuUcmHeConstituentAffiliation.setInstitutionId(affiliation.getInstitutionId());
            cuUcmHeConstituentAffiliation.setUpdated(affiliation.getUpdated());
            list.add(cuUcmHeConstituentAffiliation);
        });
        return listOfCuUcmHeConstituentAffiliation;

    }

    private ListOfContactCommunicationAddress getEmalData(List<Email> emails) {
        ListOfContactCommunicationAddress listOfContactCommunicationAddress = new ListOfContactCommunicationAddress();
        List<ContactCommunicationAddress> contactCommunicationAddressList =
                listOfContactCommunicationAddress.getContactCommunicationAddress();

        emails.forEach(email -> {
            ContactCommunicationAddress contactCommunicationAddress = new ContactCommunicationAddress();
            contactCommunicationAddress.setAlternateEmailAddress(email.getEmail());
            contactCommunicationAddress.setLogicalDeleteFlg(email.getLogicalDeleteFlg());
            contactCommunicationAddress.setUseType(email.getUseType());
            contactCommunicationAddress.setIsPrimaryMVG(email.getIsPrimary());
            contactCommunicationAddressList.add(contactCommunicationAddress);
        });
        return listOfContactCommunicationAddress;
    }

    private ListOfCuUcmHeConstituentIdentification getIdentification(List<Identification> identifications) {
        ListOfCuUcmHeConstituentIdentification listOfCuUcmHeConstituentIdentification =
                new ListOfCuUcmHeConstituentIdentification();
        List<CuUcmHeConstituentIdentification> cuUcmHeConstituentIdentification =
                listOfCuUcmHeConstituentIdentification.getCuUcmHeConstituentIdentification();
        identifications.forEach(identification -> {
            CuUcmHeConstituentIdentification cuUcmHeConstituentIdentification1 = new CuUcmHeConstituentIdentification();
            cuUcmHeConstituentIdentification1.setOperation(identification.getOperation());
            cuUcmHeConstituentIdentification1.setSearchspec(identification.getSearchspec());
            cuUcmHeConstituentIdentification1.setIsPrimaryMVG(identification.getIsPrimary());
            cuUcmHeConstituentIdentification1.setLogicalDeleteFlg(identification.getLogicalDeleteFlg());
            cuUcmHeConstituentIdentification1.setNationalIDType(identification.getNationalIDType());
            cuUcmHeConstituentIdentification1.setNationalID(identification.getNationalID());
            cuUcmHeConstituentIdentification1.setEffectiveStartDate(identification.getEffectiveStartDate());
            cuUcmHeConstituentIdentification1.setEffectiveEndDate(identification.getEffectiveEndDate());
            cuUcmHeConstituentIdentification1.setCountry(identification.getCountry());
            cuUcmHeConstituentIdentification1.setContactId(identification.getContactId());
            cuUcmHeConstituentIdentification1.setUpdated(identification.getUpdated());
            cuUcmHeConstituentIdentification.add(cuUcmHeConstituentIdentification1);
        });
        return listOfCuUcmHeConstituentIdentification;
    }

    private ListOfCuUcmHeConstituentName getNames(List<Name> names) {
        ListOfCuUcmHeConstituentName cuUcmHeConstituentName = new ListOfCuUcmHeConstituentName();
        List<CuUcmHeConstituentName> cuUcmHeConstituentNames = cuUcmHeConstituentName.getCuUcmHeConstituentName();
        names.forEach(name -> {
            CuUcmHeConstituentName cuUcmHeConstituentName1 = new CuUcmHeConstituentName();
            cuUcmHeConstituentName1.setFirstName(name.getFirstName());
            cuUcmHeConstituentName1.setLastName(name.getLastName());
            cuUcmHeConstituentName1.setRecordActiveFlg(name.getRecordActiveFlag());
            cuUcmHeConstituentName1.setLogicalDeleteFlg(name.getLogicalDeleteFlg());
            cuUcmHeConstituentName1.setEffectiveStartDate(name.getEffectiveStartDate().toString());
            cuUcmHeConstituentName1.setIsPrimaryMVG(name.getIsPrimary());
            cuUcmHeConstituentName1.setNameType(name.getNameType());
            cuUcmHeConstituentNames.add(cuUcmHeConstituentName1);
        });
        return cuUcmHeConstituentName;
    }

    private ListOfCuUcmHeConstituentAddress getAddressData(List<Address> addresses) {
        ListOfCuUcmHeConstituentAddress listOfCuUcmHeConstituentAddress = new ListOfCuUcmHeConstituentAddress();
        List<CuUcmHeConstituentAddress> cuUcmHeConstituentAddressList =
                listOfCuUcmHeConstituentAddress.getCuUcmHeConstituentAddress();
        addresses.forEach(cutomAddress -> {
            CuUcmHeConstituentAddress address1 = new CuUcmHeConstituentAddress();
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
        return listOfCuUcmHeConstituentAddress;
    }

    private ListOfContactAlternatePhone getPhoneData(List<Phone> phones) {
        ListOfContactAlternatePhone alternatePhone = new ListOfContactAlternatePhone();
        List<ContactAlternatePhone> contactAlternatePhone = alternatePhone.getContactAlternatePhone();
        phones.forEach(phone -> {
            ContactAlternatePhone contactAlternatePhone1 = new ContactAlternatePhone();
            contactAlternatePhone1.setIsPrimaryMVG(phone.getIsPrimary());
            contactAlternatePhone1.setAlternatePhone(phone.getPhone());
            contactAlternatePhone1.setLogicalDeleteFlg(phone.getLogicalDeleteFlg());
            contactAlternatePhone1.setUseType(phone.getUseType());
            contactAlternatePhone.add(contactAlternatePhone1);
        });
        return alternatePhone;
    }
}
