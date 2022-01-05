package com.yeqifu.search;

import java.util.ArrayList;

/**
 * 线性查找
 *
 * @Author: 落亦-
 * @Date: 2022/1/5 18:03
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,8,1,5,1};
        ArrayList<Integer> index = seqSearch(arr, 2);
        if (index.size() < 1){
            System.out.println("您所给的值不再数组中");
        }else {
            System.out.println("您所给的值在数组索引的："+index.toString());
        }
    }

    public static ArrayList seqSearch(int[] arr, int value) {
        ArrayList<Integer> indexList = new ArrayList<>(16);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                indexList.add(i);
            }
        }
        return indexList;
    }
}
