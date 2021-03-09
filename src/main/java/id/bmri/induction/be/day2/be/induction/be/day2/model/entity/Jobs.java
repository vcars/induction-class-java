package id.bmri.induction.be.day2.be.induction.be.day2.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs" , indexes = {
        @Index(name = "JOBS_INDX_0", columnList = "job_id"),
})
@Data
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;


}
