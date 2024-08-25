package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution63 {

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(i, words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            result.addAll(trie.search(i, words[i]));
        }
        return result;
    }

    public static class TrieNode {
        private int wordId;
        private TrieNode [] children;
        List<Integer> pWordIds;

        public TrieNode() {
            this.wordId = -1;
            this.children = new TrieNode[26];
            this.pWordIds = new ArrayList<>();
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * 팰린드롬 여부 판별
         * @param str 판별할 문자
         * @param start 시작 인덱스
         * @param end 종료 인덱스
         * @return 팰린드롬 여부
         */
        public boolean isPalindrome(String str, int start, int end) {
            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }

        public void insert(int index, String word) {
            TrieNode node = root;
            // 뒤집어서 저장
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                // 정방향으로 해당 위치까지 팰린드롬 -> 단어의 인덱스 저장
                if (isPalindrome(word, 0, i)) {
                    node.pWordIds.add(index);
                }

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.wordId = index;
        }

        public List<List<Integer>> search(int index, String word) {
            TrieNode node = root;
            List<List<Integer>> result = new ArrayList<>();

            for (int j = 0; j < word.length(); j++) {
                // wordId가 존재 && 나머지 문자가 팰린드롬
                if (node.wordId >= 0 && isPalindrome(word, j, word.length()-1)) {
                    result.add(Arrays.asList(new Integer[] {index, node.wordId}));
                }
                // 자식 노드가 없으면 팰린드롬 아님
                if (node.children[word.charAt(j) - 'a'] == null) {
                    return result;
                }
                node = node.children[word.charAt(j) - 'a'];
            }

            // 끝까지 탐색 -> wordId가 존재하는 경우
            if (node.wordId >= 0 && node.wordId != index) {
                result.add(Arrays.asList(new Integer[] {index, node.wordId}));
            }

            for (int p : node.pWordIds) {
                result.add(Arrays.asList(new Integer[] {index, p}));
            }

            return result;
        }
    }
}
