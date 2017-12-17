package by.htp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.entity.News;

@Repository
public class NewsDaoImpl implements NewsDao {
	private static final String SQL_SELECT = "From News WHERE status = 'Y' order by newsDate";
	private static final String SQL_UPDATE = "UPDATE News SET status = 'N' WHERE id= :id";
	private static final String SQL_ID = "id";

	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public List<News> getNews() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<News> theQuery = currentSession.createQuery(SQL_SELECT, News.class);

		List<News> theNews = theQuery.getResultList();

		return theNews;
	}

	// @Override
	public News fetchByIdNews(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		News theNews = currentSession.get(News.class, theId);

		return theNews;
	}

	// @Override
	public void saveNews(News theNews) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(theNews);
	}

	// @Override
	public void deleteNews(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery(SQL_UPDATE);

		query.setParameter(SQL_ID, theId);

		query.executeUpdate();

	}

	// @Override
	public void updateNews(News theNews) {
		Session curentSession = sessionFactory.getCurrentSession();

		curentSession.saveOrUpdate(theNews);

	}

}
