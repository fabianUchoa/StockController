/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;
import controller.UserController;
import java.sql.SQLException;
import java.util.List;
import models.UserModel;
import java.util.regex.Pattern;


/**
 *
 * @author raposo
 */
public class UserValidation {
    private UserController userController_ = new UserController();
    
    public boolean loginValidator(String email, String password){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean verify=true;
        if(Pattern.matches(emailRegex, email)==false){
            verify = false;
        }
        
        if(password.length() <8){
            verify = false;
        }
        
        return verify;
    }
    
    public boolean emailValidator(String email){
        boolean isValid;
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        
        isValid = Pattern.matches(emailRegex, email);
        return isValid;
    }
    
    public String userValidator(String email, String password) throws SQLException{
        
        List<UserModel> users = userController_.getUsers();
        
        if(users!=null){
            for(UserModel user : users){
                if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                    if(user.getManager()==true)
                        return "admin";
                    else
                        return "standart";
            }}
        }
        return "unfound";
}}
