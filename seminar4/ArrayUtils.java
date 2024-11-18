//1. Написать метод, возвращающий количество чётных элементов массива.

//countEvens([2, 1, 2, 3, 4]) → 3
//countEvens([2, 2, 0]) → 3
//countEvens([1, 3, 5]) → 0

//2. Написать функцию, возвращающую разницу между самым большим и самым ма-
//леньким элементами переданного не пустого массива.

//3. Написать функцию, возвращающую истину, если в переданном массиве есть два
//соседних элемента, с нулевым значением.
package org.example;

public class ArrayUtils {

    // Метод для подсчета четных элементов в массиве
    public static int countEvens(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Метод для вычисления разницы между максимальным и минимальным элементами массива
    public static int differenceMaxMin(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min;
    }

    // Метод для проверки наличия двух соседних нулевых элементов
    public static boolean hasAdjacentZeros(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Задача 1
        System.out.println(countEvens(new int[]{2, 1, 2, 3, 4})); // → 3
        // Задача 2
        System.out.println(differenceMaxMin(new int[]{1, 3, 5, 7, 9})); // → 8
        // Задача 3

        System.out.println(hasAdjacentZeros(new int[]{1, 0, 0, 3})); // → true
        System.out.println(hasAdjacentZeros(new int[]{1, 2, 3})); // → false
    }
}
