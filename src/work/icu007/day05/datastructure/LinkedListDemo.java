package work.icu007.day05.datastructure;

import java.util.LinkedList;

/**
 * LinkedList集合特点
 * 1. 底层是一个链表结构，查询慢，增删快
 * 2. 里面包含了大量操作首尾元素的方法
 * 3. 不是同步的
 * 4. 链表特有的方法不能使用迭代器遍历
 * 5. 不能使用多线程
 * 6. 由于是链表结构，所以不具有数组的随机快速访问特性
 * 7. 存取元素有序，有索引，元素可以重复存储
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.add(3);
        linkedList.addLast(1);
        System.out.println(linkedList);

    }
}
