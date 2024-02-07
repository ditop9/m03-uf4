package pt_2.contractes;

import java.util.Scanner;

public class Empresa {
    private String cif;
    private String nom;
    private String sectorEmpresarial;

    public String getNom() {
        return nom;
    }

    public Empresa(String cif, String nom, String sectorEmpresarial) {
        this.cif = cif;
        this.nom = nom;
        this.sectorEmpresarial = sectorEmpresarial;
    }
    public static Empresa generarEmpresa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el nom de l'empresa.");
        String nom = sc.nextLine();
        System.out.println("Introdueix el CIF de l'empresa.");
        String cif = sc.nextLine();
        System.out.println("Introdueix el sector empresarial de l'empresa");
        String sector = sc.nextLine();
        return new Empresa(cif, nom, sector);
    }
    @Override
    public String toString() {
        return "Empresa{" +
                "cif='" + cif + '\'' +
                ", nom='" + nom + '\'' +
                ", sectorEmpresarial='" + sectorEmpresarial + '\'' +
                '}';
    }
}
