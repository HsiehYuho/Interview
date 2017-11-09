package fb;

public class Add_and_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_and_Search a = new Add_and_Search();
		a.exe();
	}
	public void exe() {
		return;
	}
	Trie root; 
	public void WordDictionary() {
        root = new Trie();
    }
	public void addWord(String word) {
		Trie node = root;
		char[] chars = word.toCharArray();
        for(char c : chars) {
        		if(node.children[c-'a'] == null)
        			node.children[c-'a'] = new Trie();
        		node = node.children[c-'a']; 
        }
        node.isWord = true;
    }
	public boolean search(String word) {
		char[] chars = word.toCharArray();
		return match(root,chars,0);
    }
	private boolean match(Trie node, char[] chars, int pos){
		if(pos == chars.length)
			return node.isWord;
		if(chars[pos] != '.') {
			int idx = chars[pos] - 'a';
			return node.children[idx] != null && match(node.children[idx],chars,pos+1);
		}
		else {
			for(int i = 0; i < 26; i++) {
				if(node.children[i] != null) {
					if(match(node.children[i],chars,pos+1))
					return true;
				}
			}
		}
		return false;
			
	}
	class Trie{
		Trie[] children;
		boolean isWord;
		public Trie(){
			children = new Trie[26];
			isWord = false;
		}
	}
}
