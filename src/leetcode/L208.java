package leetcode;

// Implement Trie (Prefix Tree)
public class L208 {
    class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        int index(char c) {
            return c - 'a';
        }

        public void insert(String word) {
            Node curr = this.root;
            for (char c : word.toCharArray()) {
                int index = index(c);
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                int index = index(c);
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                int index = index(c);
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            if (curr.isWord) return true;
            for (Node c : curr.children) {
                if (c != null) return true;
            }
            return false;
        }
    }

    class Node {
        boolean isWord;
        Node[] children;

        public Node() {
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    void solve() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

    }

    public static void main(String[] args) {
        L208 s = new L208();
        s.solve();
    }
}
