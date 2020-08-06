Problem:
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]


Solution:

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
//         ArrayList<Integer> ans=new ArrayList<>();
        
//         int []arr =new int[nums.length];
//         for(int i=0;i<nums.length;i++){
//             arr[nums[i]-1]++;
//         }
        
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]>1){
//                 ans.add(i+1);
//             }
//         }
        
//         return ans;
        ArrayList<Integer> list=new ArrayList<>();
         for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0){
                ist.add(Math.abs(nums[i]));
            }
            nums[index] *= -1;
        }
        return list;
    }
}