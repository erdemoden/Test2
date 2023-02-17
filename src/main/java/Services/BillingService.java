package Services;

import Entities.Bill;
import Entities.CompanyCustomer;
import Entities.Customer;
import Entities.PersonCustomer;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BillingService {
    private Set<PersonCustomer> personCustomers;
    private Set<CompanyCustomer> companyCustomers;
        public void savePersonCustomer(PersonCustomer customer) {
        personCustomers.add(customer);
        }
        public void saveCompanyCustomer(CompanyCustomer customer){
        companyCustomers.add(customer);
        }
        public void listAllCustomers(){
            System.out.println("Person Customers : ");
            personCustomers.stream().forEach(personCustomer -> {
                System.out.println( "Customer Name : "+
                        personCustomer.getName()+
                        "Customer Surname : "
                        +personCustomer.getSurname()
                        +"Bills : "
                        +personCustomer.getBills().stream().map(bill ->"Bill Id : "+bill.getId()+"Bill Amount : "+bill.getAmount()+"Bill Date : "+bill.getBillDate()));
            });
            System.out.println("--------------------------------------------------");
            System.out.println("Company Customers : ");
            companyCustomers.stream().forEach(companyCustomer -> {
                System.out.println( "Customer Name : "+
                        companyCustomer.getCompanyName()+
                        "Customer Sector : "
                        +companyCustomer.getSector()
                        +"Bills : "
                        +companyCustomer.getBills().stream().map(bill ->"Bill Id : "+bill.getId()+"Bill Amount : "+bill.getAmount()+"Bill Date : "+bill.getBillDate()));
            });
        }

        public void personCustomerWithC(){
            System.out.println("Customers with c in their names");
           Set<PersonCustomer> customers = personCustomers.stream().filter(personCustomer -> personCustomer.getName().contains("c")).collect(Collectors.toSet());
           customers.stream().forEach(customer->{
               System.out.println(customer.getName());
           });
        }
        public void personCustomersFromJune(){
            double total = 0.0;
         Set<PersonCustomer> customers = personCustomers.stream().filter(personCustomer -> {return personCustomer.getRegistrationDate().getMonth() == Month.JUNE;}).collect(Collectors.toSet());
         for(Customer customer:customers){
             total+= customer.getBills().stream().map(bill -> bill.getAmount()).reduce(0.0,Double::sum);
         }
            System.out.println("Total Amount Of Customers Registered On June : "+total);
        }
        public void AllBills(){
            System.out.println("Person Customers : ");
            personCustomers.stream().forEach((c)->{
                c.getBills().stream().forEach((b)->{
                    System.out.println(b.getId()+" : "+b.getAmount()+" : "+b.getBillDate());
                });
            });
            System.out.println("Company Customers : ");
          companyCustomers.stream().forEach((c)->{
              c.getBills().stream().forEach((b)->{
                  System.out.println(b.getId()+" : "+b.getAmount()+" : "+b.getBillDate());
              });
          });
    }
    public void aboveOneThousandFiveHundred(){
        System.out.println("Person Customers : ");
            personCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).forEach(bill -> {
                System.out.println(bill.getId()+" : "+bill.getAmount()+" : "+bill.getBillDate());
            });
        System.out.println("Company Customers : ");
            companyCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).forEach(bill -> {
                System.out.println(bill.getId()+" : "+bill.getAmount()+" : "+bill.getBillDate());
            });
        }
        public  void avgAboveOneThousandAndFiveHundred(){
            double total = 0.0;
            int count = 0;
           total+= personCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).map(bill -> bill.getAmount()).reduce(0.0,Double::sum);
            total+= companyCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).map(bill -> bill.getAmount()).reduce(0.0,Double::sum);
            count+=personCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).count();
            count+=companyCustomers.stream().flatMap(c->c.getBills().stream().filter(bill -> bill.getAmount()>1500)).count();
            System.out.println("Average of  customers with bills above price of 1500");
            System.out.println(total/count);
        }

        public void customersBelowFiveHundred(){
            for(PersonCustomer personCustomer:personCustomers){
               List<Bill> bills = personCustomer.getBills().stream().filter(bill -> bill.getAmount()<500).collect(Collectors.toList());
               if(bills.size()>0) {
                   System.out.println(personCustomer.getName());
               }
            }
        }
        public void billsOnJuneBelow750(){
            for(CompanyCustomer companyCustomer: companyCustomers){
                List<Bill> bills = companyCustomer.getBills().stream().filter(bill -> bill.getBillDate().getMonth() == Month.JUNE && bill.getAmount()<750).collect(Collectors.toList());
                if(bills.size()>0){
                    System.out.println(companyCustomer.getSector());
                }
            }
    }
}

