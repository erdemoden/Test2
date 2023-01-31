package Entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyCustomer extends Customer{

    private String companyName;
    public CompanyCustomer(int id, LocalDate registrationDate, String companyName,Bill... bills) {
        super(id, registrationDate, bills);
        this.companyName = companyName;
    }
}
