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


/**
 * <p>Java class for ListOfSwiPersonPublishIOTopElmt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListOfSwiPersonPublishIOTopElmt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListOfSwiPersonPublishIO" type="{http://www.siebel.com/xml/SwiPersonPublishIO}ListOfSwiPersonPublishIO"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfSwiPersonPublishIOTopElmt", propOrder = {
    "listOfSwiPersonPublishIO"
})
public class ListOfSwiPersonPublishIOTopElmt {

    @XmlElement(name = "ListOfSwiPersonPublishIO", required = true)
    protected ListOfSwiPersonPublishIO listOfSwiPersonPublishIO;

    /**
     * Gets the value of the listOfSwiPersonPublishIO property.
     * 
     * @return
     *     possible object is
     *     {@link ListOfSwiPersonPublishIO }
     *     
     */
    public ListOfSwiPersonPublishIO getListOfSwiPersonPublishIO() {
        return listOfSwiPersonPublishIO;
    }

    /**
     * Sets the value of the listOfSwiPersonPublishIO property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOfSwiPersonPublishIO }
     *     
     */
    public void setListOfSwiPersonPublishIO(ListOfSwiPersonPublishIO value) {
        this.listOfSwiPersonPublishIO = value;
    }

}
