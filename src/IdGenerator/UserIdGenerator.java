/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IdGenerator;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import models.UserModel;
import java.util.ArrayList;
import java.util.List;
import persistence.UserDbContext;
import java.sql.ResultSet;
/**
 *
 * @author raposo
 */
public class UserIdGenerator {
    
    private UserDbContext userDbContext_ = new UserDbContext();
    private ResultSet RSdata;
    
    
    public int IdGenerator () throws SQLException{
        String query = "SELECT MAX(Id) FROM users";
        int id=0;
        try(Connection conn = userDbContext_.ConnectDb(); 
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
