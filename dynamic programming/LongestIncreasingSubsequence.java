// Given an integer array nums, return the length of the longest strictly increasing subsequence.

// Example 1:
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

// Example 2:
// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Example 3:
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
 

// Constraints:

// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
 

// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > seq.get(seq.size()-1))
                seq.add(nums[i]);
            else {
                //search for smallest number greater than curr element.
                int index = binarySearch(seq, nums[i]);
                seq.set(index, nums[i]);
            }
        }
        return seq.size();
    }
    
    int binarySearch(List<Integer> arr, int key) {
        int l=0, r = arr.size()-1;
        while(l < r) {
            int m = (l+r)/2;
            if(key <= arr.get(m)) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
}
