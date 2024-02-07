package pt_2.contractes;

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

    @Override
    public String toString() {
        return "Empresa{" +
                "cif='" + cif + '\'' +
                ", nom='" + nom + '\'' +
                ", sectorEmpresarial='" + sectorEmpresarial + '\'' +
                '}';
    }
}
