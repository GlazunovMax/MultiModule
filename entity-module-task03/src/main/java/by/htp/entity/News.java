package by.htp.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "news_title")
	@NotNull(message = "{news.sizeNotNull.error}")
	@Size(min = 1, message = "{news.sizeNotNull.error}")
	private String newsTitle;

	@Column(name = "news_date")
	@NotNull(message = "{date.sizeNotNull.error}")
	@DateTimeFormat(pattern = "yyyy/MM/dd") 
	private Date newsDate;

	@Column(name = "brief")
	@NotNull(message = "{news.sizeNotNull.error}")
	@Size(min = 1, message = " {news.sizeNotNull.error}")
	private String brief;

	@Column(name = "content")
	@NotNull(message = "{news.sizeNotNull.error}")
	@Size(min = 1, message = " {news.sizeNotNull.error}")
	private String content;

	@Column(name = "status")
	private char status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", newsTitle=" + newsTitle + ", newsData=" + ", brief=" + brief + ", content="
				+ content + "]";
	}

}
