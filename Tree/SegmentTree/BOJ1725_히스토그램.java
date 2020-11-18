import java.io.*;

public class BOJ1725_히스토그램 {
    static int N, output;
    static int[] histo;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        histo = new int[N];
        for (int i=0; i<N; i++){
            histo[i] = Integer.parseInt(br.readLine());
        }
        tree = new int[4*N];
        makeSegTree(0,N-1,1);
        output = getMaxArea(0, N-1);
        System.out.println(output);
    }
    static int getSegNode(int left, int right, int node, int start, int end){
        if(left > end || right < start) return -1;
        if(left <= start && end <= right) return tree[node];
        int mid = (start+end)/2;
        int leftIdx = getSegNode(left,right, node*2, start, mid);
        int rightIdx = getSegNode(left, right, node*2+1, mid+1, end);
        if (leftIdx == -1) return rightIdx;
        if (rightIdx == -1) return leftIdx;
        return histo[leftIdx] > histo[rightIdx] ? rightIdx : leftIdx;
    }
    static int getMaxArea(int left, int right){
        int minIdx = getSegNode(left,right,1,0,N-1);
        int area = (right-left+1) * histo[minIdx];
        if (left <= minIdx - 1){
            int leftArea = getMaxArea(left, minIdx-1);
            area = Math.max(area,leftArea);
        }
        if (right >= minIdx + 1){
            int rightArea = getMaxArea(minIdx+1, right);
            area = Math.max(area,rightArea);
        }
        return area;
    }
    static void makeSegTree(int start, int end, int idx){
        if (start == end){
            tree[idx] = start;
            return;
        }
        int mid = (start+end)/2;
        makeSegTree(start,mid,idx*2);
        makeSegTree(mid+1,end, idx*2+1);
        tree[idx] = histo[tree[idx*2]] > histo[tree[idx*2+1]]? tree[idx*2+1] : tree[idx*2];
    }
}
