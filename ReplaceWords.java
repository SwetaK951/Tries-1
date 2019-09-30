// Data Structure - Trie
// Time complexity - O(n) length of the sentence
// Space complexity - O(1)

// Structure of each node
class ReplaceWords {
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
        boolean isword;
    }
    
    // build Trie, store all words and initiate recursion.
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        
        // extract words from the given sentence
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        //search root for each word, if found repleace it otherwise keep it as it is.
        for(int i=0; i<arr.length; i++){
            String s = dfs(root,arr[i]);
            if(s != null){
                sb.append(s+" ");                
            }   
            else{
                sb.append(arr[i]+ " ");
            }    
        }
        return sb.toString().trim();
    }
    
    // build Trie and store all given words of the string.
    public TrieNode buildTrie(List<String> dict){
        TrieNode root = new TrieNode();
        for(String s : dict){
            TrieNode t = root;
            for(char c : s.toCharArray()){
                if(t.children[c - 'a'] == null)
                    t.children[c - 'a'] = new TrieNode();
                t = t.children[c-'a'];
            }
            t.isword = true;
            t.word = s;
        }
        return root;
    }
    
    // this function call itself to find a word into the trie, if found return word else return null
    public String dfs(TrieNode root, String str){
         TrieNode t = root;
        for(char c : str.toCharArray()){
            if(t.isword)
                return t.word;
            else if(t.children[c - 'a'] == null)
                    return null;
            t = t.children[c-'a'];
        }
        return null;
    }
}