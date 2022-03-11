/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democollection;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Thanh Sang
 */
public class CustomerMap {
    Map<Integer, Customer> customers = new LinkedHashMap<>();

    public void add(Customer cust){
        customers.put(cust.getId(), cust);
    }
    
    public Customer findById(int id){
        return customers.get(id);
    }
    
    public List<Customer> findByName(String name){
        return customers.values().stream()
                .filter(c->c.getName().contains(name))
                .collect(Collectors.toList());
    }
    
    public void delete(Customer cus){
        customers.remove(cus.getId());
    }
}
