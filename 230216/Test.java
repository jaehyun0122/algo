import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());


        for(int tc = 0; tc<TC; tc++){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            TreeMap<Integer, Integer> tMap = new TreeMap<>();
            StringTokenizer st;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch(command){
                    case "I":
                        maxHeap.add(num);
                        minHeap.add(num);
                        tMap.put(num, tMap.getOrDefault(num, 0)+1);
                        break;
                    case "D":
                       if(!tMap.isEmpty()){
                           int key = num == 1 ? tMap.lastKey() : tMap.firstKey();

                           if(tMap.get(key) == 1){
                               tMap.remove(key);
                           }else{
                               tMap.put(key, tMap.get(key)-1);
                           }
                       }
                        break;
                }

            }

            if(tMap.isEmpty()) System.out.println("EMPTY");
            else{
                System.out.println(tMap.lastKey()+" "+tMap.firstKey());
            }
        }


    }
}
