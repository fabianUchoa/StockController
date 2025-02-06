/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author raposo
 */
public class UserModel implements java.io.Serializable{
    
    public int id;
    public String name;
    public String email;
    public String password;
    public boolean manager;
    private static final long serialVersionUID = 47582342L;
    
    
    public UserModel(String name, String email, String password, Boolean manager){
        this.name = name;
        this.email = email;
        this.password = password;
        this.manager = manager;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setManager(boolean manager){
        this.manager = manager;
    }
    
    public boolean getManager(){
        return manager;
    }
    
    public void getInfos(){
        System.out.println("ID.:"+this.id);
        System.out.println("Nome.:"+this.name);
        System.out.println("Email.:"+this.email);
    }
}
