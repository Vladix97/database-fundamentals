package massdefect.domains.dtos.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonExportJSONDto implements Serializable {

    @Expose
    private String name;

    @Expose
    @SerializedName(value = "homePlanet")
    private PlanetExportJSONDto homePlanetName;

    public PersonExportJSONDto() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetExportJSONDto getHomePlanetName() {
        return this.homePlanetName;
    }

    public void setHomePlanetName(PlanetExportJSONDto homePlanetName) {
        this.homePlanetName = homePlanetName;
    }
}
