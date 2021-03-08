package id.bmri.induction.be.day2.be.induction.be.day2.service;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDetailDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDto;

import java.util.List;

public interface EmployeesService {

    List<EmployeesDetailDto> getAllListEmployeeJobs();
    EmployeesDto getDetail(Integer id);
    List<EmployeesDto> searchByName(String name);

}
