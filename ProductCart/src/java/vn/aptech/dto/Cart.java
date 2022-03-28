/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.aptech.dto;

import java.util.ArrayList;
import java.util.List;
import vn.aptech.servlet.ProductServlet;

/**
 *
 * @author Administrator
 */
public class Cart {
    List<CartItem> carts;

    public Cart() {
        carts= new ArrayList<>();
    }
    
    public void addCart (CartItem item){
        if(carts.contains(item)){
            CartItem updatedItem = null;
            for (CartItem ci : carts) {
                if(ci.getProduct().getId()==item.getProduct().getId()){
                    updatedItem = ci;
                    break;
                }
            }
            
            // neu co doi tuong can update
            if(updatedItem != null){
//                updatedItem.setProduct(item.getProduct());
                updatedItem.setQuantity(updatedItem.getQuantity() + item.getQuantity());
            }
        }else{
            carts.add(item);
        }
    }
    
     public void addCart(Product p, int quantity){
        CartItem item = new CartItem(p,quantity);
        addCart(item);
     }
     
      public void addCart(int pid, int quantity){
          Product p = ProductServlet.products.stream()
                  .filter(pp->pp.getId()==pid)
                  .findFirst()
                  .orElse(null);
          addCart(p,quantity);
      }
     
     public List<CartItem> getCarts(){
         return carts;
     }
}
