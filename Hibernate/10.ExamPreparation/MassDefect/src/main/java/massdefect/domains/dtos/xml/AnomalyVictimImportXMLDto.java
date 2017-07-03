package massdefect.domains.dtos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "anomaly")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyVictimImportXMLDto implements Serializable {

    @XmlAttribute(name = "origin-homePlanet")
    private String originPlanetName;

    @XmlAttribute(name = "teleport-homePlanet")
    private String teleportPlanetName;

    @XmlElementWrapper(name = "victims")
    @XmlElement(name = "victim")
    private Set<VictimImportXMLDto> victimImportDtos;

    public AnomalyVictimImportXMLDto() {
        super();

        this.victimImportDtos = new HashSet<>();
    }

    public String getOriginPlanetName() {
        return this.originPlanetName;
    }

    public void setOriginPlanetName(String originPlanetName) {
        this.originPlanetName = originPlanetName;
    }

    public String getTeleportPlanetName() {
        return this.teleportPlanetName;
    }

    public void setTeleportPlanetName(String teleportPlanetName) {
        this.teleportPlanetName = teleportPlanetName;
    }

    public Set<VictimImportXMLDto> getVictimImportDtos() {
        return this.victimImportDtos;
    }

    public void setVictimImportDtos(Set<VictimImportXMLDto> victimImportDtos) {
        this.victimImportDtos = victimImportDtos;
    }
}
