package com.demo.www.springbootdemo.utils;

/**
 * Created on 2019/4/1.
 * author:crs
 * Description:二分法：找到某个元素的位置
 * 1）要求数组必须是有序的，查找速度快，性能好
 * 2）找到某个元素索引的位置
 * 3）使用递归还是while循环实现二分查找法，两种方式都可以。
 * 4）元素不能重复，如果有重复元素怎么处理？
 * 5）如何查找指定元素所在的索引范围？
 */
public class BinarySearchUtils {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5};
        //int res = binarySearch(arr, 6, 5);
        int res = binarySearch1(arr, 0, 5, 3);
        System.out.println(res);

        //1)要是arr==NULL呢？如何保证收入的有效性？
        //2)要是arr是降序排序的呢？
        //3)
    }

    /**
     * 方法一：数组，长度，要查找的key
     *
     * @param arr
     * @param n
     * @param key
     * @return
     */

    private static int binarySearch(int[] arr, int n, int key) {
        //数组的索引是从0开始的
        int low = 0;
        //最大索引的位置
        int high = n - 1;
        int mid;
        //多次遍历循环
        while (low <= high) {
            mid = (low + high) / 2;
            //带查找的key与中间的数据进行比较
            if (key == arr[mid]) {
                //当前元素的索引
                return mid;
            }
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 方法二：递归实现
     *
     * @param arr
     * @param left
     * @param right
     * @param key
     * @return
     */
    private static int binarySearch1(int arr[], int left, int right, int key) {
        //递归终止条件;
        if (null != arr && left <= right) {
            int mid = (left + right) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                //虽然把整个数组传递进去了，但是一半的数据不在进行遍历,遍历从中间开始
                return binarySearch1(arr, left, mid - 1, key);
            } else {
                return binarySearch1(arr, mid + 1, right, key);
            }
        }
        return -1;
    }

    private static int binarySearch2(int arr[], int left, int right, int key) {
        if (null == arr || right < left) {
            int mid;
            //号保证了只剩下一个元素时的正确性
            while (left <= right) {
                mid = (left + right) / 2;
                if (key == arr[mid]) {
                    return mid;
                } else if (key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


}
