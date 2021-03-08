package id.bmri.induction.be.day2.be.induction.be.day2.service;

import id.bmri.induction.be.day2.be.induction.be.day2.model.dto.PersonDto;
import id.bmri.induction.be.day2.be.induction.be.day2.model.request.PersonRequest;

import java.util.List;

public interface PersonService {

    List<PersonDto> getList(String nama);
    PersonDto getDetail(int id);
    Boolean create(PersonRequest request);
    PersonDto createReturnValue(PersonRequest request);
    Boolean update(PersonRequest request);
    PersonDto updateReturnValue(PersonRequest request);
    Boolean delete(Integer id);

}
