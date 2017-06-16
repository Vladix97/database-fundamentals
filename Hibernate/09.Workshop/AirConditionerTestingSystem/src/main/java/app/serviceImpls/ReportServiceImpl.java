package app.serviceImpls;

import app.controllers.ReportRepository;
import app.domains.dtos.ReportDto;
import app.domains.entities.reports.Report;
import app.parsers.ModelParser;
import app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final ModelParser modelParser;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, ModelParser modelParser) {
        this.reportRepository = reportRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void persist(ReportDto reportDto) {
        Report convert = this.modelParser.convert(reportDto, Report.class);

        this.reportRepository.saveAndFlush(convert);
    }
}
