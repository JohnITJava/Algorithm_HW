package Lesson1;

/**
 * Created by Ivanov John 29.09.2018.
 */
public class MainClassHW {
    public static void main(String[] args) {
        int[] mass = {47, 23, 56, 22, 15, 4, 34};

        System.out.println(exponent(3, 3));
        System.out.println(minSearchAr(mass));
        System.out.println(averSearchAr(mass));

    }

    //Возведение в степень
    //О(n) - сложность, т.к. при расчете результата нужно 1м циклом совершить какое-то действие n раз
    public static int exponent(int a, int exp){
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= a;
        }

        return result;
    }

    //Поиск мин элемента в массиве
    //О(n) - сложность, т.к. при поиске гарантированно минимального значения нужно 1м циклом перебрать n элементов
    public static int minSearchAr(int[] mass){
        int min = mass[0];
        for (int i = 0; i < mass.length; i++) {
            if (min > mass[i]) min = mass[i];
        }
        return min;
    }

    //Cреднее арифметическое массива
    //О(n) - сложность, т.к. при расчете результата нужно 1м циклом совершить какое-то действие n раз
    public static float averSearchAr(int[] mass){
        int result = 0;
        for (int i = 0; i < mass.length; i++) {
            result += mass[i];
        }
        return (float)result/mass.length;
    }

}
