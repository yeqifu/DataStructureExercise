package com.yeqifu.sort;

/**
 * 选择排序
 *
 * @Author: 落亦-
 * @Date: 2021/4/30 10:23
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 9, -9, 79};
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int small = array[j];
                if (small > array[j + 1]) {
                    small = array[j + 1];
                }
                temp = array[j];

            }
        }
    }

}
