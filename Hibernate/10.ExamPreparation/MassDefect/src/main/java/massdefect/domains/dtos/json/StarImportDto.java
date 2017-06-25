package massdefect.domains.dtos.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StarImportDto implements Serializable {

    @Expose
    private String name;

    @SerializedName(value = "solarSystem")
    @Expose
    private String solarSystemName;

    public StarImportDto() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolarSystemName() {
        return this.solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }
}
