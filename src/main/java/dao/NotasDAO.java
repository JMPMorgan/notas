/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Notas;
import utilis.DbConnect;

/**
 *
 * @author Morgan
 */
public class NotasDAO {

    public static int IDUSUARIO=0;
    /**CREATE DEFINER=`root`@`localhost` PROCEDURE `GetNotas`(
    IN `pidUsuario` int)
    BEGIN
	SELECT 
    n.hastagNota as hastag,
    n.tituloNota as titulo,
    n.fechaCreacion as fecha,
    n.notaBorrada as borrada,
    n.textoNota as nota,
    n.idUsuario as idusuario
	FROM notas n
    WHERE  n.idUsuario= pidUsuario
    ORDER BY n.fechaCreacion ;

    END*/
 public static List<Notas> notas = new ArrayList<>();    
 public static List<Notas> notas_buscador= new ArrayList<>();
    public static List<Notas> getNotas(int idUser){
        Connection con = null;
        try{
          con = DbConnect.getConnection();
          String sql = "CALL GetNotas(?)";
          CallableStatement statement = con.prepareCall(sql);
          statement.setInt(1, idUser);
          ResultSet result =statement.executeQuery();
          notas.clear();
          while(result.next()){
              if(result.getInt("borrada")==0){
              String hastag = result.getString("hastag");
              String titulo = result.getString("titulo");
              String fechaCreacion = result.getString("fecha");
              int borrada = result.getInt("borrada");
              String textoNota= result.getString("nota");
              int idUsuario = result.getInt("idusuario");
              int idNota=result.getInt("idnota");
              IDUSUARIO=idUsuario;
              notas.add(new Notas(hastag, titulo, fechaCreacion, borrada, textoNota, idUsuario,idNota));
              }
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
            return notas;
        }
    }
    
    public static List<Notas> sendNotas(){
        return notas;
    }
    
    /**CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertNote`(
    IN `ptituloNota` varchar(50),
    IN `phastagNota` varchar(50),
    IN `pfechaCreacion` datetime,
    in `ptextoNota` text,
    in `pnotaBorrada` tinyint,
    in `pidUsuario` int
    )
    BEGIN
    INSERT INTO notas
    (`hastagNota`,
    `tituloNota`,
    `fechaCreacion`,
    `notaBorrada`,
    `textoNota`,
    `idUsuario`)
    VALUES
    (phastagNota,
    ptituloNota,
    pfechaCreacion,
    pnotaBorrada,
    ptextoNota,
    pidUsuario);
    END*/
    
    public static int insertNota(Notas notas){
        Connection con=null;
        try{
            con = DbConnect.getConnection();
            String query ="CALL InsertNote(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(query);
            statement.setString(1,notas.getTituloNota());
            statement.setString(2,notas.getHastagNota());
            statement.setString(3,notas.getFechaCreacion());
            statement.setString(4,notas.getTextoNota());
            statement.setInt(5,notas.getNotaborrada());
            statement.setInt(6,notas.getIdUsuario());
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
    /**CREATE DEFINER=`root`@`localhost` PROCEDURE `GetNota`(
    IN `pidUsuario` int,
    IN `pfechaCreacion` datetime)
    BEGIN
    SELECT 
    n.hastagNota as hastag,
    n.tituloNota as titulo,
    n.fechaCreacion as fecha,
    n.notaBorrada as borrada,
    n.textoNota as nota,
    n.idUsuario as idusuario,
    n.idnotas as idnotas
	FROM notas n
    WHERE  n.idUsuario= pidUsuario and n.fechaCreacion=pfechaCreacion;

    END*/
    
    public static Notas getNota(int idUser,int idNotas){
          Connection con =null;
             try{
          con = DbConnect.getConnection();
          String sql = "CALL GetNota(?,?)";
          CallableStatement statement = con.prepareCall(sql);
          statement.setInt(1, idUser);
          statement.setInt(2, idNotas);
          ResultSet result =statement.executeQuery(); 
          if(result.next()){
              
              String hastag = result.getString("hastag");
              String titulo = result.getString("titulo");
              String fechaCreacionDB = result.getString("fecha");
              int borrada = result.getInt("borrada");
              String textoNota= result.getString("nota");
              int idUsuario = result.getInt("idusuario");
              int idNota= result.getInt("idnotas");
              return new Notas(hastag, titulo, fechaCreacionDB, borrada, textoNota, idUsuario,idNota);
              
          }
        }catch(SQLException ex){
             System.out.println(ex.getMessage());
        }finally{
          if(con!=null){
              try {
                  con.close();
              } catch (SQLException ex) {
                   System.out.println(ex.getMessage());
              }
              
          }
        }  
         return null;
    }
    
    public static List<Notas> busquedaNota(int idUser, String texto){
        Connection con =null;
        try{
          con = DbConnect.getConnection();
          String sql = "CALL BuscarNota(?,?)";
          CallableStatement statement = con.prepareCall(sql);
          statement.setInt(1, idUser);
          statement.setString(2, texto);
          ResultSet result =statement.executeQuery(); 
          notas_buscador.clear();
          while(result.next()){
              String hastag = result.getString("hastag");
              String titulo = result.getString("titulo");
              String fechaCreacionDB = result.getString("fecha");
              int borrada = result.getInt("borrada");
              String textoNota= result.getString("nota");
              int idUsuario = result.getInt("idusuario");
              int idNota= result.getInt("idnotas");
              notas_buscador.add(new Notas(hastag, titulo, fechaCreacionDB, borrada, textoNota, idUsuario,idNota));
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
    public static List<Notas> sendNotaBuscador(){
        return notas_buscador;
    }
    
    public static int updateNota(int idUser,int idNota,String titulo,String hastag,String texto){
         Connection con =null;
         try{
            con = DbConnect.getConnection();
            String sql = "CALL EditNota(?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1,idUser);
            statement.setInt(2,idNota);
            statement.setString(3,titulo);
            statement.setString(4,hastag);
            statement.setString(5,texto);
            return statement.executeUpdate();            
         }catch(SQLException ex){
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
    
    public static int deleteNota(int idUser,int idNota){
        Connection con =null;
        try{
             con = DbConnect.getConnection();
             String sql="CALL DeleteNota(?,?)";
             CallableStatement statement = con.prepareCall(sql);
             statement.setInt(1,idUser);
             statement.setInt(2,idNota);
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
