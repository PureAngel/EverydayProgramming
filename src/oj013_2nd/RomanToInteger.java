package oj013_2nd;

public class RomanToInteger {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    nums[i] = 1;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'M':
                    nums[i] = 1000;
            }
        }

        int res = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(nums[i] < nums[i + 1]) {
                res -= nums[i];
            } else {
                res += nums[i];
            }
        }
        res += nums[s.length() - 1];
        return res;
    }
}
