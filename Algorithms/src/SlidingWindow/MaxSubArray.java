package SlidingWindow;

//Given an array of positive numbers and a positive number ‘k,’
// find the maximum sum of any contiguous subarray of size ‘k’.

public class MaxSubArray {

    //TC: O(N*K), N is total elements in array
    public static int maxSumSubArrayBrute(int[] arr, int k){
        int maxSum =0, windowSum;
        for(int i=0; i<arr.length-k; i++){
            windowSum = 0;
            for(int j=i; j<i+k; j++){
                windowSum = windowSum+arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    // TC: O[n]
    public static int maxSumSubArrayBest(int[] arr, int k){
        int windowSum=0, maxSum=0;
        int start = 0;
        for(int end=0; end<arr.length; end++){
            windowSum += arr[end];
            if(end>=k-1){
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,1,3,2};
        maxSumSubArrayBrute(arr, 3);
        maxSumSubArrayBest(arr, 3);
    }
}
