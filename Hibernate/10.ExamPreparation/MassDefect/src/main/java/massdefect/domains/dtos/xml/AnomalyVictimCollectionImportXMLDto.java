package massdefect.domains.dtos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyVictimCollectionImportXMLDto implements Serializable {

    @XmlElement(name = "anomaly")
    private Set<AnomalyVictimImportXMLDto> anomalyVictimImportXMLDtos;

    public AnomalyVictimCollectionImportXMLDto() {
        super();

        this.anomalyVictimImportXMLDtos = new HashSet<>();
    }

    public Set<AnomalyVictimImportXMLDto> getAnomalyVictimImportXMLDtos() {
        return this.anomalyVictimImportXMLDtos;
    }

    public void setAnomalyVictimImportXMLDtos(Set<AnomalyVictimImportXMLDto> anomalyVictimImportXMLDtos) {
        this.anomalyVictimImportXMLDtos = anomalyVictimImportXMLDtos;
    }
}
