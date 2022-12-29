import java.util.*;
public class 게임맵최단거리 {

	public static void main(String[] args) {

		int[][] maps = 
			{
					{1,0,1,1,1},
					{1,0,1,0,1},
					{1,0,1,1,1},
					{1,1,1,0,1},
					{0,0,0,0,1},
					
			};
		
		solution(maps);
		for(int[] v : visit) {
			for(int a : v) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
		
	}
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visit;
    static int solution(int[][] maps) {
        int answer = 0;
        
        visit = new int[maps.length][maps[0].length];
        visit[0][0] = 1;
        bfs(maps, visit);
        answer = visit[maps.length-1][maps[0].length-1] == 0 
            ? -1 : visit[maps.length-1][maps[0].length-1];
        
        return answer;
    }
	
    static void bfs(int[][] maps, int[][] visit){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx >= maps.length || ny >= maps[0].length
                  || nx <0 || ny < 0) continue;
                if(visit[nx][ny] == 0 && maps[nx][ny] == 1){
                    visit[nx][ny] = visit[cur[0]][cur[1]]+1;
                    q.add(new int[]{nx, ny});
                }
                
            }
            
        }
    }
}
