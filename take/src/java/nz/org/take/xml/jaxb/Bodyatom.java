//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.18 at 02:02:18 PM NZST 
//


package nz.org.take.xml.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bodyatom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bodyatom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="var" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *           &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}IDREF"/>
 *           &lt;element name="expression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="negated" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bodyatom", propOrder = {
    "varOrRefOrExpression"
})
public class Bodyatom {

    @XmlElementRefs({
        @XmlElementRef(name = "ref", namespace = "http://code.google.com/p/take", type = JAXBElement.class),
        @XmlElementRef(name = "expression", namespace = "http://code.google.com/p/take", type = JAXBElement.class),
        @XmlElementRef(name = "var", namespace = "http://code.google.com/p/take", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> varOrRefOrExpression;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected Boolean negated;

    /**
     * Gets the value of the varOrRefOrExpression property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the varOrRefOrExpression property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVarOrRefOrExpression().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getVarOrRefOrExpression() {
        if (varOrRefOrExpression == null) {
            varOrRefOrExpression = new ArrayList<JAXBElement<?>>();
        }
        return this.varOrRefOrExpression;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the negated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNegated() {
        if (negated == null) {
            return false;
        } else {
            return negated;
        }
    }

    /**
     * Sets the value of the negated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegated(Boolean value) {
        this.negated = value;
    }

}
