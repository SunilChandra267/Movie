package com.sri.movie.util;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sri.movie.dao.MovieDAO;
import com.sri.movie.dto.MovieDTO;

public class MovieUtil 
{
	static MovieDAO dao = new MovieDAO();
	static MovieDTO dto = new MovieDTO();
	
	public static void main(String[] args) 
	{
//		saveAndReturnId();
//		updateBudgetByName();
//		fetchAll();
//		fetchProducerNameByMovieName();
//		fetchCount1();
		fetchMaxBudget();
	}
	//Question1
	static void saveAndReturnId()
	{
	//	dto.setMovie_id(1);
		dto.setMovie_name("JanumadaJodi");
		dto.setMovie_producername("Shivarajkumar");
		dto.setMovie_producername("SriHari");
		int result = dao.saveAndReturnId(dto); 
		if(result>-1)
			System.out.println("Recored Saved....."+result);
		else
			System.out.println("Record Not saved>>>>>>");
	}
	//Question2
	static void updateBudgetByName()
	{
		dao.updateBudgetByName("JanumadaJodi", 497.47);
	}
	//Question3
	static void fetchAll()
	{
		List list = dao.fetchAll();
		Iterator<MovieDTO> iterator = list.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	//Question4
	static void fetchProducerNameByMovieName() 
	{
		System.out.println(dao.fetchProducerNameByMovieName("JanumadaJodi"));
	}
	//Question4
	//way1
	static void fetchCount()
	{
		System.out.println("total records in database:"+dao.fetchCount());
	}
	//way2
	static void fetchCount1()
	{
		System.out.println("total records in database:"+dao.fetchCount1());
	}
	//Question5
	static void fetchMaxBudget() 
	{
//		System.out.println("Movie with maximum Budget:"+dao.fetchMaxBudget());
	}
}
