// Appraoch - using Array
// Time complexity - O(n) length of the string.
// Space complexity - O(1)


class LongestWordinDictionary {
    //Structure of the node of the Trie
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
        boolean isword;
    }
    
    int max = 0;
    String temp = "";
    
    //Driver function, call a method to build trie data structure and initiate recursion to search the word.
    public String longestWord(String[] words) {
        TrieNode root = buildTrie(words);
        for(int i=0;i<26;i++)
            if(root.children[i] != null)
                dfs(root.children[i],1);
        return temp;
    }
    
    // This function call itself recursively to find the longest word
    public void dfs(TrieNode root,int depth){
        // if any of the root while traversal is not itself a word then return 
        if(!root.isword)
            return;
        // update the maximum length till current traversal
        if(depth > max){
            max = depth;
            temp = root.word;
        }
        
        // call root children 
       for(int i=0;i<26;i++){
            if(root.children[i] != null)
                dfs(root.children[i],depth+1);
        }
    }
    
    // This function build the trie data structure using array and strore all given words.
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String str : words){
            TrieNode t = root;
            for(char c : str.toCharArray()){
                if(t.children[c - 'a'] == null){
                    t.children[c - 'a'] = new TrieNode();
                }
                t = t.children[c-'a'];
            }
            t.isword = true;
            t.word = str;
        }
        return root;
    }
}