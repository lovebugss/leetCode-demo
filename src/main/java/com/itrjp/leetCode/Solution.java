package com.itrjp.leetCode;

import org.junit.Test;


public class Solution {

    /**
     * Created by ren on 2018/12/4.
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target == nums[i] + nums[j]) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 2, 4, 9};
        int[] ints = twoSum(nums, 7);

        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        do {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l1 != null);
        do {
            sb2.append(l2.val);
            l2 = l2.next;
        }
        while (l2 != null);
        StringBuffer reverse1 = sb1.reverse();
        StringBuffer reverse2 = sb2.reverse();
        int i = Integer.parseInt(reverse1.toString());
        int i1 = Integer.parseInt(reverse2.toString());

        int i2 = i + i1;
        int temp =i2;
        ListNode ln = null;
        do{
            ListNode listNode = new ListNode(temp % 10);
            temp = temp / 10;
            if (ln == null) {
                ln = listNode;
            }
            else if (ln.next == null) {
                ln.next =listNode;
            } else {
                ListNode next = ln.next;
                next.next = listNode;
            }

        }
        while (temp  > 0) ;


        return ln;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    @Test
    public void addTwoNumbersTest() {

        ListNode listNode = new ListNode(9);



        ListNode listNode21 = new ListNode(9);

        ListNode listNode22 = new ListNode(9);
        listNode22.next = listNode21;
        ListNode listNode11 = new ListNode(1);
        listNode11.next = listNode22;

        ListNode listNode3 = addTwoNumbers(listNode, listNode11);
        System.out.println(listNode3);
        while (listNode3.next != null) {

            System.out.println(listNode3.val);
            listNode3 = listNode3.next;
        }
    }
}
