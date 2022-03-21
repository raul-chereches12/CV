package pack_carte;

public class Carte {
    private int valoare;
    private String culoare;
    private String denumire;


    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }


    public String afisareCarte() {
        return "Carte{" +
                "valoare=" + valoare +
                ", culoare='" + culoare + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }

    public String afisareNumeComplet() {

        return valoare + " " + culoare + " " + denumire;
    }
}
