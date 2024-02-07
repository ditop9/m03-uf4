package pt_2.casa;

import java.util.Objects;

public class Casa {
    private double superficie;
    private String direccio;
    private Sala salaCasa;
    private Cuina cuinaCasa;

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public Sala getSalaCasa() {
        return salaCasa;
    }

    public void setSalaCasa(Sala salaCasa) {
        this.salaCasa = salaCasa;
    }

    public Cuina getCuinaCasa() {
        return cuinaCasa;
    }

    public void setCuinaCasa(Cuina cuinaCasa) {
        this.cuinaCasa = cuinaCasa;
    }

    public Casa(double superficie, String direccio, Sala sala , Cuina cuina){
        setSuperficie(superficie);
        setDireccio(direccio);
        setSalaCasa(sala);
        setCuinaCasa(cuina);
    }

    @Override
    public String toString() {
        return "Casa: \n" +
                "Superfície: " + superficie + " m/2" + "\n" +
                "Direcció: " + direccio + "\n" +
                "Sala de casa: " + salaCasa + "\n" +
                "Cuina de casa: " + cuinaCasa + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Casa casa = (Casa) o;

        if (Double.compare(superficie, casa.superficie) != 0) return false;
        if (!Objects.equals(direccio, casa.direccio)) return false;
        if (!Objects.equals(salaCasa, casa.salaCasa)) return false;
        return Objects.equals(cuinaCasa, casa.cuinaCasa);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(superficie);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (direccio != null ? direccio.hashCode() : 0);
        result = 31 * result + (salaCasa != null ? salaCasa.hashCode() : 0);
        result = 31 * result + (cuinaCasa != null ? cuinaCasa.hashCode() : 0);
        return result;
    }
}
