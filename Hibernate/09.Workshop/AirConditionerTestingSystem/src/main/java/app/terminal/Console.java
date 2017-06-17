//package app.terminal;
//
//import app.domains.dtos.AirConditionerDto;
//import app.domains.dtos.ReportDto;
//import app.domains.entities.airConditioners.PlaneAirConditioner;
//import app.services.AirConditionerService;
//import app.services.ReportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Console implements CommandLineRunner {
//
//    private final AirConditionerService airConditionerService;
//
//    private final ReportService reportService;
//
//    @Autowired
//    public Console(AirConditionerService abstractAirConditionerService, ReportService reportService) {
//        this.airConditionerService = abstractAirConditionerService;
//        this.reportService = reportService;
//    }
//
//    @Override
//    public void run(String... strings) throws Exception {
//        AirConditionerDto abstractAirConditionerDto = this.getAirConditionerDto();
//        this.airConditionerService.persist(abstractAirConditionerDto, PlaneAirConditioner.class);
//
//        ReportDto reportDto = this.getReportDto();
//        reportDto.setAirConditionerDto(abstractAirConditionerDto);
//        this.reportService.persist(reportDto);
//    }
//
//    private AirConditionerDto getAirConditionerDto() {
//        AirConditionerDto airConditionerDto = new AirConditionerDto();
//
//        airConditionerDto.setManufacturer("TOSHIBA");
//        airConditionerDto.setModel("model101");
//        airConditionerDto.setVolumeCovered(111);
//        airConditionerDto.setElectricityUsed(333);
//
//        return airConditionerDto;
//    }
//
//    private ReportDto getReportDto() {
//        ReportDto reportDto = new ReportDto();
//        reportDto.setMark("FAILED");
//
//        return reportDto;
//    }
//}
