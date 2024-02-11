package pt_1.ex_1_2_3;

public class PermisTest {
    public static void main(String[] args) {
        PermisConduir permis1 = new PermisConduir();
        permis1.setNom("Diego");
        permis1.setTipusPermis("B");
        permis1.setPunts(15);
        String nomPermis1 = permis1.getNom();
        String tipusPermis1 = permis1.getTipusPermis();
        int puntsPermis1 = permis1.getPunts();
        permis1.restarPunts(7);
        permis1.imprimirPermis();
        System.out.println(nomPermis1);
        System.out.println(tipusPermis1);
        System.out.println(puntsPermis1);

        PermisConduir permis2 = new PermisConduir();
        permis2.setNom("Carlos");
        permis2.setTipusPermis("A2");
        permis2.setPunts(12);
        String nomPermis2 = permis2.getNom();
        String tipusPermis2 = permis2.getTipusPermis();
        int puntsPermis2 = permis2.getPunts();
        permis2.restarPunts(2);
        permis2.imprimirPermis();
        System.out.println(nomPermis2);
        System.out.println(tipusPermis2);
        System.out.println(puntsPermis2);
    }
}
