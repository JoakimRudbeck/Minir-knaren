package Funktioner;

public class Linjär extends Funktion {
    private double k;
    private double m;

    public Linjär(double k, double m) {
        this.k = k;
        this.m = m;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double fAv(double x){
        return k*x+m;
    }
}
