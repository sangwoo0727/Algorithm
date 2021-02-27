public class LEV2_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            int idx = 0;
            boolean flag = true;
            label: for (char c : skill_tree.toCharArray()) {
                for (int i = 0; i < skill.length(); i++) {
                    if (c == skill.charAt(i)) {
                        if (i != idx) {
                            flag = false;
                            break label;
                        } else {
                            idx++;
                        }
                    }
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}
