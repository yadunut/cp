import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;


class Trie {
    static class Node {
        boolean isWord;
        Node[] children;
        int count = 0;

        public Node() {
            this.children = new Node[26];
            this.isWord = false;
        }
    }

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
            curr.count++;
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

    public int prefix(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int index = index(c);
            if (curr.children[index] == null) return 0;
            curr = curr.children[index];
        }
        return curr.count;
    }
}

public class nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int A = Integer.parseInt(br.readLine());
       Trie t = new Trie();
       for(int i = 0; i < A; i++) {
           t.insert(br.readLine());
       }
       int B = Integer.parseInt(br.readLine());
       for(int i = 0; i < B; i++) {
           System.out.println(t.prefix(br.readLine()));
       }
       pr.close();
    }
}
