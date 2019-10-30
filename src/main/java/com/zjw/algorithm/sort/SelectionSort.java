package com.zjw.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhang jiawei
 * @date 2019/9/23 17:34
 * 升序排列
 */
public class SelectionSort {

    public static int[] selectSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        //先定义第一个最小，下表为min，遍历min后面的，若小于则交换下标，遍历完之后交换值
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    int temp = j;
                    j = min;
                    min = temp;
                }
            }
            if (arr[min] < arr[i]) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
/*            if (min != i ) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }*/

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            int randomInt = (int) (Math.random() * 1000 + 1);
            arr[i] = randomInt;
        }
        int[] newArr = selectSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
