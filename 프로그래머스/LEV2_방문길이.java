import java.util.*;

public class LEV2_방문길이 {
    public int solution(String dirs){
        Map<Character, int[]> mapper = new HashMap<>();
        mapper.put('U', new int[]{0, 1});
        mapper.put('D', new int[]{0, -1});
        mapper.put('L', new int[]{-1, 0});
        mapper.put('R', new int[]{1, 0});

        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        for (char key : dirs.toCharArray()) {
            int[] dir = mapper.get(key);
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (!valid(nx, ny)) {
                continue;
            }
            StringBuilder line = new StringBuilder();
            line.append(x).append(y).append(nx).append(ny);
            set.add(line.toString());
            line = new StringBuilder();
            line.append(nx).append(ny).append(x).append(y);
            set.add(line.toString());
            x = nx; y = ny;
        }
        return set.size() / 2;
    }

    static boolean valid(int x, int y) {
        return -5 <= x && x <= 5 && -5 <= y && y <= 5;
    }
}
