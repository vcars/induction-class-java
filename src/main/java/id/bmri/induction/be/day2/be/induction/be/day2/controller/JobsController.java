package id.bmri.induction.be.day2.be.induction.be.day2.controller;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.JobsDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.response.Response;
import id.bmri.induction.be.day2.be.induction.be.day2.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping(value = "/api/v1/job")
@RestController
public class JobsController {

    @Autowired
    JobsService jobsService;


    Response response;
    @GetMapping("/search-by-salary")
    public ResponseEntity<Response> searchJobsBySalary(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        List<JobsDto> result = jobsService.searchJobBySalary(min , max);
        if(ObjectUtils.isEmpty(result)){
            response = new Response(false,"Data Not Found",false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new Response(result,"Get List Jobs",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
