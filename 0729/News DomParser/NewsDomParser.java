package News;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class NewsDomParser {

	private final File xml = new File("./src/News/news.xml");
    private List<News> list = new ArrayList<>();
    
    public List<News> getNews() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 문서 로딩 완료 --> 원하는 요소들 골라내기
            Document doc = builder.parse(xml);
            // 최 상위 element
            Element root = doc.getDocumentElement();
            parse(root);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void parse(Element root) {
        // TODO: root에서 dailyBoxOffice를 추출한 후 BoxOffice를 생성해 list에 저장하시오.
        NodeList news = root.getElementsByTagName("item");
        for (int i = 0; i < news.getLength(); i++) {
            Node child = news.item(i);
            list.add(getNews(child));
        }
        // END:
    }

    private static News getNews(Node node) {
        News news = new News();
        // TODO: node 정보를 이용해서 BoxOffice를 구성하고 반환하시오.

        NodeList subNodes = node.getChildNodes();
        for (int j = 0; j < subNodes.getLength(); j++) {
            Node sub = subNodes.item(j);
            if (sub.getNodeName().equals("title")) {
                news.setTitle(sub.getTextContent());
            } else if(sub.getNodeName().equals("description")){
            	news.setDescription(sub.getTextContent());
            } else if(sub.getNodeName().equals("guid")) {
            	news.setGuid(sub.getTextContent());
            } else if(sub.getNodeName().equals("author")) {
            	news.setAuthor(sub.getTextContent());
            } else if(sub.getNodeName().equals("comments")) {
            	news.setComment(sub.getTextContent());
            } else if(sub.getNodeName().equals("pubDate")) {
            	news.setPubDate(news.toDate(sub.getTextContent()));
             } else if(sub.getNodeName().equals("lastBuildDate")) {
            	 news.setLastBD(news.toDate(sub.getTextContent()));
             }
        }
        // END:
        return news;
    }
}


