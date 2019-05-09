package cn.superwei;

import java.util.Arrays;

/**
 * @author hewei
 * @date 2019/5/8
 */
public class SortTest {

    public static void main(String[] args) {
        int[] number = {6, 77, 2, 5, 3, 99, 7};
        System.out.println(Arrays.toString(number));
        SortTest.bubbleSort(number);
        System.out.println(Arrays.toString(number));
    }

    /**
     * 冒泡法排序<p>
     * 比较相邻的元素，如果第一个比第二个小，就交换他们两个的位置
     * @param numbers 需要排序的数组
     */
    private static void bubbleSort(int[] numbers) {
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
