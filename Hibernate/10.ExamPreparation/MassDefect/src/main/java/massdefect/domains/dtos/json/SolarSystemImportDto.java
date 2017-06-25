package massdefect.domains.dtos.json;

import java.io.Serializable;

public class SolarSystemImportDto implements Serializable {

    private String name;

    public SolarSystemImportDto() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
