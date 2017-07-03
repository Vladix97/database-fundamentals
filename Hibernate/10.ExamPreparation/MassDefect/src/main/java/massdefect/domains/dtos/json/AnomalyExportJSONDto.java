package massdefect.domains.dtos.json;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AnomalyExportJSONDto implements Serializable {

    @Expose
    private Long id;

    @Expose
    private PlanetExportJSONDto originPlanet;

    @Expose
    private PlanetExportJSONDto teleportPlanet;

    @Expose
    private Long victimsCount;

    public AnomalyExportJSONDto() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanetExportJSONDto getOriginPlanet() {
        return this.originPlanet;
    }

    public void setOriginPlanet(PlanetExportJSONDto originPlanet) {
        this.originPlanet = originPlanet;
    }

    public PlanetExportJSONDto getTeleportPlanet() {
        return this.teleportPlanet;
    }

    public void setTeleportPlanet(PlanetExportJSONDto teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    public Long getVictimsCount() {
        return this.victimsCount;
    }

    public void setVictimsCount(Long victimsCount) {
        this.victimsCount = victimsCount;
    }
}
