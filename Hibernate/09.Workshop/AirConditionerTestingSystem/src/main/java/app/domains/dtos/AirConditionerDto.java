package app.domains.dtos;

public class AirConditionerDto {

    private String manufacturer;

    private String model;

    private Integer powerUsage;

    private Integer electricityUsed;

    private String requiredEfficiencyRating;

    public AirConditionerDto() {
        super();
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPowerUsage() {
        return this.powerUsage;
    }

    public void setPowerUsage(Integer powerUsage) {
        this.powerUsage = powerUsage;
    }

    public Integer getElectricityUsed() {
        return this.electricityUsed;
    }

    public void setElectricityUsed(Integer electricityUsed) {
        this.electricityUsed = electricityUsed;
    }

    public String getRequiredEfficiencyRating() {
        return this.requiredEfficiencyRating;
    }

    public void setRequiredEfficiencyRating(String requiredEfficiencyRating) {
        this.requiredEfficiencyRating = requiredEfficiencyRating;
    }
}
