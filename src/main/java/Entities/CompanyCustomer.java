package Entities;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyCustomer extends Customer{

    private String companyName;
    private String sector;
    public CompanyCustomer(int id, LocalDate registrationDate, String companyName,String sector,Bill... bills) {
        super(id, registrationDate, bills);
        this.companyName = companyName;
        this.sector = sector;
    }
}
