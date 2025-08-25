package model;

public class Agendamento {
    private String nomePet;
    private String especie;
    private String nomeDono;
    private String telefoneDono;
    private Byte horarioBanho;

    public Agendamento() {
    }

    public String getNomePet() {
        return nomePet;
    }
    public void setNomePet(String nome) {
        this.nomePet = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Byte getHorarioBanho() {
        return horarioBanho;
    }
    public void setHorarioBanho(Byte horarioBanho) {
        this.horarioBanho = horarioBanho;
    }

    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getTelefoneDono() {
        return telefoneDono;
    }
    public void setTelefoneDono(String telefoneDono) {
        this.telefoneDono = telefoneDono;
    }
}