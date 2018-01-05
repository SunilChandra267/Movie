package com.sri.movie.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(name="getAll",query="select movie from MovieDTO movie"),
	@NamedQuery(name="getProducer",query="select movie.movie_producername from MovieDTO movie where movie_name=:mname"),
	@NamedQuery(name="getCount",query="select count(movie) from MovieDTO movie"),
	@NamedQuery(name="getMaxBudget",query="Select movie from MovieDTO movie where movie.id IN (select movie1.movie_id,max(movie1.movie_budget) from MovieDTO movie1 group by movie1.movie_budget,movie1.movie_id)")
	//@NamedQuery(name="getMaxId",query="select max(movie.id) from MovieDTO movie group by movie.id")
})

@Entity
@Table(name="movie")
public class MovieDTO 
{
	@Id
	@Column(name="id")
	@GenericGenerator(name="getId",strategy="increment")
	@GeneratedValue(generator="getId")
	private int movie_id;
	@Column(name="name")
	private String movie_name;
	@Column(name="producername")
	private String movie_producername;
	@Column(name="budget")
	private double budget;
	public MovieDTO() {
		// TODO Auto-generated constructor stub
		System.out.println("MovieDTO created!!!");
	}
	
	
	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public String getMovie_name() {
		return movie_name;
	}


	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}


	public String getMovie_producername() {
		return movie_producername;
	}


	public void setMovie_producername(String movie_producername) {
		this.movie_producername = movie_producername;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	@Override
	public String toString() {
		return "MovieDTO [movie_id=" + movie_id + ", movie_name=" + movie_name + ", movie_producername="
				+ movie_producername + ", budget=" + budget + "]";
	}
	
}
