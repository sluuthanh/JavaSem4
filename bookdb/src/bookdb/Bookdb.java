/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookdb;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bookdb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BookDal dal = new BookDal();
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        do {            
            System.out.println("1. Create Book");
            System.out.println("2. Display All Book");
            System.out.println("3. Find by Id");
            System.out.println("4. Update Book");
            System.out.println("0. Quit");
            System.out.print("Choose: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:{
                    BookEntity b = new BookEntity();
                    System.out.print("Input title: ");
                    b.setTitle(sc.nextLine());
                    System.out.print("Input price: ");
                    b.setPrice(Integer.parseInt(sc.nextLine()));
                    dal.create(b);
                    break;
                }
                case 2:{
                    dal.findAll().forEach(b->{
                        System.out.println(b);
                    });
                    break;
                }
                case 3:{
                    System.out.print("Input Id: ");
                    int id  = Integer.parseInt(sc.nextLine());
                    BookEntity b = dal.findById(id);
                    System.out.println(b);
                    break;
                }
                case 4:{
                    System.out.print("Input Id: ");
                    int id  = Integer.parseInt(sc.nextLine());
                    BookEntity b = dal.findById(id);
                     System.out.print("Input title: ");
                    b.setTitle(sc.nextLine());
                    System.out.print("Input price: ");
                    b.setPrice(Integer.parseInt(sc.nextLine()));
                    dal.update(b);
                    break;
                }
                    
                default:
                    break;
            }
        } while (choose!=0);
    }
    
}
