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
public class DemoCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do {
            CustomerList list = new CustomerList();
            System.out.println("1. Find Name");
            System.out.println("2. Add");
            System.out.println("3. Insert");
            System.out.println("4. Get by position");
            System.out.println("5. Find id");
            System.out.println("6. Sort");
            System.out.println("0. Quit");
            System.out.println("Enter selection: ");
            String buf = sc.nextLine();
            choose = Integer.parseInt(buf);
            switch (choose) {
                case 1:
                {
                    System.out.println("Enter name to find");
                    list.findByName(buf);
                    break;
                }
                case 2:
                {
                    Customer c = new Customer();
                    c.input();
                    list.add(c);
                    break;
                }
                case 3:
                {
                    Customer c = new Customer();
                    c.input();
                    System.out.println("Enter position: ");
                    int pos = Integer.parseInt(buf);
                    list.insert(c, pos);
                    break;
                }
                case 4:
                {
                    System.out.println("Enter position: ");
                    int pos = Integer.parseInt(buf);
                    list.get(pos);
                    break;
                }
                case 5:
                {
                    System.out.println("Enter Id: ");
                    int id = Integer.parseInt(buf);
                    list.findById(id);
                    break;
                }
                case 6:
                {
                    list.sortByName();
                    break;
                }
                default:
                    break;
            }
    
        } while (choose!=0);
    }
    
}
