package com.zjw.algorithm.sort;

/**
 * @author zhang jiawei
 * @date 2019/9/23 18:04
 */
public class InsertSort {

    public static int[] insertSort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            int temp = sourceArray[i];
            int j = i;
            while ( j > 0 && sourceArray[j -1] > temp){
                //向右移，留出空位
                sourceArray[j] = sourceArray[j - 1];
                j--;
            }
            if(i != j){
                sourceArray[j] = temp;
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
        int[] newArr = insertSort(arr);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
