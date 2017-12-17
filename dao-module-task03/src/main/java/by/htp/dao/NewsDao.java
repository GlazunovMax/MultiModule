package by.htp.dao;

import java.util.List;
import by.htp.entity.News;

public interface NewsDao {
	public List<News> getNews();

	public News fetchByIdNews(long theId);

	public void saveNews(News theNews);

	public void deleteNews(long theId);

	public void updateNews(News news);

}
