package id.bmri.induction.be.day2.be.induction.be.day2.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class EmployeesDto {
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Timestamp hireDate;

    private BigDecimal salary;
}
