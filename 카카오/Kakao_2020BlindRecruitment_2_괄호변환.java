public class Kakao_2020BlindRecruitment_2_괄호변환 {
    public String solution(String p) {
        return getAnswer(p);
    }

    private static String getAnswer(String p) {
        if (checkString(p)) {
            return p;
        }
        int left = 0, right = 0, index = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') left++;
            else right++;
            if (left == right) {
                index = i;
                break;
            }
        }
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        if (checkString(u)) {
            return u + getAnswer(v);
        }else{
            return '(' + getAnswer(v) + ')' + reverseString(u);
        }
    }

    private static String reverseString(String u) {
        StringBuilder output = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            output.append(u.charAt(i) == '(' ?
                    ')' :
                    '(');
        }
        return output.toString();
    }
    private static boolean checkString(String p) {
        int left = 0, right = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') left++;
            else right++;
            if (right > left) return false;
        }
        return true;
    }
}
