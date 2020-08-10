Problem : 

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".



Solution :

class Solution {
    public int titleToNumber(String s) {

        int power = 0;
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = s.charAt(i) - 'A' + 1;
            // this will give the value according to the letter. A will give 1 , B will give 2 and so on.
            result = result + ((int) Math.pow(26, power) * value);
            // formula is (result+charValue*26^index). increment index from left to right.
            //We start the loop from end to beginning.
            power++;
        }

        return result;
    }
}
