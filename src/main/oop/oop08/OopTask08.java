package oop08;

import java.util.Random;

public class OopTask08 {
    public static void main(String[] args) {
        double[] randArray = makeRandArray();
        System.out.println("Mean: " + mean(randArray));
        System.out.println("Variance: " + variance(randArray));
    }
    public static double[] makeRandArray(){
        double[] a = new double[100];
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            r.nextDouble();
            a[i] = r.nextDouble();
        }
        return a;
    }
    public static double mean(double[] arr){
        double sum = 0;
        for (double a: arr){
            sum += a;
        }
        return sum / arr.length;
    }

    public static double variance(double[] arr){
        double mean = mean(arr);
        double tmp = 0;
        for(double a :arr)
            tmp += (a-mean)*(a-mean);
        return tmp /arr.length;
    }
}
