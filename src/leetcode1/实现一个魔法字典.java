package leetcode1;

/**
 * @Author: Ljx
 * @Date: 2022/7/11 9:25
 * @role:
 */
public class 实现一个魔法字典 {

}


class MagicDictionary {
    Trie1 root;

    public MagicDictionary() {
        root = new Trie1();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            Trie1 cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie1();
                }
                cur = cur.child[idx];
            }
            cur.isFinished = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, root, 0, false);
    }

    private boolean dfs(String searchWord, Trie1 node, int pos, boolean modified) {
        if (pos == searchWord.length()) {
            return modified && node.isFinished;
        }
        int idx = searchWord.charAt(pos) - 'a';
        if (node.child[idx] != null) {
            if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; ++i) {
                if (i != idx && node.child[i] != null) {
                    if (dfs(searchWord, node.child[i], pos + 1, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Trie1 {
    boolean isFinished;
    Trie1[] child;

    public Trie1() {
        isFinished = false;
        child = new Trie1[26];
    }
}
