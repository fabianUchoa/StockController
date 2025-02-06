/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author raposo
 */
public class ProductDbContext {
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
    
    public void selectProducts(String query) throws SQLException{
        PSTdata = connection.prepareStatement(query);
        RSdata = PSTdata.executeQuery();
        while (RSdata.next()) {
            int id = RSdata.getInt("id");
            String nome = RSdata.getString("name");
            int amount = RSdata.getInt("quantity");
 
            System.out.println("ID: " + id + "\nNome: " + nome + "\nAmount: " + amount + "\n-------------------------------------------");
        }
    }
    
    public void insertProducts(int id, String name, int amount) throws SQLException {
        String query = "INSERT INTO products (id, name, quantity) VALUES(?,?,?)";
        
        PSTdata = connection.prepareStatement(query);
        
        PSTdata.setInt(1, id);
        PSTdata.setString(2, name);
        PSTdata.setInt(3, amount); 
        
        PSTdata.executeUpdate();
        
        PSTdata.close();
    }
    
    public void deleteProducts(int id) throws SQLException{
        String query = "DELETE FROM products WHERE id ="+id;
        
        PSTdata = connection.prepareStatement(query);
        
        PSTdata.executeUpdate();

        PSTdata.close();
    }
    
    public void updateProducts(String query) throws SQLException{
        
        PSTdata = connection.prepareStatement(query);
        
        PSTdata.executeUpdate();
        PSTdata.close();
    }
}
