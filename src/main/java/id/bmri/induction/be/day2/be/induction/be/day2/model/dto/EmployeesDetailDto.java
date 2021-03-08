package id.bmri.induction.be.day2.be.induction.be.day2.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class EmployeesDetailDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Timestamp hireDate;

    private BigDecimal salary;

    private String jobTitle;

    private BigDecimal minSalary;

    private BigDecimal maxSalary;

    private Timestamp startDate;

    private Timestamp endDate;

}
