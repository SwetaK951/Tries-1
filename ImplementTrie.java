
/**
Approac 1 - using HashMap
Time complexity - O(n) where n is the length of the string
Space complexity - O(1)

Pseudocode:
1. Created structure of a node of a trie.
2. Insert
    a. iterate through the length of the word, if node contains the character, means char is already present.
    b. link to the node children represented by the current character.
    c. otherwise, create a new node and link to the root.
3. Search
    a. iterate through the length of the word.
    b.  if node contains the character,link to the node children represented by the current character.
    c. otherwise, return false.
    d. If loop reached to the end of word length and isword field is not set then return false;
4. startswith
    a. iterate through the length of the word.
    b.  if node contains the character,link to the node children represented by the current character.
    c. otherwise, return false.
  
**/

class TrieNode{
    HashMap<Character,TrieNode> children = new HashMap<>();
    boolean is_word = false; 
    TrieNode (){}
}
    
public class Trie {
/** Initialize your data structure here. */
private TrieNode root;

public Trie() {
    this.root = new TrieNode();
}

/** Inserts a word into the trie. */
public void insert(String word) {
    TrieNode t = root;
    for(char c : word.toCharArray()){
        TrieNode curr  = new TrieNode();
        if(t.children.containsKey(c)){
           curr = t.children.get(c); 
        }
        else{
            t.children.put(c,curr);
        }
        
        t = curr;
    }
    t.is_word = true;    
}

/** Returns if the word is in the trie. */
public boolean search(String word) {
    TrieNode node = searchword(word);
    if(node != null && node.is_word)
        return true;
    return false;
}

/** Returns if there is any word in the trie that starts with the given prefix. */
public boolean startsWith(String prefix) {
    TrieNode node = searchword(prefix);
    if(node != null)
        return true;
    return false;
}

public TrieNode searchword(String word){
   TrieNode t = root;
    for(char c : word.toCharArray()){
        TrieNode curr  = new TrieNode();
        if(t.children.containsKey(c)){
           curr = t.children.get(c); 
        }
        else 
            return null;
        t = curr;
    }
    return t; 
}
}

/**
Approac 2 - using Array
Time complexity - O(n) where n is the length of the string
Space complexity - O(1)

**/
class TrieNode{
    char c;
    TrieNode[] children = new TrieNode[26];
    boolean is_word = false; 
    TrieNode (){}
    TrieNode (char c){
        TrieNode node = new TrieNode();
        node.c = c;
}
}
    
public class Trie {
/** Initialize your data structure here. */
private TrieNode root;

public Trie() {
    root = new TrieNode();
    root.c = ' ';
}

/** Inserts a word into the trie. */
public void insert(String word) {
    TrieNode t = root;
    for(char ch : word.toCharArray()){
        if(t.children[ch - 'a'] == null)
           t.children[ch - 'a'] = new TrieNode(ch); 
        t = t.children[ch - 'a'];
    }
    t.is_word = true;
}

/** Returns if the word is in the trie. */
public boolean search(String word) {
    if(searchword(word) != null && searchword(word).is_word)
        return true;
    return false;
}

/** Returns if there is any word in the trie that starts with the given prefix. */
public boolean startsWith(String prefix) {
    if(searchword(prefix) != null)
        return true;
    return false;
}

public TrieNode searchword(String word){
    TrieNode t = root;
    for(char ch : word.toCharArray()){
        if(t.children[ch - 'a'] == null)
           return null; 
        t = t.children[ch - 'a'];
    }
    return t;
}
}

