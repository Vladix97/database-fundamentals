package app.domains.dtos.xmls.inputs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "accessory")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryDto implements Serializable {

    @XmlAttribute(name = "name")
    private String name;

    public AccessoryDto() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
