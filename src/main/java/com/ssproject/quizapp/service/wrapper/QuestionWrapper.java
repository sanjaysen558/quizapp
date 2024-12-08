package com.ssproject.quizapp.service.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuestionWrapper {
	
	private Integer id;
	private String category;
	private String queTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	public QuestionWrapper(Integer id, String category, String queTitle, String option1, String option2, String option3,String option4) {
		this.id = id;
		this.category = category;
		this.queTitle = queTitle;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQueTitle() {
		return queTitle;
	}
	
	
	
	
	
	
}
