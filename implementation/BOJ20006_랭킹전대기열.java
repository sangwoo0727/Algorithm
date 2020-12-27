import java.io.*;
import java.util.*;

public class BOJ20006_랭킹전대기열 {
    static int p, m;
    static PriorityQueue<Room> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.priority, o2.priority)));
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(input.readLine());
            int level = Integer.parseInt(st.nextToken());
            String id = st.nextToken();
            boolean flag = false;
            if (!pq.isEmpty()) {
                List<Room> tempList = new ArrayList<>();
                while (!pq.isEmpty()) {
                    Room room = pq.poll();
                    if (room.ownerLevel - 10 <= level && level <= room.ownerLevel + 10 && !room.isFull) {
                        flag = true;
                        room.list.add(new Player(level, id));
                        if (room.list.size() == m) {
                            room.isFull = true;
                        }
                    }
                    tempList.add(room);
                    if (flag) break;
                }
                pq.addAll(tempList);
            }
            if (!flag) {
                Room room = new Room(i, false, new Player(level, id));
                pq.add(room);
            }
        }
        StringBuilder output = new StringBuilder();
        while (!pq.isEmpty()) {
            Room room = pq.poll();
            room.list.sort((o1,o2)->{
                return o1.id.compareTo(o2.id);
            });
            if (room.isFull) {
                output.append("Started!").append("\n");
            } else {
                output.append("Waiting!").append("\n");
            }
            for (Player player : room.list) {
                output.append(player.level).append(" ").append(player.id).append("\n");
            }
        }
        System.out.println(output);
    }
    static class Room{
        int priority;
        boolean isFull;
        int ownerLevel;
        List<Player> list;
        Room(int priority, boolean isFull, Player player) {
            this.priority = priority;
            this.isFull = isFull;
            this.ownerLevel = player.level;
            list = new ArrayList<>();
            list.add(new Player(player.level, player.id));
            if (list.size() == m) {
                this.isFull = true;
            }
        }
    }
    static class Player{
        int level;
        String id;
        Player(int level, String id) {
            this.level = level;
            this.id = id;
        }
    }
}
