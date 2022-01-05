package com.yeqifu.linkedlist;

import java.util.Stack;

/**
 * @Author: 落亦-
 * @Date: 2021/3/31 15:10
 */
public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        // 入栈操作
        stack.add("哈姐");
        stack.add("抹布");
        stack.add("木南");

        while (!stack.isEmpty()) {
            // 出栈操作
            System.out.println(stack.pop());
        }
    }

}
