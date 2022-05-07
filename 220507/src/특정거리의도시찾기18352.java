import java.io.*;
import java.util.*;

public class 특정거리의도시찾기18352 {
	
    public static void main(String[] args) throws IOException{

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());// 도시 개수
    	int m = Integer.parseInt(st.nextToken());// 도로 개수
    	int k = Integer.parseInt(st.nextToken());// 거리 정보
    	int x = Integer.parseInt(st.nextToken());// 출발 도시 번호
    	
    	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    	
    	for(int i=0; i<=n; i++) {
    		list.add(new ArrayList<Integer>());
    	}
    	
    	int[] dist = new int[300001];
    	Arrays.fill(dist, -1);
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int from = Integer.parseInt(st.nextToken());
    		int to = Integer.parseInt(st.nextToken());
    		
    		list.get(from).add(to);
    	}
    	dist[x] = 0;
    	bfs(x, dist, list);
    	check(dist, k);
    	
    }

    static void bfs(int start, int[] dist, ArrayList<ArrayList<Integer>> list) {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	
    	while(!q.isEmpty()){
    		int now = q.poll();
    		
    		for(int i=0; i<list.get(now).size(); i++) {
    			int next = list.get(now).get(i);
    			if(dist[next] == -1) {
    				dist[next] = dist[now]+1;
    				q.add(next);
    			}
    		}
    	}
    }
    
    static void check(int[] dist, int k) {
    	boolean isK = false;
    	
    	for(int i=0; i<dist.length; i++) {
    		if(dist[i] == k) {
    			System.out.println(i);
    			isK = true;
    		}
    	}
    	if(!isK) System.out.println(-1);
    	
    }
}