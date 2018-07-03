package oj004_2nd;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid_len = (len1 + len2) / 2;

        // ensure len1 <= len2
        if(len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int t = len1;
            len1 = len2;
            len2 = t;
        }

        int iMin = 0, iMax = len1;
        while(iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = mid_len - i;
            if(i < iMax && nums1[i] < nums2[j - 1]) { // i is too small
                iMin = i + 1;
            } else if(i > iMin && nums1[i] > nums2[j + 1]) { // i is too big
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if(i == 0) { // nums1[0] > all nums2
                    maxLeft = nums2[j - 1];
                } else if(j == 0) { // nums2[0] > all nums1
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if((len1 + len2) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if(i == len1) {
                    minRight = nums2[j];
                } else if(j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
