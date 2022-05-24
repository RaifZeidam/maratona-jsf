package br.com.devdojo.maratonajsf.model;

import br.com.devdojo.maratonajsf.model.enums.Turno;

/**
 * Created by Bakawaii on 23/05/2022.
 */
public class Estudante {
    private String nome = "Raif";
    private String sobrenome = "Zeidam";
    double nota1 = 20;
    double nota2;
    double nota3 = 10;
    private Turno turno = Turno.MATUTINO;

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
}
