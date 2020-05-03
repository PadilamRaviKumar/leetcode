package trieImplementation;

public interface ITrie {

	public void insert(String word);
	public boolean search(String word);
	public boolean startsWith(String word);
	public boolean isWord(String word);
}
