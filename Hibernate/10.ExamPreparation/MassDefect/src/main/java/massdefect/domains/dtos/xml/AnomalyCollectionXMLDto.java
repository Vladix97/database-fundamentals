package massdefect.domains.dtos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyCollectionXMLDto implements Serializable {

    @XmlElement(name = "anomaly")
    private Set<AnomalyXMLDto> anomalyXMLDtos;

    public AnomalyCollectionXMLDto() {
        super();

        this.anomalyXMLDtos = new HashSet<>();
    }

    public Set<AnomalyXMLDto> getAnomalyXMLDtos() {
        return this.anomalyXMLDtos;
    }

    public void setAnomalyXMLDtos(Set<AnomalyXMLDto> anomalyXMLDtos) {
        this.anomalyXMLDtos = anomalyXMLDtos;
    }
}
