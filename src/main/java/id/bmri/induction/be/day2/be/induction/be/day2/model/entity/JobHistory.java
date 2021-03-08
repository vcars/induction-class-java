package id.bmri.induction.be.day2.be.induction.be.day2.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "job_history" , indexes = {
        @Index(name = "JOBS_HISTORY_INDX_0", columnList = "employee_id")
})
@Data
public class JobHistory {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name="job_id")
    private String jobId;

    @Column(name = "department_id")
    private Integer departmentId;


}
