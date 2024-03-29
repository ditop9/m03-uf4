package pt_2.ex_5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Contracte {
    private int codi;
    private LocalDate dataIniciContracte;
    private LocalDate dataFinContracte;
    private Empresa empresa;

    public LocalDate getDataIniciContracte() {
        return dataIniciContracte;
    }

    public LocalDate getDataFinContracte() {
        return dataFinContracte;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
    public Contracte(int codi){
        this.codi = codi;
    }
    public double calcularDuradaContracte() {
        return ChronoUnit.DAYS.between(dataIniciContracte, dataFinContracte);
    }
    public Contracte(Empresa empresa) {
        Random random = new Random();
        this.codi = random.nextInt(99999999 - 10000000 + 1) + 10000000;
        this.dataIniciContracte = LocalDate.now();
        this.dataFinContracte = null;
        this.empresa = empresa;
    }
    public Contracte(Empresa empresa, int codi, LocalDate dataIniciContracte, LocalDate dataFinContracte) {
        this.empresa = empresa;
        this.codi = codi;
        this.dataIniciContracte = dataIniciContracte;
        this.dataFinContracte = dataFinContracte;
    }
    public void determinarDuradaContracte(LocalDate dataIniciContracte, LocalDate dataFinContracte){
        this.dataIniciContracte = dataIniciContracte;
        this.dataFinContracte = dataFinContracte;
    }

    @Override
    public String toString() {
        return "Contracte{" +
                "codi=" + codi +
                ", dataIniciContracte=" + dataIniciContracte +
                ", dataFinContracte=" + dataFinContracte +
                ", empresa=" + empresa +
                '}';
    }
}
