package id.bmri.induction.be.day2.be.induction.be.day2.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
@Data
public class Departments {

    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "location_id")
    private Integer locationId;
}
