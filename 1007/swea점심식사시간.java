import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class swea점심식사시간 {

	static class Person{
		int x,y;
		int sel;
		int stairTime;
		int arriveTime;
		Person(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class Stair{
		int x,y;
		int h;
		Stair(int x, int y, int h){
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	
	static int n;
	static ArrayList<Person> person;
	static ArrayList<Stair> stair;
	static int ans;
	static boolean[] visit;
	static int[][] arr;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			n = sc.nextInt();
			
			arr = new int[n][n];
			person = new ArrayList<>();
			stair = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					// 사람일때 리스트에 추가
					if(arr[i][j] == 1) {
						person.add(new Person(i, j));
					} else if(arr[i][j] >= 2) { // 계단정보추가
						stair.add(new Stair(i, j, arr[i][j]));
					} else continue;
				}
			}
			solve(0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	
	static void solve(int idx) {
		// 탈출
		if(idx == person.size()) {
			// 정해진 계단으로 이동 => 내려가기
			for(int i=0; i<person.size(); i++) {
				// 배정 계단 거리
				Person p = person.get(i);
				p.arriveTime = Math.abs(stair.get(p.sel).x - p.x) +Math.abs(stair.get(p.sel).y - p.y);
			}
			visit = new boolean[idx];
			int result = simulation();
			ans = ans > result ? result : ans;
			return;
		}
		person.get(idx).sel = 0; // 처음 계단
		solve(idx+1);
		person.get(idx).sel = 1; // 두번 ㅉ째
		solve(idx+1);
	}
	
	static int simulation() {
		PriorityQueue<Person> pq = new PriorityQueue<>();
		Queue<Person>[] q = new LinkedList[stair.size()];
		q[0] = new LinkedList<>(); // 계단 1
		q[1] = new LinkedList<>(); // 계단 2
		int person_arrive = 0;
		int time = 1;
		
		while(true) {
			for(Queue<Person> qp : q) {
				int size = qp.size();
				
				if(size == 0) continue;
				
				for(int i=0; i<size; i++) {
					Person p = qp.poll();
					Stair s = stair.get(p.sel); // 해당 person계단
					
					if(p.stairTime + s.h <= time) {
						person_arrive++;
						continue; // 계단 내려간 시간이 시간안에 가능하면 탈출
					}
					qp.add(p); // 아니면 다시 넣줌
				}
			}
			if(person_arrive == person.size() && q[0].isEmpty() && q[1].isEmpty()) return time;
			
			for(int i=0; i<person.size(); i++) {
				if(visit[i]) continue;
				// 도착까지 걸린 시간이 흐른시간안에 가능 && 2명이하
				Person p = person.get(i);
				if(p.arriveTime + 1 <= time && q[p.sel].size() <= 2) {
					p.stairTime = time; // 계단 앞 도착시간
					visit[i] = true;
					q[p.sel].add(p); // 계단에 넣어줌
				}
			}
			time++;
		}
	}
}
