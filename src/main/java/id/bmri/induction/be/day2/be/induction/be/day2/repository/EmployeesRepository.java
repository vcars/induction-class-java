package id.bmri.induction.be.day2.be.induction.be.day2.repository;

import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(nativeQuery = true ,
            value = "select * from employees e  join jobs j on e.job_id = j.job_id")
    public List<Employees> findAllEmployeesAndJobsAndJobHistory();

    List<Employees> findAllByFirstNameOrLastName(String firstName,String lastName);

    @Query(nativeQuery = true ,
            value = "SELECT * FROM EMPLOYEES e " +
                    "LEFT JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID")
    public List<Employees> findAllEmployeesWithDepartmentLeftJoin();

    @Query(nativeQuery = true ,
            value = "SELECT * " +
                    "FROM EMPLOYEES e " +
                    "FULL OUTER  JOIN DEPARTMENTS d on e.DEPARTMENT_ID = d.DEPARTMENT_ID")
    public List<Employees> findAllEmployeesWithDepartmentOuterJoin();



}
