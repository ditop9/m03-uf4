package pt_2.contractes;

import java.util.ArrayList;

public class Empleat {
    private ArrayList<Contracte> contractesDeLaPersona = new ArrayList<>();
    private String dni;
    private String nom;

    public String getDni() {
        return dni;
    }

    public void afegirNouContracte(Contracte contracte) {
        contractesDeLaPersona.add(contracte);
    }
    public void signarNouContracte(Empresa empresa) {
        Contracte contracte = new Contracte(empresa);
        afegirNouContracte(contracte);
    }
    public Empleat(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }
    public int determinarQuantitatEmpresesTreballades() {
        ArrayList<Empresa>empreses = new ArrayList<>();
        int quantitatEmpreses = 0;
        for (Contracte contracte : contractesDeLaPersona) {
            boolean esRepeteix = false;
            for (Empresa empresa : empreses) {
                if (contracte.getEmpresa().getNom().equals(empresa.getNom())) {
                    esRepeteix = true;
                    break;
                }
            }
            if (!esRepeteix) {
                quantitatEmpreses++;
                empreses.add(contracte.getEmpresa());
            }
        }
        return quantitatEmpreses;
    }
}
