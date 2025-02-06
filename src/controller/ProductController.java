/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import IdGenerator.ProductIdGenerator;
import IdGenerator.UserIdGenerator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ProductModel;
import models.UserModel;
import persistence.ProductDbContext;

/**
 *
 * @author raposo
 */

public class ProductController {
    
    private ProductDbContext productDbContext_ = new ProductDbContext();
    private List<ProductModel> _productModel;
    
    public void insertProduct(String name, int stockNumber) throws SQLException{
        ProductModel product = new ProductModel(name, stockNumber);
        ProductIdGenerator idGenerator = new ProductIdGenerator();
        product.setId(idGenerator.IdGenerator());

        String query = "INSERT INTO users (id, name, email, password, manager) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = productDbContext_.ConnectDb(); 
            PreparedStatement PSdata = conn.prepareStatement(query)) {

            PSdata.setInt(1, product.getId());
            PSdata.setString(2, product.getName());
            PSdata.setInt(3, product.getProductStock());

            PSdata.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        }
    }
    
    public List<ProductModel> getProducts() throws SQLException{
        List<ProductModel> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = productDbContext_.ConnectDb(); 
            PreparedStatement PSdata = conn.prepareStatement(query); 
            ResultSet RSdata = PSdata.executeQuery()) {

            while (RSdata.next()) {
                ProductModel product = new ProductModel(RSdata.getString("name"),
                        RSdata.getInt("quantity"));
                
                products.add(product);
            }
        }

        return products;
    }
    
    public ProductModel getById(int id) throws SQLException{
        String query = "SELECT * FROM products WHERE id="+id;

        try (Connection conn = productDbContext_.ConnectDb(); 
            PreparedStatement PSdata = conn.prepareStatement(query)) {

            ResultSet RSdata = PSdata.executeQuery();

            if (RSdata.next()) {
                ProductModel product = new ProductModel(RSdata.getString("name"),
                            RSdata.getInt("quantity"));
                return product;
            }
        }
            return null;
    }
    
    public boolean deleteProduct(int id) throws SQLException{
        String query = "DELETE FROM products WHERE id ="+id;
        if(getById(id)!=null){
            try (Connection conn = productDbContext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Produto deletado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Produto não encontrado.");
                return false;
            }
    }
    
    public boolean updateProductName(int id, String name) throws SQLException{
        String query = "UPDATE products SET name ="+name+" WHERE id ="+id;
        if(getById(id)!=null){
            try (Connection conn = productDbContext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Produto atualizado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Produto não encontrado.");
                return false;
            }
    }
    
      public boolean updateProductStock(int id, int stock) throws SQLException{
        String query = "UPDATE products SET quantity ="+stock+" WHERE id ="+id;
        if(getById(id)!=null){
            try (Connection conn = productDbContext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Produto atualizado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Produto não encontrado.");
                return false;
            }
    }
}
