/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.lang.Boolean;

/**
 *
 * @author Morgan
 */
public class Notas {
    
    private String hastagNota;
    private String tituloNota;
    private String fechaCreacion;
    private int notaborrada;
    private String textoNota;
    private int idUsuario;
    private int idNota;

    public Notas(){
        
        
    }

    public Notas(String hastagNota, String tituloNota, String fechaCreacion, int notaborrada, String textoNota, int idUsuario,int idNota) {
        this.hastagNota = hastagNota;
        this.tituloNota = tituloNota;
        this.fechaCreacion = fechaCreacion;
        this.notaborrada = notaborrada;
        this.textoNota = textoNota;
        this.idUsuario = idUsuario;
        this.idNota=idNota;
    }
    
    public Notas(int idUsuario){
        this.idUsuario= idUsuario;
    }

    
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getIdNota() {
        return idNota;
    }
    
    

    public String getHastagNota() {
        return hastagNota;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getNotaborrada() {
        return notaborrada;
    }

    public String getTextoNota() {
        return textoNota;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setHastagNota(String hastagNota) {
        this.hastagNota = hastagNota;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNotaborrada(int notaborrada) {
        this.notaborrada = notaborrada;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    
    
    public void setTextoNota(String textoNota) {
        this.textoNota = textoNota;
    }

    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }
    
    
    
    
    
    
     
            
}
