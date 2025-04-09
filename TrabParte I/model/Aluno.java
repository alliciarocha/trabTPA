package model;

public class Aluno{
    private int matricula;
    private String nome;
    private float nota;

    public Aluno(int matricula, String nome, float nota){
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Aluno: " + this.nome + "," + "Matrícula: " + this.matricula + "," + "Nota" + this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Aluno outro = (Aluno) obj;
        return this.matricula == (outro.getMatricula());
    }
}
