package id.bmri.induction.be.day2.be.induction.be.day2.service.impl;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDetailDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Employees;
import id.bmri.induction.be.day2.be.induction.be.day2.repository.EmployeesRepository;
import id.bmri.induction.be.day2.be.induction.be.day2.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public List<EmployeesDetailDto> getAllListEmployeeJobs() {

        List<Employees> employees = employeesRepository.findAllEmployeesAndJobsAndJobHistory();
        if(employees.isEmpty()) {
            return null;
        }
        return  employees.stream().map(this::getDetailFetchToDto).collect(Collectors.toList());

    }

    @Override
    public EmployeesDto getDetail(Integer id) {

        Optional<Employees> employees = employeesRepository.findById(id);

        if(employees.isEmpty()) {
            return null;
        }

        return this.getFetchToDto(employees.get());
    }

    @Override
    public List<EmployeesDto> searchByName(String name) {

        List<Employees> employees = employeesRepository.findAllByFirstNameOrLastName(name);
        if(employees.isEmpty()) {
            return null;
        }

        return employees.stream().map(this::getFetchToDto).collect(Collectors.toList());
    }



    private EmployeesDetailDto getDetailFetchToDto(Employees mapper) {
        EmployeesDetailDto employeesDetailDto = new EmployeesDetailDto();
        employeesDetailDto.setEmail(mapper.getEmail());
        employeesDetailDto.setFirstName(mapper.getFirstName());
        employeesDetailDto.setLastName(mapper.getLastName());
        employeesDetailDto.setPhoneNumber(mapper.getPhoneNumber());
        employeesDetailDto.setSalary(mapper.getSalary());
        employeesDetailDto.setHireDate(mapper.getHireDate());
        employeesDetailDto.setJobTitle(mapper.getJobs().getJobTitle());
        employeesDetailDto.setStartDate(mapper.getJobHistory().getStartDate());
        employeesDetailDto.setEndDate(mapper.getJobHistory().getEndDate());
        employeesDetailDto.setMinSalary(mapper.getJobs().getMinSalary());
        employeesDetailDto.setMaxSalary(mapper.getJobs().getMaxSalary());
        return employeesDetailDto;
    }

    private EmployeesDto getFetchToDto(Employees mapper) {
        EmployeesDto employeesDto = new EmployeesDto();
        employeesDto.setEmail(mapper.getEmail());
        employeesDto.setFirstName(mapper.getFirstName());
        employeesDto.setLastName(mapper.getLastName());
        employeesDto.setPhoneNumber(mapper.getPhoneNumber());
        employeesDto.setSalary(mapper.getSalary());

        return employeesDto;
    }
}
