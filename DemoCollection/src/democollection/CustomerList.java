/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Thanh Sang
 */
public class CustomerList {
    List<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<>();
    }
    
    public void add(Customer cust){
        customers.add(cust);
    }
    
    public void insert(Customer cust,int pos){
        customers.add(pos, cust);
    }
    
    public Customer get(int pos){
        return customers.get(pos);
    }
    
    public Customer findById(int id){
        Customer cust = null;
//        for (Customer cust : customers) {
//            if(cust.getId()==id){
//                c=cust;
//                break;
//            }
//        }
//        return c;
        
        Optional<Customer> opCust =customers.stream()
                .filter(c->c.getId()==id)
                .findFirst();
        if(opCust.isPresent()){
            cust = opCust.get();
        }
        return cust;
    }
    
    public List<Customer> findByName(String name){
//        List<Customer> result = new ArrayList<>();
//        for (Customer customer : customers) {
//            if(customer.getName().contains(name)){
//                result.add(customer);
//            }
//        }
//        return result;
        return customers.stream()
                .filter(c->c.getName().contains(name))
//                .sorted()   // them sap xep
                .collect(Collectors.toList());
    }
    
    public void sortByName(){
        customers.sort((a,b)->a.getName().compareTo(b.getName()));
    }
}
