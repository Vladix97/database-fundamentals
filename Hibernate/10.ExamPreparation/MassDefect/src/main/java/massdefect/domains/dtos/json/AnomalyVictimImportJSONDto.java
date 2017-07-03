package massdefect.domains.dtos.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AnomalyVictimImportJSONDto implements Serializable {

    @Expose
    private long id;

    @SerializedName(value = "person")
    @Expose
    private String personName;

    public AnomalyVictimImportJSONDto() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonName() {
        return this.personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
