package Lesson5;

public class MainRec {

    public static void main(String[] args) {
        System.out.println(expo(3, 4));
    }

    //Возведение в степень с использованием четной степени - было реализовано на первой домашке:)
    private static int expo(int base, int sign) {
        if (sign == 0)
            return 1;
        else if (sign % 2 == 0) {
            return expo(base * base, sign / 2);
        } else {
            return base * expo(base, --sign);
        }
    }

}
