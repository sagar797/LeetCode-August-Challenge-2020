Problem:

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hints:
1. An easy approach is to sort the array first.
2. What are the possible values of h-index?
3. A faster approach is to use extra space.



Solution:
The citations[ ] array contains the number of citations for each paper. The number of papers publish is citations.length.

This is actually a "counting sort", which simply counts the number of papers with x citations. Some discussion entries call this a "bucket sort", but technically a counting sort is different in that a bucket sort saves all of the original data. A counting sort throws out the original data, and only saves aggregate information. Counting sorts are O(N). I don't really consider counting sorts to be real sorts, because the original data is lost. I consider it more of a data analysis.

The h-index value cannot be higher than the total number of papers, so we only need the count sort to hold values from 0 to the number of papers (citations.length). Papers with more citations than the number of papers, will be counted as though they had number-of-papers citations.

class Solution {
    public int hIndex(int[] citations) {
        // Array to the contain the counts for number of papers 
        // with x citations, where counts[x] will be the number of 
        // papers with x citations.  Because the h value cannot be 
        // larger than the number of papers, the last used count in 
        // this array, count[citations.length], is a count of the 
        // number of papers with citations.length or more citations.
        int[] counts = new int[citations.length + 2];
        
        // Build the counts of how many papers have x citations.  
        // If a paper has more than citations.length citations, then 
        // count it as citations.length citations.
        for (int i = citations.length - 1; i >= 0; i--)  
            counts[Math.min(citations[i], citations.length)]++;
        
        // Go through the count[] array from last index down to 0, trying 
        // successively smaller values for h.  Looping from high to low 
        // possible values for h, will find the highest valid value for 
        // h.  While descending through the count array, add the count 
        // from the next higher index in the count array, which will 
        // convert the current counts[h] value to become a count of 
        // papers with h or more citations.  This is slightly confusing 
        // because h is used as both an index and a value to compare to 
        // the array value at that index.  The "units" for h feel 
        // inconsistent.
        int h;
        for (h = citations.length; h > 0; h--) {
            counts[h] += counts[h + 1];
            if (counts[h] >= h)  break;
        }
        return h;
    }
}