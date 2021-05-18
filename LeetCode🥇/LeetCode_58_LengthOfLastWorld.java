public class LeetCode_58_LengthOfLastWorld {
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words.length == 0 ? 0 : words[words.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hi  hello"));
    }
}
