package id.bmri.induction.be.day2.be.induction.be.day2.service;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.JobsDto;

import java.math.BigDecimal;
import java.util.List;

public interface JobsService {

    List<JobsDto> searchJobBySalary(BigDecimal minSalary , BigDecimal maxSalary);
}
