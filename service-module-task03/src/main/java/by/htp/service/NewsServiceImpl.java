package by.htp.service;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.htp.dao.NewsDao;
import by.htp.entity.News;
import by.htp.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	private static final Logger LOG = Logger.getLogger(NewsServiceImpl.class);
	
	@Autowired
	private NewsDao newsDao;

	// @Override
	@Transactional
	public List<News> getNews()  {
		List<News> listNews = newsDao.getNews();
		
			if(listNews.isEmpty() || listNews == null){
					LOG.error("List news is empty");
			} 
		
		return listNews;
	}
	
	

	// @Override
	@Transactional
	public News fetchByIdNews(long theId) {
		return newsDao.fetchByIdNews(theId);
	}

	// @Override
	@Transactional
	public void saveNews(News theNews) {
		newsDao.saveNews(theNews);

	}

	// @Override
	@Transactional
	public void deleteNews(long theId) {
		newsDao.deleteNews(theId);

	}

	// @Override
	@Transactional
	public void updateNews(News theNews) {
		newsDao.updateNews(theNews);

	}

}
