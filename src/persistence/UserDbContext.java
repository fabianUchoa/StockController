/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.PreparedStatement;

/**
 *
 * @author raposo
 */
public class UserDbContext {
    private Connection connection = null;
    private ResultSet RSdata = null;
    private PreparedStatement PSTdata = null;
    
    public Connection ConnectDb() throws SQLException{
        try{
            String user = "postgres";
            String password = "raposo";
            Class.forName("org.postgresql.Driver");
            String urlConnection = "jdbc:postgresql://localhost:5432/InventoryManagement";
                    
            connection = DriverManager.getConnection(
                    urlConnection,
                    user,
                    password
            );
            
            connection.setAutoCommit(true);
        }catch(ClassNotFoundException e){
            throw new SQLException("Falha ao carregar o driver JBDC/OBDC." + e);
            
        }catch(SQLException e){
            System.out.println("Falha na conexão, coamndo sql = "+ e);
            throw e;
            
        }

        return connection;
}
    
    public void selectUsers(String queryData) throws SQLException{

        PSTdata = connection.prepareStatement(queryData);
        RSdata = PSTdata.executeQuery();
        while (RSdata.next()) {
            int id = RSdata.getInt("id");
            String nome = RSdata.getString("name");
            String email = RSdata.getString("email");
            Boolean Manager = RSdata.getBoolean("manager");
            System.out.println("ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nManager: " + Manager + "\n-------------------------------------------");
        }
    }
    
    public void insertUser(int id, String name, String email, String password, Boolean manager) throws SQLException{
        String query = "INSERT INTO users (id, name, email, password, manager) VALUES(?,?,?,?,?)";
        
        PSTdata = connection.prepareStatement(query);
        
        PSTdata.setInt(1, id);
        PSTdata.setString(2, name);
        PSTdata.setString(3, email);
        PSTdata.setString(4, password);
        PSTdata.setBoolean(5, manager);
        
        PSTdata.executeUpdate();

        PSTdata.close();
    }
    
    public void deleteUser(int id) throws SQLException{
        String query = "DELETE FROM users WHERE id="+id;
        
        PSTdata = connection.prepareStatement(query);
        
        PSTdata.executeUpdate();
   
        PSTdata.close();
        
    }
    
    public void updateUser(String query) throws SQLException{
        PSTdata = connection.prepareCall(query);
        
        PSTdata.executeUpdate();

        PSTdata.close();
    }
    
    
}


