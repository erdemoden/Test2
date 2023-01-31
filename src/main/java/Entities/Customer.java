package Entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
public class Customer {

    private int id;
    private List<Bill> bills;
    private LocalDate registrationDate;

   public Customer(int id,LocalDate registrationDate,Bill... bills){
        this.id = id;
        this.bills = new LinkedList<>(Arrays.asList(bills));
        this.registrationDate = registrationDate;
    }
}
