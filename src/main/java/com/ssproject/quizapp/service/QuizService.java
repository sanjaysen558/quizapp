package com.ssproject.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ssproject.quizapp.model.QuizResponse;
import com.ssproject.quizapp.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ssproject.quizapp.dao.QuestionMstDao;
import com.ssproject.quizapp.dao.QuizDao;
import com.ssproject.quizapp.exception.AppException;
import com.ssproject.quizapp.model.QuestionMst;
import com.ssproject.quizapp.model.Quiz;
import com.ssproject.quizapp.service.wrapper.QuestionWrapper;
import com.ssproject.quizapp.service.wrapper.QuizWrapper;

import static java.lang.Math.round;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionService questionService;

	public ResponseEntity<String> createQuiz(String category, int numq, String title) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		
		List<QuestionMst> questionList = questionService.getRandomQuestion(category, numq);  
		
		if(quizDao.existsByTitle(title)) {
			throw new AppException("Title already exists", "Duplicate title not allowed", HttpStatus.BAD_REQUEST);
		}
		quiz.setQuestions(questionList);
		quiz.setTitle(title);
		
		quizDao.save(quiz);	
		
		return new ResponseEntity<>("created",HttpStatus.CREATED);
		
	}

	public ResponseEntity<QuizWrapper> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		
		//get list of questions from db
		List<QuestionMst> questionsFromDB = quiz.get().getQuestions();
		
		//prepare question-wrapper
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(QuestionMst q: questionsFromDB) {
			QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getCategory(), q.getQueTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(questionWrapper);
		}
		
		QuizWrapper quizWrapper = new QuizWrapper(quiz.get().getTitle(),questionsForUser);
		
		return new ResponseEntity<>(quizWrapper,HttpStatus.OK);
	}

	public ResponseEntity<QuizResult> evaluateQuizResponse(Integer id, List<QuizResponse> quizResponseList) {
		Optional<Quiz> quiz = quizDao.findById(id);
		int i = 0, right = 0;
		List<QuestionMst> questions = quiz.get().getQuestions();
		for (QuizResponse quizResponse:quizResponseList){
			if(quizResponse.getResponse().equals(questions.get(i).getRightAns()))
				right++;

			System.out.println(quizResponse.getId()+">>"+quizResponse.getResponse());
			System.out.println(questions.get(i).getId()+">>"+questions.get(i).getRightAns());
			System.out.println("--------------------");
			i++;
		}
		QuizResult quizResult = new QuizResult();
		quizResult.setCorrectAns(right);
		double percent = round(((double) right /i)*100);
		quizResult.setGainedPercent((percent)+"%");
		return new ResponseEntity<>(quizResult,HttpStatus.OK);
	}
}
