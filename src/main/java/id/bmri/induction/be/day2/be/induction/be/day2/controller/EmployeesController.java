package id.bmri.induction.be.day2.be.induction.be.day2.controller;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDetailDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.EmployeesDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.response.Response;
import id.bmri.induction.be.day2.be.induction.be.day2.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    Response response;
    @GetMapping(value = "/list-employe-jobs")
    public ResponseEntity<Response> getAll(){
        List<EmployeesDetailDto> result = employeesService.getAllListEmployeeJobs();

        if(ObjectUtils.isEmpty(result)){
            response = new Response(false,"Data Not Found",false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new Response(result,"Get List Employee",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Response>  getDetail(@PathVariable Integer id){
        EmployeesDto result = this.employeesService.getDetail(id);
        if(ObjectUtils.isEmpty(result)){
            response = new Response(false,"Data Not Found",false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new Response(result,"Get Detail Employee",true);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping(value = "/search-by-name")
    public ResponseEntity<Response> searchByName (@RequestParam String name){
        List<EmployeesDto> result = this.employeesService.searchByName(name);
        if(ObjectUtils.isEmpty(result)){
            response = new Response(false,"Data Not Found",false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = new Response(result,"Get List Employee By Name",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
