/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8_joedsosa;

/**
 *
 * @author joeds
 */
public class Pokemon {
    private String nombre;
    private int vida;
    private int ataque;
    private int azar;
    private int perteneceJugador;
    private boolean eliminado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;

    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAzar() {
        return azar;
    }

    public void setAzar(int azar) {
        this.azar = azar;
    }

    public int getPerteneceJugador() {
        return perteneceJugador;
    }

    public void setPerteneceJugador(int perteneceJugador) {
        this.perteneceJugador = perteneceJugador;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
