package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotNull
    @NotEmpty(message = "name required")
    @Size(min=3, max=15 ,message = "name size must be between 3 and 15")
    private String username;

    @NotNull
    @NotEmpty(message = "email required")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "password must be required")
    @Size(min=3,max=6,message = "Password must be 6 characters long")
    private String password;

    //bonus
    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {

    }

   /* public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }
*/
    // Bonus
   public User(String username, String email, String password, String verifyPassword) {
       this();
       this.username = username;
       this.email = email;
       this.password = password;
       this.verifyPassword=verifyPassword;
   }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    //Bonus

    public void setVerifyPassword(String verifyPassword){
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public String getVerifyPassword(){
        return verifyPassword;
    }

    private void checkPassword(){
       if(!password.equals(verifyPassword) && password !=null && verifyPassword !=null){
           verifyPassword =null;
       }

    }
}
