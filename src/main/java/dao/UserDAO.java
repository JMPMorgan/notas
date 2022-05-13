/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;
import utilis.DbConnect;

/**
 *
 * @author Morgan
 */

public class UserDAO {
    private static int iduser;
    private int IDUser;

    public int getIDUser() {
        IDUser=iduser;
        return IDUser;
    }
    
    public static int insertUser(User user){//RETORNA UN 1 si se ingresa correctamente o un 0 si no
        Connection con =null;
        try{
        con = DbConnect.getConnection();
        String fecha="2021-09-26";
        String imagen="assets/images/profile.png";
        String query="CALL InsertUser(?,?,?,?,?,?,?)";
        CallableStatement statement = con.prepareCall(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getName());
        statement.setString(3, user.getName());
        statement.setString(4, fecha);
        statement.setString(5,user.getEmail());
        statement.setString(6,user.getPassword());
        statement.setString(7,imagen);
        return statement.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
        return 0;
    }
    
        /**USE `prueba`;
DROP procedure IF EXISTS `InsertUser`;

DELIMITER $$
USE `prueba`$$
CREATE PROCEDURE `InsertUser` (
IN `puser` varchar(50),
IN `pnombreUsuario` varchar(50),
IN `papellidoUsuario` varchar(50),
IN `pfechaNacimiento` date,
IN `pemailUsuario` varchar(50),
IN `ppasswordUsuario` varchar(100),
IN `pimagenUsuario` varchar(120)
)
BEGIN
INSERT INTO usuarios
(`nombreUsuario`,
`apellidoUsuario`,
`fechaNacimiento`,
`emailUsuario`,
`passwordUsuario`,
`imagenUsuario`,
`user`)
VALUES
(pnombreUsuario,
papellidoUsuario,
pfechaNacimiento,
pemailUsuario,
ppasswordUsuario,
pimagenUsuario,
puser);

END$$

DELIMITER ;
*/
    public static User logInUser(User user){
        Connection con=null;
        try {
            con = DbConnect.getConnection();
            String query="CALL LogInUser(?,?)";
            CallableStatement statement = con.prepareCall(query);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet resultSet =statement.executeQuery();
            while(resultSet.next()){
                int ID = resultSet.getInt("ID");
                iduser=ID;
                String username = resultSet.getString("user");
                String imagen=resultSet.getString("imagen");
                return new User(ID,username,imagen);
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        finally{
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
        return null;
    }
/** USE `prueba`;
DROP procedure IF EXISTS `LogInUser`;

DELIMITER $$
USE `prueba`$$
CREATE PROCEDURE `LogInUser` (
IN `pUser` varchar(50),
IN `pPasswordUsuario` varchar(100)
)
BEGIN
SELECT u.idUsuarios as ID,
    u.user 
FROM usuarios u
WHERE u.user = pUser
AND u.passwordUsuario = pPasswordUsuario;
END$$*/
    
    public static User getInfoUsuario(int id){
        Connection con=null;
        try{
            con = DbConnect.getConnection();
            String query="CALL GetUserInfo(?)";
            CallableStatement statement = con.prepareCall(query);
            statement.setInt(1, id);
            ResultSet result= statement.executeQuery();
            if(result.next()){
                String name= result.getString("nombre");
                String lastname= result.getString("apellido");
                String password= result.getString("password");
                String fecha=result.getString("fecha");
                String email=result.getString("email");
                String imagen=result.getString("imagen");
                String username=result.getString("user");
                return new User(name,lastname,password,fecha,email,imagen,username);
            }
            
        }
        catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
        finally{
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
        return null;
    }
    public static int updateUser(User user){
       Connection con=null;
        try{
            con = DbConnect.getConnection();
            String query = "CALL EditUser(?,?,?,?,?,?,?)";
            CallableStatement statement= con.prepareCall(query);
            statement.setInt(1, user.getID());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastname());
            statement.setString(4,user.getFecha());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getImagen());
            return statement.executeUpdate();
        }
        catch(SQLException ex){
              System.out.println(ex.getMessage());
            
        }
        finally{
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
        return 0;
    }
}


