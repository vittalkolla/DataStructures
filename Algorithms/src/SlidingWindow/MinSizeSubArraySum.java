package SlidingWindow;

//Given an array of positive numbers and a positive number ‘S,’
// find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
// Return 0 if no such subarray exists.

public class MinSizeSubArraySum {

    //TC:O[2n] -> O[n], SC: O[1]
    public static int findMinSubArraySize(int[] arr, int S) {
        int start = 0, minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int end = 0; end < arr.length; end++) { // This takes O[n]
            sum += arr[end];

            while (sum >= S) { // This takes O[n]
                minLength = Math.min(minLength, end - start + 1);
                sum -= arr[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,4,1,1,6};
        System.out.println(findMinSubArraySize(arr, 7));
    }
}
