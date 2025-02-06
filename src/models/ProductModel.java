/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author raposo
 */
public class ProductModel implements java.io.Serializable{
    public int productId;
    public String productName;
    public int productQuantity;
    private static final long serialVersionUID = 05055063L;
    
    public ProductModel(String name, int stockNumber){
        this.productName = name;
        this.productQuantity = stockNumber;
    }
    
    public void setName(String name){
        this.productName = name;
    }
    
    public String getName(){
        return productName;
    }
    
    public void setProductStock(int stockNumber){
        this.productQuantity = stockNumber;
    }
    
    public int getProductStock(){
        return productQuantity;
    }
    
    public void setId(int id){
        this.productId = id;
    }
    
    public int getId(){
        return productId;
    }
    
    public void getInfos(){
        System.out.println("ID.:"+this.productId);
        System.out.println("Nome do produto.:"+this.productName);
        System.out.println("Quantidade.:"+this.productQuantity);
    }
}
