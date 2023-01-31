package Entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonCustomer extends Customer{
    private String name;
    private String surname;
    public PersonCustomer(int id,LocalDate registrationDate,String name,String surname,Bill...bills) {
        super(id, registrationDate,bills);
        this.name = name;
        this.surname = surname;
    }
}
