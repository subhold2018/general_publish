//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.18 at 07:18:43 AM IST 
//


package com.lumendata.model.publish;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ListOfCIFCommunicationAddressReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfCIFCommunicationAddressReference"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CIFCommunicationAddressReference" type="{http://www.siebel.com/xml/SwiPersonPublishIO}CIFCommunicationAddressReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfCIFCommunicationAddressReference", propOrder = {
    "cifCommunicationAddressReference"
})
public class ListOfCIFCommunicationAddressReference {

    @XmlElement(name = "CIFCommunicationAddressReference")
    protected List<CIFCommunicationAddressReference> cifCommunicationAddressReference;

    /**
     * Gets the value of the cifCommunicationAddressReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cifCommunicationAddressReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCIFCommunicationAddressReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIFCommunicationAddressReference }
     * 
     * 
     */
    public List<CIFCommunicationAddressReference> getCIFCommunicationAddressReference() {
        if (cifCommunicationAddressReference == null) {
            cifCommunicationAddressReference = new ArrayList<CIFCommunicationAddressReference>();
        }
        return this.cifCommunicationAddressReference;
    }

}