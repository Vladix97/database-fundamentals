package app.terminal;

import app.domains.dtos.AirConditionerDto;
import app.domains.dtos.ReportDto;
import app.domains.entities.airConditioners.StationaryAirConditioner;
import app.services.AirConditionerService;
import app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Console implements CommandLineRunner {

    private final AirConditionerService airConditionerService;

    private final ReportService reportService;

    @Autowired
    public Console(AirConditionerService abstractAirConditionerService, ReportService reportService) {
        this.airConditionerService = abstractAirConditionerService;
        this.reportService = reportService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        AirConditionerDto abstractAirConditionerDto = this.getAirConditionerDto();
//        this.airConditionerService.persist(abstractAirConditionerDto, StationaryAirConditioner.class);

        // TODO: add property map to model parser
        ReportDto reportDto = this.getReportDto();
        this.reportService.persist(reportDto);
    }

    private AirConditionerDto getAirConditionerDto() {
        AirConditionerDto airConditionerDto = new AirConditionerDto();

        airConditionerDto.setManufacturer("TOSHIBA");
        airConditionerDto.setElectricityUsed(111);
        airConditionerDto.setRequiredEfficiencyRating("A");

        return airConditionerDto;
    }

    private ReportDto getReportDto() {
        ReportDto reportDto = new ReportDto();
        reportDto.setMark("FAILED");

        AirConditionerDto airConditionerDto = this.getAirConditionerDto();
        reportDto.setAirConditionerDto(airConditionerDto);

        return reportDto;
    }
}
