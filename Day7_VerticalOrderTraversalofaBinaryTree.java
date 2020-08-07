Problem: "https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/"

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
 


Solution:

/*

Explanation =>
* Scan the elements Level by Level
* In Each level, order of elements must be maintained in Ascending
* Add the elements to the List in each level

*/
class Solution {
    class VerticalNode implements Comparable<VerticalNode> {
        
        TreeNode node;
        int x = 0;
        int level = 0;
        
        VerticalNode(TreeNode node, int x, int level) {
            
            this.node = node;
            this.x = x;
            this.level = level;
        }
        
        @Override
        public int compareTo(VerticalNode obj) {
            
            if (this.level == obj.level)
            return this.node.val - obj.node.val;
            
            return this.level - obj.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
                
        List<List<Integer>> result = new LinkedList<>();
        
        PriorityQueue<VerticalNode> queue = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        queue.add(new VerticalNode(root, 0, 0));
        
        int level = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- > 0) {
                
                VerticalNode vertNode = queue.poll();
                
                if (!map.containsKey(vertNode.x)) {
                    
                    map.put(vertNode.x, new LinkedList<>());
                }
                
                map.get(vertNode.x).add(vertNode.node.val);
                
                if (vertNode.node.left != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.left, 
                                               vertNode.x-1, level+1));
                }
                
                if (vertNode.node.right != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.right, 
                                               vertNode.x+1, level+1));
                }
            }
            
            ++level;
        }
        
        for (List<Integer> list: map.values()) {
            
            result.add(list);
        } 
        
        return result;
    }
}/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*

Explanation =>
* Scan the elements Level by Level
* In Each level, order of elements must be maintained in Ascending
* Add the elements to the List in each level

*/
class Solution {
    class VerticalNode implements Comparable<VerticalNode> {
        
        TreeNode node;
        int x = 0;
        int level = 0;
        
        VerticalNode(TreeNode node, int x, int level) {
            
            this.node = node;
            this.x = x;
            this.level = level;
        }
        
        @Override
        public int compareTo(VerticalNode obj) {
            
            if (this.level == obj.level)
            return this.node.val - obj.node.val;
            
            return this.level - obj.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
                
        List<List<Integer>> result = new LinkedList<>();
        
        PriorityQueue<VerticalNode> queue = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        queue.add(new VerticalNode(root, 0, 0));
        
        int level = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- > 0) {
                
                VerticalNode vertNode = queue.poll();
                
                if (!map.containsKey(vertNode.x)) {
                    
                    map.put(vertNode.x, new LinkedList<>());
                }
                
                map.get(vertNode.x).add(vertNode.node.val);
                
                if (vertNode.node.left != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.left, 
                                               vertNode.x-1, level+1));
                }
                
                if (vertNode.node.right != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.right, 
                                               vertNode.x+1, level+1));
                }
            }
            
            ++level;
        }
        
        for (List<Integer> list: map.values()) {
            
            result.add(list);
        } 
        
        return result;
    }
}