package app.services;

import app.domains.dtos.ReportDto;

public interface ReportService {

    public void persist(ReportDto reportDto);
}
