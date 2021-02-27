package com.yeqifu.linkedlist;

/**
 * 使用单向链表存储梁山一百单八将
 *
 * @Author: 落亦-
 * @Date: 2020/1/11 22:58
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "吴用", "智多星");
        HeroNode heroNode3 = new HeroNode(3, "林冲", "豹子头");
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.addByOrder(new HeroNode(6, "李逵", "黑旋风"));
        singleLinkedList.addByOrder(new HeroNode(5, "抹布", "KTM RC390"));
        singleLinkedList.addByOrder(new HeroNode(4, "哈姐", "Kawasaki Z400"));
        singleLinkedList.addByOrder(new HeroNode(8, "木南", "Ninja 400"));
        singleLinkedList.list();
/*        singleLinkedList.updateNode(new HeroNode(5, "抹布牛逼！", "KTM RC390"));
        singleLinkedList.list();
        singleLinkedList.deleteNode(new HeroNode(1, "宋江", "及时雨"));
        singleLinkedList.list();*/

/*        System.out.println("该链表的结点个数为：" + SingleLinkedListDemo.getLinkedListLength(singleLinkedList.getHead()));

        System.out.println(SingleLinkedListDemo.searchLastKNode(singleLinkedList.getHead(), 0));*/

        SingleLinkedList singleLinkedListReversalSingle = reversalSingleLinkedList(singleLinkedList);
        singleLinkedListReversalSingle.list();
    }

    /**
     * 单链表的反转
     *
     * @param singleLinkedListInput 原来的单链表
     * @return 反转之后的单链表
     */
    public static SingleLinkedList reversalSingleLinkedList(SingleLinkedList singleLinkedListInput) {
        //声明反转之后的单链表
        SingleLinkedList singleLinkedListReversal = new SingleLinkedList();
        //获取原来的单链表的长度
        int linkedListLengthInput = getLinkedListLength(singleLinkedListInput.getHead());
        boolean flag = true;
        if (linkedListLengthInput <= 0) {
            System.out.println("你输入的单链表长度小于0");
            return null;
        }
        //获取输入的单链表的头节点
        HeroNode head = singleLinkedListInput.getHead();

        while (linkedListLengthInput > 0) {
            HeroNode temp = head.getNext();
            for (int i = 1; i < linkedListLengthInput; i++) {
                temp = temp.getNext();
            }
            if (flag == true) {
                HeroNode headReversal = singleLinkedListReversal.getHead();
                headReversal.setNext(new HeroNode(temp.getNum(), temp.getName(), temp.getNickName()));
                linkedListLengthInput--;
                flag = false;
            } else {
                singleLinkedListReversal.add(new HeroNode(temp.getNum(), temp.getName(), temp.getNickName()));
                linkedListLengthInput--;
            }
        }
        return singleLinkedListReversal;
    }

    /**
     * 查找单链表中倒数第K个结点
     *
     * @param head 传入链表的头结点
     * @param k    倒数第几个结点
     * @return
     */
    public static HeroNode searchLastKNode(HeroNode head, int k) {
        //获得链表的长度
        int linkedListLength = getLinkedListLength(head);
        //链表的长度减去k
        int s = linkedListLength - k + 1;
        if (head.getNext() == null) {
            System.out.println("你输入的链表长度为空！");
            return null;
        }
        if (s < 0 || k <= 0) {
            System.out.println("你输入的链表长度小于" + k + "，或者k为负数或0");
            return null;
        }
        for (int i = 0; i < s; i++) {
            head = head.getNext();
        }
        return head;
    }

    /**
     * 查询链表的结点个数
     *
     * @param heroNode
     * @return
     */
    public static int getLinkedListLength(HeroNode heroNode) {
        int length = 0;
        if (heroNode.getNext() == null) {
            return 0;
        } else {
            while (heroNode.getNext() != null) {
                length++;
                heroNode = heroNode.getNext();
            }
        }
        return length;
    }
}

/**
 * 存储将领结点的链表实体类
 */
class SingleLinkedList {

    /**
     * 初始化一个头结点
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 第一种方式添加一个结点
     *
     * @param headNode 待添加的结点
     */
    public void add(HeroNode headNode) {

        HeroNode temp = head;

        //遍历链表，找到最后的结点
        while (true) {
            if (temp.getNext() == null) {
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
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置(如果有这个排名，则添加失败，并给出提示)
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //默认添加成功，当添加失败时将flag置为false，同时返回该节点
        boolean flag = true;
        //遍历单链表
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNum() > heroNode.getNum()) {
                break;
            }
            if (temp.getNext().getNum() == heroNode.getNum()) {
                //该链表中已存在该节点，添加失败
                flag = false;
                break;
            }
            temp = temp.getNext();
        }
        if (flag == false) {
            //添加失败
            System.out.printf("你添加的节点在链表中已存在，该链表编号为：%d\n", heroNode.getNum());
            try {
                throw new AlreadyExistHeroNode("至少有一个节点添加失败！");
            } catch (AlreadyExistHeroNode alreadyExistHeroNode) {
                alreadyExistHeroNode.printStackTrace();
            }
        } else {
            //添加成功
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    /**
     * 修改结点
     *
     * @param newHeroNode
     */
    public void updateNode(HeroNode newHeroNode) {
        HeroNode temp = head;
        //默认修改失败
        boolean flag = false;
        while (true) {
            //结点遍历完毕
            if (temp.getNext() == null) {
                break;
            }
            //找到节点
            if (temp.getNext().getNum() == newHeroNode.getNum()) {
                //修改成功
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag == true) {
            temp.getNext().setName(newHeroNode.getName());
            temp.getNext().setNickName(newHeroNode.getNickName());
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    /**
     * 删除结点
     *
     * @param heroNode
     */
    public void deleteNode(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //遍历链表完毕
            if (temp.getNext() == null) {
                break;
            }
            //找到结点
            if (temp.getNext().getNum() == heroNode.getNum()) {
                flag = true;
                break;
            }
            //移到下一个结点
            temp = temp.getNext();
        }
        if (flag == true) {
            //找到结点，删除结点
            temp.setNext(temp.getNext().getNext());
            System.out.println("删除结点成功！");
        } else {
            //未找到结点，删除失败
            System.out.println("删除结点失败，该结点在链表中不存在！" + heroNode);
        }
    }

    /**
     * 遍历单向链表
     */
    public void list() {
        //判断链表是否为空
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.getNext();
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
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
class HeroNode {
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

    public HeroNode() {
    }

    public HeroNode(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
