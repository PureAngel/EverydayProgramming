package oj215KthLargestElementInAnArray;

// O(n)
public class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        int count = nums.length - k + 1;
        int start= 0, end = nums.length - 1;
        while(start < end) {
            int l = partition(nums, start, end);
            if(l >= count) {
                end = l - 1;
            } else {
                start = l;
            }
        }
        return nums[start];
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start + (end - start) / 2];
        while(start <= end) {
            while (nums[end] > pivot) end--;
            while (nums[start] < pivot) start++;
            if(start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
}
