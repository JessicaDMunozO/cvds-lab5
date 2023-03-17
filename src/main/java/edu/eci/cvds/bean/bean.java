package edu.eci.cvds.bean;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean(value = "guessBean")

@ApplicationScoped

public class bean {
    private int numeroAdivinar = (int) (Math.random() * (100000 + 1));
    private int intentos = 0;
    private int premioAcumulado = 100000;
    private String estado = "Jugando";
    private int penalizacionFalla = 10000;

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

    public void guess(int numero) {
        if (numero == numeroAdivinar) {
            setEstado("Ganó");
            System.out.println(getEstado() + " $" + getPremioAcumulado());
        } else {
            intentos += 1;
            if (premioAcumulado > penalizacionFalla) {
                premioAcumulado -= penalizacionFalla;
            } else {
                setEstado("Perdió");
                System.out.println(getEstado() + " $0");
            }
        }
    }

    public void restart() {
        setNumeroAdivinar((int) (Math.random() * (100000 + 1)));
        setPremioAcumulado(100000);
        setEstado("Jugando");
    }

}
