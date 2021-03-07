package id.bmri.induction.be.day2.be.induction.be.day2.service.impl;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.PersonDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.request.PersonRequest;
import id.bmri.induction.be.day2.be.induction.be.day2.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PersonServiceImpl implements PersonService {
    List<PersonDto> personDtos = new ArrayList<>();

    public List<PersonDto> getPersonDtos() {
        personDtos.clear();
        personDtos.add(new PersonDto(1,"Ismatul Maula","23"));
        personDtos.add(new PersonDto(2,"Ahmad Zulfikar ","23"));
        personDtos.add(new PersonDto(3,"Noorman","23"));
        personDtos.add(new PersonDto(4,"Ari Anu","23"));
        personDtos.add(new PersonDto(5,"Kevin Gowtama","23"));
        personDtos.add(new PersonDto(6,"Muhammad Anang Zamroni","23"));
        personDtos.add(new PersonDto(7,"Mario Orlando","23"));
        personDtos.add(new PersonDto(8,"Celcy","23"));
        personDtos.add(new PersonDto(9,"Muhammad Ilham","23"));
        personDtos.add(new PersonDto(10,"Bimo Asward","23"));
        personDtos.add(new PersonDto(11,"Izaza Azwa Ramadhana","23"));
        personDtos.add(new PersonDto(12,"Rifkiansyah Meidian Cahyaatmaja","23"));
        personDtos.add(new PersonDto(13,"Azda Firmansyah ","23"));
        return personDtos;
    }

    @Override
    public List<PersonDto> getList(String nama) {
        List<PersonDto> personDtos = getPersonDtos();

        if(!ObjectUtils.isEmpty(nama)) {
            List<PersonDto> personDtoSearch =new ArrayList<>();
            for (PersonDto personDto : personDtos) {
                if (personDto.getNama().toLowerCase().contains(nama.toLowerCase())) {
                    personDtoSearch.add(new PersonDto(personDto.getId(), personDto.getNama(), personDto.getUmur()));
                }
            }
            return personDtoSearch;
        }

        return personDtos;
    }

    @Override
    public PersonDto getDetail(int id) {

        List<PersonDto> personDtos = getPersonDtos();
        try {
            return personDtos.get(id-1);
        }
        catch (IndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data Not Found");
        }


    }


    @Override
    public Boolean create(PersonRequest request) {

        validate(request);
        Random rand = new Random();
        PersonDto personDto = new PersonDto(rand.nextInt(100),request.getNama(),request.getUmur());

        return (!ObjectUtils.isEmpty(personDto.getId()));
    }

    @Override
    public PersonDto createReturnValue(PersonRequest request) {

        validate(request);

        Random rand = new Random();

        return new PersonDto(rand.nextInt(100),request.getNama(),request.getUmur());
    }



    private void validate(PersonRequest request){

            if (ObjectUtils.isEmpty(request.getNama())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nama is Mandatory");
            }

            if (ObjectUtils.isEmpty(request.getUmur())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Umur is Mandatory");
            }


    }


}
