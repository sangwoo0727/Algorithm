public class Programmers_SummerWinterCoding_2018_스킬트리 {
    static int[] alp = new int[26];
    public int solution(String skill, String[] skill_trees){
        int ans = 0;
        for(int i=0; i<skill.length(); i++){
            char c = skill.charAt(i);
            alp[c-'A'] = i+1;
        }
        for(String skill_tree : skill_trees){
            int idx = 1;
            boolean flg = false;
            for(int i=0; i<skill_tree.length(); i++){
                char c = skill_tree.charAt(i);
                if(alp[c-'A']==0) continue;
                if(alp[c-'A'] > idx){
                    flg = true;
                    break;
                }
                idx++;
            }
            if(!flg) ans++;
        }
        return ans;
    }
}
