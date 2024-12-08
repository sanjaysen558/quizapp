package com.ssproject.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "QUESTION_MST")
public class QuestionMst {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_mst_seq")
	@SequenceGenerator(name = "question_mst_seq", sequenceName = "question_mst_seq", allocationSize = 1)
	private Integer id;
	private String category;
	private String diffLevel;
	private String queTitle;
	private String rightAns;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	
	
	public Integer getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDiffLevel() {
		return diffLevel;
	}
	public void setDiffLevel(String diffLevel) {
		this.diffLevel = diffLevel;
	}
	public String getQueTitle() {
		return queTitle;
	}
	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}
	public String getRightAns() {
		return rightAns;
	}
	public void setRightAns(String rightAns) {
		this.rightAns = rightAns;
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
}
