import java.util.*;
public class Kakao_2019BlindRecruitment_5_길찾기게임 {
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) ->
            o1.y==o2.y? Integer.compare(o1.x,o2.x) : -Integer.compare(o1.y,o2.y));
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            pq.offer(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        Node root = pq.poll();
        while(!pq.isEmpty()){
            makeTree(root,pq.poll());
        }
        preOrder(answer[0],root);
        idx = 0;
        postOrder(answer[1],root);
        return answer;
    }
    static void preOrder(int[] answer,Node c){
        answer[idx++] = c.num;
        if(c.left!=null) preOrder(answer,c.left);
        if(c.right!=null) preOrder(answer,c.right);
    }
    static void postOrder(int[] answer,Node c){
        if(c.left!=null) postOrder(answer,c.left);
        if(c.right!=null) postOrder(answer,c.right);
        answer[idx++] = c.num;
    }
    static void makeTree(Node p, Node c){
        if(p.x > c.x){
            if(p.left == null) p.left = c;
            else makeTree(p.left , c);
        }else{
            if(p.right == null) p.right = c;
            else makeTree(p.right, c);
        }
    }
    static class Node{
        int num,x,y;
        Node left,right;
        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
