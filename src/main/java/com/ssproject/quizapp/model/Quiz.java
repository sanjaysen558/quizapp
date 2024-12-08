package com.ssproject.quizapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
	private int Id;
	
	private String title;
	
	@ManyToMany
	private List<QuestionMst> questions;


	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<QuestionMst> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionMst> questions) {
		this.questions = questions;
	}
	
	
	
	
}
