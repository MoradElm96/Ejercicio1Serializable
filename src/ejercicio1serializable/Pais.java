/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1serializable;

import java.io.Serializable;

/**
 *
 * @author Morad
 */
public class Pais implements Serializable {
    //tiene que implementar serializable
    
    int id;
    String nombre,capital, idioma;

    public Pais(int id, String nombre, String capital, String idioma) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.idioma = idioma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", nombre=" + nombre + ", capital=" + capital + ", idioma=" + idioma + '}';
    }
    
    
    
}
