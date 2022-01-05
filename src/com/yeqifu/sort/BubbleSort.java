package com.yeqifu.sort;

import java.text.SimpleDateFormat;

/**
 * 冒泡排序
 * @Author: 落亦-
 * @Date: 2021/4/29 20:32
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 800000);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("排序前的时间撮：" + startTime);

        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("排序后的时间撮：" + endTime);
        long speedTime = endTime - startTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss");
        String format = simpleDateFormat.format(speedTime);
        System.out.println("排序所花费的时间为：" + format + "秒");

    }

    private static void bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            //System.out.println("第"+(i+1)+"趟排序后的数组，flag为："+flag);
            //System.out.println(Arrays.toString(array));
            if (flag == false) {
                break;
            }

        }
    }

}
