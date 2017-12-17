package by.htp.service;

import java.util.List;

import by.htp.entity.News;

public interface NewsService {

	public List<News> getNews();

	public News fetchByIdNews(long theId);

	public void saveNews(News theNews);

	public void deleteNews(long theId);

	public void updateNews(News theNews);

}
