package massdefect.domains.dtos.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PersonImportJSONDto implements Serializable {

    @Expose
    private String name;

    @Expose
    @SerializedName(value = "homePlanet")
    private String homePlanetName;

    public PersonImportJSONDto() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePlanetName() {
        return this.homePlanetName;
    }

    public void setHomePlanetName(String homePlanetName) {
        this.homePlanetName = homePlanetName;
    }
}
