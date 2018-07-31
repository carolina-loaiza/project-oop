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
    
    private int codigoUsuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private int puntos;
    private Equipo favorito;
    private Icon avatar;
    private String userName;
    private String clave; //maximo 8 caracteres y minimo 6

    public Usuario() {
    }
    
    public Usuario(int codigoUsuario, String nombre, String apellidos, String correo, String UserName, String clave) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.userName = UserName;
        this.clave = clave;
        puntos = 0;
    }

    public Usuario(int codigoUsuario, String nombre, String apellidos, String correo, Equipo favorito, String UserName, String clave) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.favorito = favorito;
        this.userName = UserName;
        this.clave = clave;
        puntos = 0;
    }

    public Usuario(int codigoUsuario, String nombre, String apellidos, String correo, Equipo favorito, Icon avatar, String UserName, String clave) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.favorito = favorito;
        this.avatar = avatar;
        this.userName = UserName;
        this.clave = clave;
        puntos = 0;
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
        return userName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return nombre + "," + apellidos + "," + correo + "," + favorito + "," + avatar + "," + userName + "," + clave;
    }
    
    
}
