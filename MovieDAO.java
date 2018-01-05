package com.sri.movie.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sri.movie.dto.MovieDTO;
import com.sri.ssf.SSF;

public class MovieDAO {
	private SessionFactory sessionFactory = SSF.getSessionFactory();

	public Integer saveAndReturnId(MovieDTO dto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Integer result = -1;
		try {
			result = (Integer) session.save(dto);
			transaction.commit();
			return result;
		} catch (HibernateException he) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	public void updateBudgetByName(String name, double budget) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String hqlQuery = "select movie from MovieDTO movie where name=:mvn";
		Query query;
		try {
			query = session.createQuery(hqlQuery);
			query.setParameter("mvn", name);
			MovieDTO dto = (MovieDTO) query.uniqueResult();
			dto.setBudget(budget);
			session.save(dto);
			transaction.commit();
			System.out.println("<<<<<<<<Updated Budget>>>>>>>");
		} catch (HibernateException he) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public List<MovieDTO> fetchAll() {
		Session session = sessionFactory.openSession();

		Query query;
		try {
			query = session.getNamedQuery("getAll");
			List<MovieDTO> list = query.list();
			return list;
		} finally {
			session.close();
		}
	}

	public String fetchProducerNameByMovieName(String mname) {
		Session session = sessionFactory.openSession();

		Query query;
		try {
			query = session.getNamedQuery("getProducer");
			query.setParameter("mname", mname);
			String producer = (String) query.uniqueResult();
			return producer;
		} finally {
			session.close();
		}
	}

	public long fetchCount() {
		List list = fetchAll();
		return list.size();
	}

	public Long fetchCount1() {
		Session session = sessionFactory.openSession();

		Query query;
		try {
			query = session.getNamedQuery("getCount");
			Long count = (Long) query.uniqueResult();
			return count;
		} finally {
			session.close();
		}
	}

	/*public Double fetchMaxBudget() {
		Session session = sessionFactory.openSession();

		Query query;
		try {
			query = session.getNamedQuery("getCount");
			
//			MovieDTO dto = (MovieDTO) query.uniqueResult();
////			Long maxBudget = (Long) query.list().get(0);
////			return maxBudget;
//			return dto.getBudget();
		} finally {
			session.close();
		}
	}*/

}
