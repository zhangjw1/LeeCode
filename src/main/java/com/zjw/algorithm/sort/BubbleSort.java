package com.zjw.algorithm.sort;

/**
 * @author zhang jiawei
 * @date 2019/9/23 17:57
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = i + 1; j < sourceArray.length; j++) {
                if (sourceArray[i] > sourceArray[j]) {
                    int temp = sourceArray[i];
                    sourceArray[i] = sourceArray[j];
                    sourceArray[j] = temp;
                }
            }
        }
        return sourceArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            int randomInt = (int) (Math.random() * 100 + 1);
            arr[i] = randomInt;
        }
        int[] newArr = bubbleSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
