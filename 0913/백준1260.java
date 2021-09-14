package solution0913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준1260 {

	static ArrayList<Integer>[] list;
	static int start;
	static boolean[] bln;
	static Queue<Integer> q;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 정점의 수
		int n = sc.nextInt();
		// 간선의 수
		int m = sc.nextInt();
		// 탐색의 시작점
		start = sc.nextInt();
		
		list = new ArrayList[n+1];
		// 각 정점을 방문처리할 배열
		bln = new boolean[n+1];
		// 그래프 초기화
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// list에 노드와 간선정보를 저장한다.
		for(int i=1; i<=m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		for(int i=1; i<=n; i++) {
			Collections.sort(list[i]);
		}
		
		bfs(start);
		System.out.println();
		bln = new boolean[n+1];
		dfs(start);
	}
	
	static void bfs(int n) {
		// 해당 노드를 방문 했다면 함수를 종료한다.
		if(bln[n]) return;
		// 노드를 방문처리를 해준다.
		bln[n] = true;
		System.out.print(n+" ");
		for(int y : list[n]) {
			if(!bln[y])	bfs(y);
		}
	}
	
	static void dfs(int n) {
		q = new LinkedList<Integer>();
		q.add(n);
		bln[n] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int y : list[x]) {
				if(!bln[y]) {
					bln[y] = true;
					q.add(y);
				}
			}
		}	
	}

}
