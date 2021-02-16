public class LEV1_가운데글자가져오기 {
    public String solution(String s) {
        int len = s.length();
        return len % 2 == 0 ?
                s.substring(len / 2 - 1, len / 2 + 1) :
                s.substring(len / 2, len / 2 + 1);
    }
}
