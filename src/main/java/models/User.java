/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 * Modelo de Usuario
 * @author Morgan
 */
public class User {
    private String name;
    private String lastname;
    private String password;
    private String cPassword;
    private String email;
    private String username;
    private String imagen;
    private String fecha;
    private int ID;
    
    public User(String name, String password, String cPassword, String email, String username) {
        this.name = name;
        this.password = password;
        this.cPassword = cPassword;
        this.email = email;
        this.username = username;
    }
     public User(int ID,String username){
         this.ID= ID;
         this.username=username;
         
     }      
     public User(String name,String lastname,String password,String fecha,String email, String imagen,String username){
         this.name=name;
         this.lastname=lastname;
         this.password=password;
         this.fecha=fecha;
         this.email=email;
         this.imagen=imagen;
         this.username=username;
     }
     
     public User(int ID,String username , String password){
         this.ID=ID;
         this.username=username;
         this.password=password;
     }
     
     public User(String username,String password){
         this.username=username;
         this.password=password;
     }
     
     public User(int id,String name,String lastname,String email,String password,String imagen,String fecha){
       this.ID=id;
       this.name=name;
       this.lastname=lastname;
       this.email=email;
       this.password=password;
       this.imagen=imagen;
       this.fecha=fecha;
     }

    public String getFecha() {
        return fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public String getLastname() {
        return lastname;
    }
     
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public String getUsername() {
        return username;
    }
    

    public String getName() {
        return name;
    }
     public int getID(){
         return ID;
    }
     
    public void setID(int ID){
        this.ID=ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
     
    
    
    
     
    
}

