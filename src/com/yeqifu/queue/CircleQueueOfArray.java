package com.yeqifu.queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * @Author: 落亦-
 * @Date: 2020/1/9 23:15
 */
public class CircleQueueOfArray {
    public static void main(String[] args) {

        //创建一个环形队列
        //其队列的有效数据最大为3
        CircleArray queue = new CircleArray(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                // 取出数据
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                // 查看队列头的数据
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                // 退出
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class CircleArray{

    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * front:front指向该队列的第一个元素 且 front的初始值为 0
     */
    private int front;

    /**
     * rear:rear指向该队列的最后一个元素的后一位 且 rear的初始值为 0
     */
    private int rear;

    /**
     * 声明一个数组，该数组模拟一个环形队列
     */
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        //初始化数组
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     * @return  true:已满  false:未满
     */
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    /**
     * 判断队列是否为空
     * @return  true:为空  false:非空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加一个数进入队列
     * @param n     添加的数
     */
    public void addQueue(int n){
        //判断队列是否已满
        if (isFull()){
            System.out.println("队列已满，不可添加！");
            return;
        }
        //将数据加入
        arr[rear]=n;
        //将rear后移，这里考虑取模
        rear = (rear+1)%maxSize;
    }

    /**
     * 从队列中取出一个数
     * @return
     */
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法取值！");
        }
        //1.先将front对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    /**
     * 输出当前队列中的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    /**
     * 求出当前队列有效数据的个数
     * @return
     */
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    /**
     * 显示队列的头数据
     * @return
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }

}
