package edu.eci.cvds.bean;

import java.util.ArrayList;

//import javax.annotation.ManagedBean;
//import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean")

@SessionScoped

public class bean {
    private int numeroAdivinar = (int) (Math.random() * (10 + 1));
    private int intentos = 0;
    private int premioAcumulado = 100000;
    private String estado = "Jugando";
    private int penalizacionFalla = 10000;
    private ArrayList<Integer> listaIntentos = new ArrayList<>();

    public bean() {
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPenalizacionFalla() {
        return penalizacionFalla;
    }

    public void setPenalizacionFalla(int penalizacionFalla) {
        this.penalizacionFalla = penalizacionFalla;
    }

    public ArrayList<Integer> getListaIntentos() {
        return listaIntentos;
    }

    public void setListaIntentos(ArrayList<Integer> listaIntentos) {
        this.listaIntentos = listaIntentos;
    }

    public void guess(int numero) {
        listaIntentos.add(numero);
        intentos += 1;
        if (numero == numeroAdivinar) {
            setEstado("Ganó");
            System.out.println(getEstado() + " $" + getPremioAcumulado());
        } else {
            if (premioAcumulado > penalizacionFalla) {
                premioAcumulado -= penalizacionFalla;
            } else {
                setEstado("Perdió");
                System.out.println(getEstado() + " $0");
            }
        }
    }

    public void restart() {
        setNumeroAdivinar((int) (Math.random() * (10 + 1)));
        setPremioAcumulado(100000);
        setEstado("Jugando");
        setIntentos(0);
        listaIntentos.clear();
    }

}
