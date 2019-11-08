package leetcode;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		Trie trie = new Trie();
		trie.insert("app");
		trie.insert("apple");
		trie.insert("appl");
		trie.insert("beer");
		trie.insert("add");
		trie.insert("jam");
		trie.insert("rental");
		System.out.println(trie.search("apps")); 
		System.out.println(trie.search("app"));   
		System.out.println(trie.startsWith("appl"));  
		System.out.println(trie.startsWith("ab"));
		System.out.println(trie.startsWith("ab"));
		trie.insert("abc");
		System.out.println(trie.search("abc")); 
		System.out.println(trie.search("app"));  

	}
}
