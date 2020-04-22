
package book.jakarta8.wsdate.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the book.jakarta8.wsdate.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DateResponse_QNAME = new QName("http://wsdate.jakarta8.book/", "dateResponse");
    private final static QName _Date_QNAME = new QName("http://wsdate.jakarta8.book/", "date");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: book.jakarta8.wsdate.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DateResponse }
     * 
     */
    public DateResponse createDateResponse() {
        return new DateResponse();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdate.jakarta8.book/", name = "dateResponse")
    public JAXBElement<DateResponse> createDateResponse(DateResponse value) {
        return new JAXBElement<DateResponse>(_DateResponse_QNAME, DateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsdate.jakarta8.book/", name = "date")
    public JAXBElement<Date> createDate(Date value) {
        return new JAXBElement<Date>(_Date_QNAME, Date.class, null, value);
    }

}
