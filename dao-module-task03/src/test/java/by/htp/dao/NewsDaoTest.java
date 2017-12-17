package by.htp.dao;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import by.htp.entity.News;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
public class NewsDaoTest {

	@Autowired
	private NewsDao newsDao;

	@Test
	@Transactional
	public void testGetNews() {
		List<News> news = newsDao.getNews();
		assertNotNull(news);
		for (News theNews : newsDao.getNews()) {
			System.out.println("News id: " + theNews.getId() + " News title: " + theNews.getNewsTitle());
		}
	}

	@Test
	@Transactional
	public void testFetchByIdNews() {
		final long NEWS_ID = 2;
		
		News news = newsDao.fetchByIdNews(NEWS_ID);

		assertEquals("Why the most effective players arenât always the winners.", news.getNewsTitle());
		
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSaveNews() {

		News news = new News();
		news.setNewsTitle("newsTitle");
		news.setNewsDate(new Date());
		news.setBrief("brief");
		news.setContent("content");
		newsDao.saveNews(news);

		final long newsId = news.getId();
		News insertedNews = newsDao.fetchByIdNews(newsId);
		
		assertEquals(insertedNews.getNewsTitle(), news.getNewsTitle());

	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteNews() { 

		final long NEWS_ID = 1;
		News news = newsDao.fetchByIdNews(NEWS_ID);

		newsDao.deleteNews(NEWS_ID);
		News newsDell = newsDao.fetchByIdNews(NEWS_ID);

		assertEquals(news.getStatus(), newsDell.getStatus());
		
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateNews() {

		final long NEWS_ID = 1;
		News news = newsDao.fetchByIdNews(NEWS_ID);

		news.setNewsTitle("Title");

		newsDao.updateNews(news);

		News insertedNews = newsDao.fetchByIdNews(NEWS_ID);

		assertEquals(insertedNews.getNewsTitle(), news.getNewsTitle());

	}
}
