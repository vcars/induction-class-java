package id.bmri.induction.be.day2.be.induction.be.day2.controller;

import id.bmri.induction.be.day2.be.induction.be.day2.model.request.HelloRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloController {

    @GetMapping
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping("/{nama}")
    public String getHelloName(@RequestParam(defaultValue = "20" , value = "umur") String age , @PathVariable String nama) {
      return "Hello" + nama + ", Umur " + age ;
    }

    @PostMapping("/test-1")
    public String createHelloWord(@RequestBody String nama){
        return "Hallo Nama Saya" + nama;
    }

    @PostMapping("/create")
    public ResponseEntity<HelloRequest> createHello(@RequestBody HelloRequest request){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
