package pt_2.ex_5;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Empleat {
    private ArrayList<Contracte> contractesDeLaPersona = new ArrayList<>();
    private String dni;
    private String nom;

    public String getDni() {
        return dni;
    }
    public void imprimirContractes(){
        for (int i = 0; i < contractesDeLaPersona.size(); i++) {
            System.out.println((i + 1) + ". " + contractesDeLaPersona.get(i));
        }
    }
    public void afegirNouContracte(Contracte contracte) {
        contractesDeLaPersona.add(contracte);
    }
    public long determinarDuradaTotalContractes(){
        long diesTotals = 0;
        for (Contracte contracte : contractesDeLaPersona) {
            diesTotals += ChronoUnit.DAYS.between(contracte.getDataIniciContracte(), contracte.getDataFinContracte());
        }
        return diesTotals;
    }
    public Empleat(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }
    public void signarNouContracte() {
        Empresa empresa = Empresa.generarEmpresa();
        Contracte contracte = new Contracte(empresa);
        contractesDeLaPersona.add(contracte);
    }
    public int determinarQuantitatEmpresesTreballades() {
        ArrayList<Empresa> empresesComptador = new ArrayList<>();
        for (Contracte contracte : contractesDeLaPersona) {
            boolean esTroba = false;
            for (Empresa empresa : empresesComptador) {
                if (contracte.getEmpresa().getCif().equals(empresa.getCif())) {
                    esTroba = true;
                    break;
                }
            }
            if (!esTroba) {
                empresesComptador.add(contracte.getEmpresa());
            }
        }
        return empresesComptador.size();
    }
}