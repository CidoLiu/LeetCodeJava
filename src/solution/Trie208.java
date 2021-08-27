package solution;

/**
 * @id
 * @author dongjin
 * @date 2021/2/18 12:00
 */
public class Trie208 {

    public static void main(String[] args) {
        Trie208 temple = new Trie208();
        System.out.println();
    }
}

class Trie {

    class TrieNode {
        private boolean isEnd;
        TrieNode[] next;

        public TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (node.next[c-'a'] == null) {
                node.next[c-'a'] = new TrieNode();
            }
            node = node.next[c-'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            node = node.next[c-'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()) {
            node = node.next[c-'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}