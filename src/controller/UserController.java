/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import IdGenerator.UserIdGenerator;
import models.UserModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import persistence.UserDbContext;
import java.sql.ResultSet;

/**
 *
 * @author raposo
 */
public class UserController {
    
    private UserDbContext UserDbcontext_ = new UserDbContext();
    
    
    
public void insertUser(String name, String email, String password, Boolean isManager) throws SQLException {
    UserModel user = new UserModel(name, email, password, isManager);
    UserIdGenerator idGenerator = new UserIdGenerator();
    user.setId(idGenerator.IdGenerator());
    
    String query = "INSERT INTO users (id, name, email, password, manager) VALUES (?, ?, ?, ?, ?)";
    
    try (Connection conn = UserDbcontext_.ConnectDb(); 
        PreparedStatement PSdata = conn.prepareStatement(query)) {
        
        PSdata.setInt(1, user.getId());
        PSdata.setString(2, user.getName());
        PSdata.setString(3, user.getEmail());
        PSdata.setString(4, user.getPassword());
        PSdata.setBoolean(5, user.getManager());

        PSdata.executeUpdate();
        System.out.println("Usuário inserido com sucesso!");
    }
}

    
    public List<UserModel> getUsers() throws SQLException{
        List<UserModel> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection conn = UserDbcontext_.ConnectDb(); 
            PreparedStatement PSdata = conn.prepareStatement(query); 
            ResultSet RSdata = PSdata.executeQuery()) {

            while (RSdata.next()) {
                UserModel user = new UserModel(RSdata.getString("name"),
                        RSdata.getString("email"),
                        RSdata.getString("password"),
                        RSdata.getBoolean("manager"));
                
                users.add(user);
            }
        }

        return users;
    }
    
   public UserModel getByID(int Id) throws SQLException {
    String query = "SELECT * FROM users WHERE id="+Id;
    
    try (Connection conn = UserDbcontext_.ConnectDb(); 
        PreparedStatement PSdata = conn.prepareStatement(query)) {
         
        ResultSet RSdata = PSdata.executeQuery();
        
        if (RSdata.next()) {
            UserModel user = new UserModel(RSdata.getString("name"),
                        RSdata.getString("email"),
                        RSdata.getString("password"),
                        RSdata.getBoolean("manager"));
            return user;
        }
    }
        return null;
    }
   
    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id ="+id;
        if(getByID(id)!=null){
            try (Connection conn = UserDbcontext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Usuário deletado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Usuário não encontrado.");
                return false;
            }
    }
    
    
    public boolean updateUserName(int Id, String name) throws SQLException{
        String query = "UPDATE users SET name ="+name+" WHERE id ="+Id;
        if(getByID(Id)!=null){
            try (Connection conn = UserDbcontext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Usuário atualizado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Usuário não encontrado.");
                return false;
            }
    }
    
    public boolean updateUserEmail(int Id, String email) throws SQLException{
        String query = "UPDATE users SET email ="+email+" WHERE id ="+Id;
        if(getByID(Id)!=null){
            try (Connection conn = UserDbcontext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Usuário atualizado com sucesso!");
                    PSdata.executeUpdate();
                    return true;
            }}
        else{
                System.out.println("Usuário não encontrado.");
                return false;
            }
                
            }
            

    
    
    public boolean updateUserPassword(int Id, String password) throws SQLException{
        String query = "UPDATE users SET password ="+password+" WHERE id ="+Id;
        if(getByID(Id)!=null){
            try (Connection conn = UserDbcontext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Usuário atualizado com sucesso!");
                    return true;
            }}
        else{
                System.out.println("Usuário não encontrado.");
                return false;
            }
    }
    
    public boolean updateUserPosition(int Id, boolean manager) throws SQLException{
        String query = "UPDATE users SET name ="+manager+" WHERE id ="+Id;
        if(getByID(Id)!=null){
            try (Connection conn = UserDbcontext_.ConnectDb(); 
                PreparedStatement PSdata = conn.prepareStatement(query)) {
                    System.out.println("Usuário atualizado com sucesso!");
                    return true;
            }}
        else{
                System.out.println("Usuário não encontrado.");
                return false;
            }
    }
}
