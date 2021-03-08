package id.bmri.induction.be.day2.be.induction.be.day2.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="employees" , indexes = {
        @Index(name = "EMPLOYESS_INDX_0", columnList = "employee_id"),
        @Index(name = "EMPLOYESS_INDX_0", columnList = "job_id")
})
public class Employees {

    @Id
    @Column(name="employee_id",nullable = false)
    private Integer employeeId;

    @Column(name="first_name", length = 20)
    private String firstName;

    @Column(name="last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name="email", length = 20 , nullable = false)
    private String email;

    @Column(name="phone_number", length = 20)
    private String phoneNumber;

    @Column(name="hire_date", nullable = false)
    private Timestamp hireDate;

    @Column(name="job_id", length = 10 , nullable = false)
    private String jobId;

    @Column(name="salary")
    private BigDecimal salary;

    @Column(name="commission_pct")
    private BigDecimal commission_pct;

    @Column(name="manager_id")
    private Integer managerId;

    @Column(name = "department_id")
    private Integer departmentId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id" , insertable = false,updatable = false)
    @JsonBackReference
    private Jobs jobs;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id" , insertable = false,updatable = false)
    @JsonBackReference
    private JobHistory jobHistory;

    @Transient
    private String jobTitle;
}
