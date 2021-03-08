package id.bmri.induction.be.day2.be.induction.be.day2.repository;

import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    @Query(nativeQuery = true ,
            value = "select * from employees e inner join jobs j on e.JOB_ID = j.JOB_ID inner join job_history js on e.employee_id = js.employee_id")
    public List<Employees> findAllEmployeesAndJobsAndJobHistory();

    List<Employees> findAllByFirstNameOrLastName(String name);

}
