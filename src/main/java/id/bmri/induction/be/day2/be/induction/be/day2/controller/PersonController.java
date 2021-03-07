package id.bmri.induction.be.day2.be.induction.be.day2.controller;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.PersonDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.request.PersonRequest;
import id.bmri.induction.be.day2.be.induction.be.day2.model.response.Response;
import id.bmri.induction.be.day2.be.induction.be.day2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    private Response response;

    @GetMapping(value = "/list-person")
    public ResponseEntity<Response> getListPerson(@RequestParam(required = false) String nama){
        List<PersonDto> result = this.personService.getList(nama);

        if(ObjectUtils.isEmpty(result)){
            response = new Response(false,"Data Not Found",false);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        response = new Response(result,"Get List Person",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Response> getDetailPerson(@PathVariable int id){
        PersonDto result = this.personService.getDetail(id);
        response = new Response(result,"Get Detail Person",true);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Response> create(@RequestBody PersonRequest request) {
        Boolean isCreated = this.personService.create(request);
        if(!isCreated){
            response = new Response(isCreated, "Failed submit data", false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response = new Response(isCreated, "Data submitted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/create-return-value")
    public ResponseEntity<Response> createReturnValue(@RequestBody PersonRequest request) {
        PersonDto result = this.personService.createReturnValue(request);
        if(ObjectUtils.isEmpty(result)){
            response = new Response(false, "Failed submit data", false);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response = new Response(result, "Data submitted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
