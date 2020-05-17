package LeetCode_May_Challenge;

import java.util.HashMap;

public class Trie {

    class Node {
        char ch;
        HashMap<Character,Node> adjList;
        Node(char c){
            ch = c;
            adjList = new HashMap<>();
        }
    }

    HashMap<Character, Node> rootNodeChildren;

    /** Initialize your data structure here. */
    public Trie() {
        rootNodeChildren = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) {
            rootNodeChildren.put('\0', new Node('\0'));
            return ;
        }

        Node match = rootNodeChildren.getOrDefault(word.charAt(0), null);

        if(match!=null){
            Node cur = match;
            int lastChar = 0;
            for(int i=1; i<word.length(); i++) {
                while(cur.adjList.getOrDefault(word.charAt(i), null)!=null){
                    cur = cur.adjList.get(word.charAt(i));
                    lastChar++;
                }
            }
            if(lastChar==word.length()) {
                cur.adjList.put('\0', new Node('\0'));
            } else {
                for(int i=lastChar+1; i<word.length(); i++) {
                    cur.adjList.put(word.charAt(i), new Node(word.charAt(i)));
                    cur = cur.adjList.get(word.charAt(i));
                }
                cur.adjList.put('\0', new Node('\0'));
            }

        } else {
            rootNodeChildren.put(word.charAt(0), new Node(word.charAt(0)));
            Node cur = rootNodeChildren.get(word.charAt(0));
            for(int i=1; i<word.length(); i++) {
                cur.adjList.put(word.charAt(i), new Node(word.charAt(i)));
                cur = cur.adjList.get(word.charAt(i));
            }
            cur.adjList.put('\0', new Node('\0'));
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null) {
            if(rootNodeChildren.containsKey('\0')) {
                return true;
            } else
                return false;
        }
        Node match = rootNodeChildren.getOrDefault(word.charAt(0), null);
        if(match == null)
            return false;
        boolean isPresent = true;
        Node cur = match;
        for(int i=1; i<word.length(); i++){
            if(cur.adjList.getOrDefault(word.charAt(i), null)!=null) {
                cur = cur.adjList.get(word.charAt(i));
            } else {
                isPresent = false;
                break;
            }
        }
        if(isPresent) {
            if(cur.adjList.getOrDefault('\0', null)!=null) {
                return true;
            } else
                return false;
        } else
            return false;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null) {
            if(rootNodeChildren.containsKey('\0')) {
                return true;
            } else
                return false;
        }
        Node match = rootNodeChildren.getOrDefault(prefix.charAt(0), null);
        if(match == null) {
            return false;
        } else {
            Node cur = match;
            boolean isPrefix = true;
            for(int i=1; i<prefix.length(); i++) {
                if(cur.adjList.getOrDefault(prefix.charAt(i), null)!=null) {
                    cur = cur.adjList.get(prefix.charAt(i));
                } else {
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix) 
                return true;
            else 
                return false;
        }
    }

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.insert("ab");
        System.out.println(ob.search("abc"));
        System.out.println(ob.search("ab"));
        System.out.println(ob.startsWith("abc"));
        System.out.println(ob.startsWith("ab"));
        ob.insert("abc");
        System.out.println(ob.search("abc"));
        System.out.println(ob.startsWith("abc"));
        ob.insert("abc");
    }
}