package id.bmri.induction.be.day2.be.induction.be.day2.controller;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.JobsDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.response.Response;
import id.bmri.induction.be.day2.be.induction.be.day2.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping(value = "/api/v1/job")
@RestController
public class JobsController {

    @Autowired
    JobsService jobsService;


    Response response;


    @PostMapping(value = "/merge-from-employee")
    public ResponseEntity<Response>  mergeFromEmployee(){
         this.jobsService.mergeFromEmployee();

        response = new Response(true,"Get Detail Employee",true);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

}
