/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democollection;

import java.util.Scanner;

/**
 *
 * @author Thanh Sang
 */
public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Input name: ");
        name = sc.nextLine();
        System.out.println("Input email: ");
        email = sc.nextLine();
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
