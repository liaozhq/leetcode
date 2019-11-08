package leetcode;

import java.util.HashMap;

/**
 * 1.假设所有的输入都是由小写字母 a-z 构成的。 2.保证所有输入均为非空字符串。
 * 
 * @author 廖振钦
 * @description:前辍树
 */
public class Trie {

	private HashMap<String, Trie> tree = new HashMap<String, Trie>();

	@SuppressWarnings("unused")
	private boolean isWord = false;

	public void insert(String word) {
		Trie tmpTree = null;
		char[] words = word.toCharArray();
		int i = 0;
		for (char c : words) {
			i++;
			String cs = String.valueOf(c);
			if (tmpTree == null) {
				if (tree.get(cs) != null) {
					if (words.length == i) {
						setMapWord(words, 0);
						break;
					}
					tmpTree = tree.get(cs);
				} else {
					if (words.length == i) {
						Trie trie = new Trie();
						trie.setWord(true);
						tree.put(cs, trie);
					} else {
						tree.put(cs, new Trie());
					}
					tmpTree = tree.get(cs);
				}
			} else {
				if (tmpTree.getTree().get(cs) != null) {
					if (words.length == i) {
						setMapWord(words, 0);
						break;
					}
					tmpTree = tmpTree.getTree().get(cs);
				} else {
					if (words.length == i) {
						Trie trie = new Trie();
						trie.setWord(true);
						tmpTree.getTree().put(cs, trie);
					} else {
						tmpTree.getTree().put(cs, new Trie());
					}
					tmpTree = tmpTree.getTree().get(cs);
				}
			}
		}
	}

	public void setMapWord(char[] words, int layer) {
		setTree(setMapWord(this, words, layer));
	}

	public HashMap<String, Trie> setMapWord(Trie trie, char[] words, int layer) {
		if (words.length - 1 == layer) {
			HashMap<String, Trie> tmpTree = trie.getTree();
			Trie trie2 = tmpTree.get(String.valueOf(words[layer]));
			trie2.setWord(true);
			tmpTree.put(String.valueOf(words[layer]), trie2);
			return tmpTree;
		} else {
			HashMap<String, Trie> tmpTree = trie.getTree();
			Trie trie2 = tmpTree.get(String.valueOf(words[layer]));
			trie2.setTree(setMapWord(trie2, words, layer + 1));
			tmpTree.put(String.valueOf(words[layer]), trie2);
			return tmpTree;
		}
	}

	public boolean search(String word) {
		Trie tmpTree = null;
		if ("".equals(word) || word == null) {
			return false;
		}
		for (char c : word.toCharArray()) {
			String cs = String.valueOf(c);
			if (tmpTree == null) {
				if (tree.get(cs) != null) {
					tmpTree = tree.get(cs);
				} else {
					tmpTree = tree.get(cs);
					return false;
				}
			} else {
				if (tmpTree.getTree().get(cs) != null) {
					tmpTree = tmpTree.getTree().get(cs);
				} else {
					tmpTree = tmpTree.getTree().get(cs);
					return false;
				}
			}
		}
		if (tmpTree.getTree().values().size() >= 1 && !tmpTree.isWord()) {
			return false;
		}
		return true;
	}

	public boolean startsWith(String prefix) {
		Trie tmpTree = null;
		if ("".equals(prefix) || prefix == null) {
			return false;
		}
		for (char c : prefix.toCharArray()) {
			String cs = String.valueOf(c);
			if (tmpTree == null) {
				if (tree.get(cs) != null) {
					tmpTree = tree.get(cs);
				} else {
					tmpTree = tree.get(cs);
					return false;
				}
			} else {
				if (tmpTree.getTree().get(cs) != null) {
					tmpTree = tmpTree.getTree().get(cs);
				} else {
					tmpTree = tmpTree.getTree().get(cs);
					return false;
				}
			}
		}
		return true;
	}

	public HashMap<String, Trie> getTree() {
		return tree;
	}

	public void setTree(HashMap<String, Trie> tree) {
		this.tree = tree;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

}
