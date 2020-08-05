Problem:
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

Hint 1 :  
You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.


Solution:
import java.util.regex.Pattern;
class WordDictionary {
    // Mapping word length as the key and the list of words as the value
    Map<Integer, ArrayList<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<Integer, ArrayList<String>>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        ArrayList<String> list;
        if(map.get(word.length()) != null) list = map.get(word.length());
        else list = new ArrayList<String>();
        list.add(word);
        map.put(word.length(), list);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        ArrayList<String> list;
        if(map.get(word.length()) != null) list = map.get(word.length());
        else return false;
        if(list.contains(word)) return true;
        else {
            Pattern regex = Pattern.compile(word);
            for (String s:list) {
                if (regex.matcher(s).matches()) return true;
            }
        }
        return false;
    }
}