package id.bmri.induction.be.day2.be.induction.be.day2.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobsDto {

    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
}
