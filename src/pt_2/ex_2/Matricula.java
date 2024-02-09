package pt_2.ex_2;

public class Matricula {
    private Alumne alumne;
    private Modul modul;
    private float nota;

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public Modul getModul() {
        return modul;
    }

    public void setModul(Modul modul) {
        this.modul = modul;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    public Matricula(Alumne alumne, Modul modul, float nota) {
        setAlumne(alumne);
        setModul(modul);
        setNota(nota);
    }
}
