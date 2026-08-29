class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        while (i < word1.length() || j < word2.length()) {
            result.append(i < word1.length() ? word1.charAt(i++) : word2.charAt(j++));
        }

        return result.toString();
    }
}
