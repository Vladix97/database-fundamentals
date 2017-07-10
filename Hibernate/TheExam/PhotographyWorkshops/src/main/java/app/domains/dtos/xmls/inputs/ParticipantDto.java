package app.domains.dtos.xmls.inputs;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantDto implements Serializable {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    public ParticipantDto() {
        super();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
