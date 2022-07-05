import java.util.Arrays;

public class 카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int[][] map = 
		{
				{1,1,1,0},
				{1,2,2,0},
				{1,0,0,1},
				{0,0,0,1},
				{0,0,0,3},
				{0,0,0,3}
				
		};
		System.out.println(Arrays.toString(solution(6,4, map)));
	}
	
	  static boolean[][] check;
	    
	    static int[] solution(int m, int n, int[][] picture) {
	        int maxSizeOfOneArea = 0;

	        check = new boolean[m][n];
	        cnt = 0;
	        
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(!check[i][j] && picture[i][j] != 0){
	                    maxSizeOfOneArea = Math.max(dfs(picture, i, j, picture[i][j]), maxSizeOfOneArea);
	                    area = 0;
	                    cnt++;
	                }
	            }
	        }
	        
	   
	        int[] answer = new int[2];
	        answer[0] = cnt;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	    
	    static int[] dx = {0,1,0,-1};
	    static int[] dy = {-1,0,1,0};
	    static int area;
	    static int cnt;
	    
	    static int dfs(int[][] picture, int x, int y, int num){
	        check[x][y] = true;
	        area++;
	        picture[x][y] = 0;
	        
	        for(int i=0; i<4; i++){
	            int nx = x+dx[i];
	            int ny = y+dy[i];
	            
	            if(nx >= picture.length || nx < 0 || 
	              ny >= picture[0].length || ny < 0) continue;
	            
	            if(picture[nx][ny] == num){
	                dfs(picture, nx, ny, num);
	            }
	        }
	        
	        return area;
	    }
	
}
