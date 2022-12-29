package practice;
import java.util.*;
public class 정규표현식 {

	public static void main(String[] args) {

		String str = "aabbccabcabcelwieotuuuabce";
		PriorityQueue<Document> pq = new PriorityQueue<>();
		String subStr = str.replaceAll("[^abc]", ",");
		ArrayList<Document> docList = new ArrayList<>();
		
		System.out.println(subStr);
	}

    static class Document implements Comparable<Document>{
        int idx, start, end;

        public Document(int idx, int start, int end){
            this.idx = idx;
            this.start = start;
            this.end = end;
        }

        public int comparTo(Document d){
            return this.start - d.start;
        }

		@Override
		public int compareTo(Document o) {
			// TODO Auto-generated method stub
			return 0;
		}
    }
}
