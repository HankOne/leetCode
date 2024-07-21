package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void run() {
        //2,4,3
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        //5,6,4
        ListNode l11 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l33 = new ListNode(4);
        l11.next = l22;
        l22.next = l33;

        ListNode res = addTwoNumbers(l1, l11);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }


//        int[] nums = new int[]{3, 2, 4};
//        int target = 6;
//        int[] res = twoSum(nums, target);
//        for (int i : res) {
//            System.out.print(i + ",");
//        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Num = 0;
        int i = 1;
        ListNode head1 = l1;
        while (head1 != null) {
            l1Num += head1.val * i;
            head1 = head1.next;
            i *= 10;
        }

        int l2Num = 0;
        i = 1;
        ListNode head2 = l2;
        while (head2 != null) {
            l2Num += head2.val * i;
            head2 = head2.next;
            i *= 10;
        }

        int resNum = l1Num + l2Num;
        int last = resNum % 10;
        resNum /= 10;
        ListNode res = new ListNode(last);
        ListNode cur = res;
        while (resNum != 0) {
            cur.next = new ListNode(resNum % 10);
            resNum /= 10;
        }
        return res;

    }


    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                ArrayList<Integer> list = map.get(num);
                if (nums[i] == num && list.size() == 1) {
                    continue;
                }
                res[0] = i;
                for (int j : list) {
                    if (j != i) {
                        res[1] = j;
                    }
                }
                return res;
            }
        }
        return res;
    }


}
