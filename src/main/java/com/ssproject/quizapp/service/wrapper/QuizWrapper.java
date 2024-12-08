package com.ssproject.quizapp.service.wrapper;

import java.util.List;

public class QuizWrapper {

	public String title;
	public List<QuestionWrapper> questionWrapper;
	
	public QuizWrapper(String title, List<QuestionWrapper> questionWrapper) {
		this.title = title;
		this.questionWrapper = questionWrapper;
	}

	public String getTitle() {
		return title;
	}

	public List<QuestionWrapper> getQuestionWrapper() {
		return questionWrapper;
	}
	
	
}
