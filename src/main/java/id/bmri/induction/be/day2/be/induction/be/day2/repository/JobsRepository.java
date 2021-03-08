package id.bmri.induction.be.day2.be.induction.be.day2.repository;

import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository <Jobs , String> {

    @Query(nativeQuery = true , value = "select * from jobs where min_salary >= :minSalary and max_salary <= :maxSalary")
    List<Jobs>searchJobsBySalary(@Param("min_salary")BigDecimal minSalary , @Param("max_salary") BigDecimal maxSalary);

}
