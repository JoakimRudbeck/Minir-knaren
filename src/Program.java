import Exceptions.NoSolutionsException;
import Funktioner.Andragradare;
import Funktioner.ExponentialFunktion;
import Funktioner.Funktion;
import Funktioner.Linjär;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    static double step = 0.00000001;
    static double accurancy = 0.0000001;

    public static void main(String[] args) {
        ExponentialFunktion e = new ExponentialFunktion(1,1.9);
        Linjär l = new Linjär(0,0.6);
        Andragradare a = new Andragradare(-1,2,3);

        try {
            System.out.println(maximum(a, 0, 5));
            System.out.println("x = " + intersect(e, l, 1,10));
        } catch (NoSolutionsException e1) {
            System.out.println("Ingen lösning hittades");
        }

        System.out.println(fraction(11,13)[0] + ", " + fraction(11,13)[1]);


    }

    static double intersect(Funktion f1, Funktion f2, double a, double b) throws NoSolutionsException {
        for(double i = a; i < b; i+=step){
            if(Math.abs(f1.fAv(i) - f2.fAv(i)) < accurancy){
                return i;
            }
        }
        throw new NoSolutionsException("Hittade ingen lösning");
    }


    static double maximum(Funktion f1, double intervalStart, double intervalStop) {
        double max = f1.fAv(intervalStart);
        for(double i = intervalStart; i < intervalStop; i += step){
            if(f1.fAv(i) - max > 0){
                max = f1.fAv(i);
            }
        }
        return max;
    }

    static int[] fraction(int t, int n){
        List<Integer> täljareFactors = factors(t);
        List<Integer> nämnareFactors = factors(n);

        for(Integer tälj : täljareFactors){
            for(Integer nämn : nämnareFactors){
                if(t == n){
                    täljareFactors.remove(tälj);
                    nämnareFactors.remove(nämn);
                }
            }


        }
        int täljare = täljareFactors.stream().reduce(1, (a,b) -> (a*b));
        int nämnare = täljareFactors.stream().reduce(1, (a,b) -> (a*b));
        return new int[] {täljare, nämnare};

    }

    static List<Integer> factors(int a){



        return Arrays.asList(3,5,7,a);

    }
}
