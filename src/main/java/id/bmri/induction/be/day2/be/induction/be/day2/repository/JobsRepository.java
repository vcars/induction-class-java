package id.bmri.induction.be.day2.be.induction.be.day2.repository;

import id.bmri.induction.be.day2.be.induction.be.day2.model.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface JobsRepository extends JpaRepository <Jobs , String> {


    @Query(nativeQuery = true,value = "MERGE INTO JOB_HISTORY h " +
            "USING(SELECT * FROM EMPLOYEES ) e " +
            "on(h.EMPLOYEE_ID = e.EMPLOYEE_ID) " +
            "WHEN MATCHED THEN " +
            "UPDATE SET h.MODIFIED_DATE = CURRENT_TIMESTAMP " +
            "WHEN NOT MATCHED THEN " +
            "INSERT (EMPLOYEE_ID,START_DATE,END_DATE,JOB_ID,DEPARTMENT_ID,MODIFIED_DATE) " +
            "VALUES (e.EMPLOYEE_ID,TO_DATE('01-01-1999'),SYSDATE,e.JOB_ID,E.DEPARTMENT_ID,CURRENT_TIMESTAMP)")
    public void mergeDataFromEmployee();
}
