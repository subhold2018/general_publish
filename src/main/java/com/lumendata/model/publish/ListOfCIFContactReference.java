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
 * <p>Java class for ListOfCIFContactReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfCIFContactReference"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CIFContactReference" type="{http://www.siebel.com/xml/SwiPersonPublishIO}CIFContactReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfCIFContactReference", propOrder = {
    "cifContactReference"
})
public class ListOfCIFContactReference {

    @XmlElement(name = "CIFContactReference")
    protected List<CIFContactReference> cifContactReference;

    /**
     * Gets the value of the cifContactReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cifContactReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCIFContactReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIFContactReference }
     * 
     * 
     */
    public List<CIFContactReference> getCIFContactReference() {
        if (cifContactReference == null) {
            cifContactReference = new ArrayList<CIFContactReference>();
        }
        return this.cifContactReference;
    }

}