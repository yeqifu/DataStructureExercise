package com.yeqifu.LinkedList;

/**
 * 使用单向链表存储梁山一百单八将
 * @Author: 落亦-
 * @Date: 2020/1/11 22:58
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"吴用","智多星");
        HeroNode heroNode3 = new HeroNode(3,"林冲","豹子头");
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.list();
    }
}

/**
 * 存储将领结点的链表实体类
 */
class SingleLinkedList{

    /**
     * 初始化一个头结点
     */
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 添加一个结点
     * @param headNode  待添加的结点
     */
    public void add(HeroNode headNode){

        HeroNode temp = head;

        //遍历链表，找到最后的结点
        while (true){
            if (temp.getNext() == null){
                break;
            }
            //如果没有找到最后的结点,就将当前temp后移
            temp = temp.getNext();
        }
        //当退出while循环时，temp就指向了链表的最后一个结点
        //将最后这个结点的next 指向新的结点
        temp.setNext(headNode);
    }

    /**
     * 遍历单向链表
     */
    public void list(){
        //判断链表是否为空
        if (head.getNext() == null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.getNext();
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出结点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.getNext();
        }
    }

}

/**
 * 存储将领的结点实体类
 */
class HeroNode{
    /**
     * 将领编号
     */
    private int num;
    /**
     * 将领名称
     */
    private String name;
    /**
     * 将领外号
     */
    private String nickName;
    /**
     * 下一个将领的地址信息
     */
    private HeroNode next;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode() {
    }

    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
