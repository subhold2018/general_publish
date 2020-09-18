//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.18 at 07:18:43 AM IST 
//


package com.lumendata.model.publish;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faultactor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{Sys_Mdm_All_PersonPublish}CustomHeaderContext" minOccurs="0"/&gt;
 *         &lt;element ref="{Sys_Mdm_All_PersonPublish}_XMLHierarchyOutput" minOccurs="0"/&gt;
 *         &lt;element name="faultcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="faultstring" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "faultactor",
    "customHeaderContext",
    "xmlHierarchyOutput",
    "faultcode",
    "faultstring"
})
@XmlRootElement(name = "PersonPublishOperation_Output", namespace = "Sys_Mdm_All_PersonPublish")
public class PersonPublishOperationOutput {

    @XmlElement(namespace = "Sys_Mdm_All_PersonPublish")
    protected String faultactor;
    @XmlElement(name = "CustomHeaderContext", namespace = "Sys_Mdm_All_PersonPublish")
    protected CustomHeaderContext customHeaderContext;
    @XmlElement(name = "_XMLHierarchyOutput", namespace = "Sys_Mdm_All_PersonPublish")
    protected XMLHierarchyOutput xmlHierarchyOutput;
    @XmlElement(namespace = "Sys_Mdm_All_PersonPublish")
    protected String faultcode;
    @XmlElement(namespace = "Sys_Mdm_All_PersonPublish")
    protected String faultstring;

    /**
     * Gets the value of the faultactor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultactor() {
        return faultactor;
    }

    /**
     * Sets the value of the faultactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultactor(String value) {
        this.faultactor = value;
    }

    /**
     * Gets the value of the customHeaderContext property.
     * 
     * @return
     *     possible object is
     *     {@link CustomHeaderContext }
     *     
     */
    public CustomHeaderContext getCustomHeaderContext() {
        return customHeaderContext;
    }

    /**
     * Sets the value of the customHeaderContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomHeaderContext }
     *     
     */
    public void setCustomHeaderContext(CustomHeaderContext value) {
        this.customHeaderContext = value;
    }

    /**
     * Gets the value of the xmlHierarchyOutput property.
     * 
     * @return
     *     possible object is
     *     {@link XMLHierarchyOutput }
     *     
     */
    public XMLHierarchyOutput getXMLHierarchyOutput() {
        return xmlHierarchyOutput;
    }

    /**
     * Sets the value of the xmlHierarchyOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLHierarchyOutput }
     *     
     */
    public void setXMLHierarchyOutput(XMLHierarchyOutput value) {
        this.xmlHierarchyOutput = value;
    }

    /**
     * Gets the value of the faultcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultcode() {
        return faultcode;
    }

    /**
     * Sets the value of the faultcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultcode(String value) {
        this.faultcode = value;
    }

    /**
     * Gets the value of the faultstring property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaultstring() {
        return faultstring;
    }

    /**
     * Sets the value of the faultstring property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaultstring(String value) {
        this.faultstring = value;
    }

}