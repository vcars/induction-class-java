package id.bmri.induction.be.day2.be.induction.be.day2.service.impl;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeeDepartmenNameDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDetailDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Employees;
import id.bmri.induction.be.day2.be.induction.be.day2.repository.EmployeesRepository;
import id.bmri.induction.be.day2.be.induction.be.day2.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public List<EmployeesDetailDto> getAllListEmployeeJobs() {

            List<Employees> employees = this.employeesRepository.findAllEmployeesAndJobsAndJobHistory();
            if(employees.isEmpty()) {
                return null;
            }
            return  employees.stream().map(this::getFetchDetailToDto).collect(Collectors.toList());

    }

    @Override
    public EmployeesDto getDetail(Integer id) {

        Optional<Employees> employees = this.employeesRepository.findById(id);

        if(employees.isEmpty()) {
            return null;
        }

        return this.getFetchToDto(employees.get());
    }

    @Override
    public List<EmployeesDto> searchByName(String firstName , String lastName) {

        List<Employees> employees = this.employeesRepository.findAllByFirstNameOrLastName(firstName,lastName);
        if(employees.isEmpty()) {
            return null;
        }

        return employees.stream().map(this::getFetchToDto).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDepartmenNameDto> getAllEmployeeLeftJoinDepartment() {

            List<Employees> employees = this.employeesRepository.findAllEmployeesAndJobsAndJobHistory();
            if(employees.isEmpty()) {
                return null;
            }

            return  employees.stream().map(this::getFetchDepartmenToDto).collect(Collectors.toList());



    }

    @Override
    public List<EmployeeDepartmenNameDto> getAllEmployeeOuterJoinDepartment() {
        List<Employees> employees = this.employeesRepository.findAllEmployeesWithDepartmentOuterJoin();
        if(employees.isEmpty()) {
            return null;
        }

        return  employees.stream().map(this::getFetchDepartmenToDto).collect(Collectors.toList());

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

    private EmployeesDetailDto getFetchDetailToDto(Employees mapper) {
        EmployeesDetailDto employeesDetailDto = new EmployeesDetailDto();
        employeesDetailDto.setEmail(mapper.getEmail());
        employeesDetailDto.setFirstName(mapper.getFirstName());
        employeesDetailDto.setLastName(mapper.getLastName());
        employeesDetailDto.setPhoneNumber(mapper.getPhoneNumber());
        employeesDetailDto.setSalary(mapper.getSalary());
        employeesDetailDto.setJobTitle(mapper.getJobs().getJobTitle());
        employeesDetailDto.setMinSalary(mapper.getJobs().getMinSalary());
        employeesDetailDto.setMaxSalary(mapper.getJobs().getMaxSalary());
        return employeesDetailDto;
    }

    private EmployeeDepartmenNameDto getFetchDepartmenToDto(Employees mapper) {


            EmployeeDepartmenNameDto employeeDepartmenNameDto = new EmployeeDepartmenNameDto();

            if(mapper != null) {
                System.out.println(mapper);
                if (mapper.getEmail() != null) {
                    employeeDepartmenNameDto.setEmail(mapper.getEmail());
                }

                if (mapper.getFirstName() != null){
                    employeeDepartmenNameDto.setFirstName(mapper.getFirstName());
                }

                if (mapper.getLastName() != null) {
                    employeeDepartmenNameDto.setLastName(mapper.getLastName());
                }

                if(mapper.getPhoneNumber() != null){
                    employeeDepartmenNameDto.setPhoneNumber(mapper.getPhoneNumber());
                }

                if (mapper.getDepartments().getDepartmentName() != null) {
                    employeeDepartmenNameDto.setDepartmentName(mapper.getDepartments().getDepartmentName());
                }

    }
        return employeeDepartmenNameDto;

    }
}
