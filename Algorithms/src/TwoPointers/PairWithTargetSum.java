package TwoPointers;

//Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
//Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

public class PairWithTargetSum {

    //TC: O[n], SC:O[1]
    public static int[] search(int[] arr, int target){
        int left =0, right = arr.length -1;

        while(left < right){
            int currSum = arr[left] + arr[right];

            if(currSum == target){
                return new int[] {left, right};
            }
            else if(currSum > target){
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,6};
        search(arr, 6);
    }

}
