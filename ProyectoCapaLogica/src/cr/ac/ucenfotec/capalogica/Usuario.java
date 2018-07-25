/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucenfotec.capalogica;

import javax.swing.Icon;

/**
 *
 * @author jeffry
 */
public class Usuario {
    
    private String nombre;
    private String apellidos;
    private String correo;
    private Equipo favorito;
    private Icon avatar;
    private String UserName;
    private String clave; //maximo 8 caracteres y minimo 6

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.favorito = favorito;
        this.UserName = UserName;
        this.clave = clave;
    }
    
    

    public Usuario(String nombre, String apellidos, String correo, Equipo favorito, Icon avatar, String UserName, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.favorito = favorito;
        this.avatar = avatar;
        this.UserName = UserName;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Equipo getFavorito() {
        return favorito;
    }

    public void setFavorito(Equipo favorito) {
        this.favorito = favorito;
    }

    public Icon getAvatar() {
        return avatar;
    }

    public void setAvatar(Icon avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return nombre + "," + apellidos + "," + correo + "," + favorito + "," + avatar + "," + UserName + "," + clave;
    }
    
    
    
    
    
}
