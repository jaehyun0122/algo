
public class 프렌즈 {
    static boolean[][] check;
    static char[][] map;
    
	public static void main(String[] args) {
		String[] board = {
				"TTTANT", 
				"RRFACC", 
				"RRRFCC", 
				"TRRRAA", 
				"TTMMMF", 
				"TMMTTJ"
		};
		System.out.println(solution(board.length,board[1].length(),board));
		System.out.println("------result");
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	 static int solution(int m, int n, String[] board) {
	        int answer = 0;
	        map = new char[board.length][];
	        for(int i=0; i<board.length; i++){
	            map[i] = board[i].toCharArray();
	        }

	        while(true){
	            boolean isChange = false;
	            check = new boolean[m][n];
	            // 1,1부터 4각형 판별
	            for(int i=0; i<m; i++){
	                for(int j=0; j<n; j++){
	                    if(map[i][j] != '-' && isSquare(i,j)){
	                        remove(i,j);
	                        isChange = true;
	                    }
	                }
	            }
	    		
	            setMap();
	            if(!isChange) break;
	        }
	        
	        return answer = count();
	    }
    static int[] dx = {0, 1, 1, 0};
    static int[] dy = {1, 1, 0, 0};
    // 사각형 판별 함수
    static boolean isSquare(int x, int y){
        char tmpChar = map[x][y];
        for(int i=0; i<3; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx >= map.length) return false;
            if(ny >= map[0].length) return false;
            if(tmpChar != map[nx][ny]) return false;
        }
        return true;
    }
    
    static void remove(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            check[nx][ny] = true;
        }
    }
    
    static int count(){
        int result = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == '-') result++;
            }
        }
        return result;
    }
    
    static void setMap(){
        for(int i=map.length-1; i>=0; i--){
            for(int j=0; j<map[i].length; j++){
                if(check[i][j]){
                	map[i][j] = '-';
                    int idx = i;
                    while(idx>=0 && check[idx][j]){
                        idx--;
                    }
                    if(idx>=0){
                        map[i][j] = map[idx][j];
                        check[idx][j] = true;
                    }
                }
            }
        }
    }
    
    
}
