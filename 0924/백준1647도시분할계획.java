import java.util.*;


class city implements Comparable<city>{
	private int distance, nodeA, nodeB;
	
	public city(int distance, int nodeA, int nodeB) {
		this.distance = distance;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getDistance() {
		return this.distance;
	}

	public int getNodeA() {
		return this.nodeA;
	}

	public int getNodeB() {
		return this.nodeB;
	}

	@Override
	public int compareTo(city o) {
		return this.distance - o.distance;
	}
}

public class 백준1647도시분할계획 {

	static int v,e;
	static int[] parent = new int[1000001];
	static ArrayList<city> edges = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		
		for(int i=1; i<=v; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new city(cost, a, b));
		}
		
		Collections.sort(edges);
		
		int last = 0;
		
		for(int i=0; i<edges.size(); i++) {
			int cost = edges.get(i).getDistance();
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			// 사이클이 발생하지 않을 때만 집합에 추가.
			if(findset(a) != findset(b)) {
				unionset(a,b);
				result += cost;
				last = cost;
			}
		}
		System.out.println(result - last);
	}
	
	static void unionset(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if(aRoot<bRoot) parent[bRoot] = aRoot;
		else parent[aRoot] = bRoot;
	}

	static int findset(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findset(parent[x]);
	}
}
