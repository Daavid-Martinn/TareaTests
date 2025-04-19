package ejercicio2;

import java.util.Random;

public class GeneradorIP {

	Random random = new Random();

    public int generarNumero(int min, int max) {
        return random.nextInt(min,max);
    }

    public String generarIPV4() {
        int n1 = generarNumero(1, 254);
        int n2 = generarNumero(0, 254);
        int n3 = generarNumero(0, 254);
        int n4 = generarNumero(1, 254);
        return n1 + "." + n2 + "." + n3 + "." + n4;
    }

    public static void main(String[] args) {
        GeneradorIP g=new GeneradorIP();
        System.out.println(g.generarIPV4());
    }

}
