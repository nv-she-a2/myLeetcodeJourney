// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.


// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
 
// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int leftIndex = findLeftIndex(nums, target);
        int rightIndex = findRightIndex(nums, target);
        
        return new int[]{leftIndex, rightIndex};
    }
    
    public int findLeftIndex(int[] nums, int target) {
        int n = nums.length, res = -1;
        int l=0, r=n-1;
        while(l <= r) {
            int m = (l+r)/2;
            if(nums[m] >= target) {
                res = (nums[m] == target) ? m : res;
                r = m-1;
            }
            else
                l = m+1;
        }
        return res;
    }
    
    public int findRightIndex(int[] nums, int target) {
        int n = nums.length, res = -1;
        int l=0, r=n-1;
        while(l <= r) {
            int m = (l+r)/2;
            if(nums[m] <= target) {
                res = (nums[m] == target) ? m : res;
                l = m+1;
            }
            else
                r = m-1;
        }
        return res;
    }
}
