package News;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class News {

	private String title;//기사제목
	private String author;//저자
	private String item;//아이템
	private String description;//설명
	private String comment;
	private Date pubDate;//발행 날짜
	private String guid;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public Date toDate(String pubDate) {
		Date dateObj = null;//2021 07 29 00 03 01
		SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
		try {
			dateObj = format.parse(pubDate);
		}catch (ParseException e) {
			e.printStackTrace();
			dateObj = new Date();
		}
		return dateObj;
	}
	public Date toLastDate(String lastBD) {
		Date dateObj = null;//2021 07 29 00 03 01
		SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
		try {
			dateObj = format.parse(lastBD);
		}catch (ParseException e) {
			e.printStackTrace();
			dateObj = new Date();
		}
		return dateObj;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", author=" + author + ", item=" + item + ", description=" + description
				+ ", comment=" + comment + ", pubDate=" + pubDate +  ", guid=" + guid + "]";
	}

	
	
}
