package com.yeqifu.sort;

/**
 * 快排
 *
 * @Author: 落亦-
 * @Date: 2022/1/5 21:53
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 7, 8, 2, 2, -9, 99, 15, 3, 4};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        //只有一个数的时候直接返回
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        //将第一个数作为基准元素
        int key = arr[i];
        while (i < j) {
            while (arr[j] >= key && i < j) {
                j--;
            }
            if (i < j) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }


            while (arr[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                int temp2;
                temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
            }

            //对基准左侧进行快排
            quickSort(arr, low, i - 1);

            //对基准右侧进行快排
            quickSort(arr, i + 1, high);
        }
    }
}
