package News;
import java.util.List;


public class DomParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        NewsDomParser parser = new NewsDomParser();
		        List<News> list = parser.getNews();
		        
		        for(News info: list) {
		            System.out.println(info);
		        }
		    }   

}
