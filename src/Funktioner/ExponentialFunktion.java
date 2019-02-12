package Funktioner;

public class ExponentialFunktion extends Funktion {
    private double C;
    private double a;

    public ExponentialFunktion(double c, double a) {
        C = c;
        this.a = a;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double fAv(double x){
        return C*Math.pow(a,x);
    }
}
