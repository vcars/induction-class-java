package id.bmri.induction.be.day2.be.induction.be.day2.model.dto;

import lombok.Data;


@Data
public class PersonDto {
    Integer id;
    String nama;
    String umur;


    public PersonDto(Integer id, String nama, String umur) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
    }



}
