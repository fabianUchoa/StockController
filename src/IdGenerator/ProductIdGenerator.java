/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IdGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import models.ProductModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistence.ProductDbContext;

/**
 *
 * @author raposo
 */
public class ProductIdGenerator {
    private ResultSet RSdata;
    private ProductDbContext ProductDbContext_ = new ProductDbContext();
    
    public int IdGenerator () throws SQLException{
        String query = "SELECT MAX(Id) FROM products";
        int id = 0;
        try(Connection conn = ProductDbContext_.ConnectDb(); 
            PreparedStatement PSdata = conn.prepareStatement(query)){
            RSdata = PSdata.executeQuery();
            while (RSdata.next())
                id = RSdata.getInt("max");

        }

            if(id==0){
                return 1;
            }else{
                return id+1;
            }
    }


    
}
