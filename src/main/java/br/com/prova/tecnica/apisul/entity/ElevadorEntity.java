package br.com.prova.tecnica.apisul.entity;

public class ElevadorEntity {

    private int andar;
    private String elevador;
    private String turno;

    public int getAndar() {
        return andar;
    }

    public String getElevador() {
        return elevador;
    }

    public String getTurno() {
        return turno;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public void setElevador(String elevador) {
        this.elevador = elevador;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "ElevadorEntity{" + "andar=" + andar + ", elevador='" + elevador + '\'' + ", turno='" + turno + '\''
                + '}';
    }
}
