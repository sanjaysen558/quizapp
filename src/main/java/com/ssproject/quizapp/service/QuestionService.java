package com.ssproject.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ssproject.quizapp.dao.QuestionMstDao;
import com.ssproject.quizapp.exception.AppException;
import com.ssproject.quizapp.model.QuestionMst;

@Service
public class QuestionService {
	
	@Autowired
	QuestionMstDao questionMstDao;
	
	public List<QuestionMst> getAllQuestion() {
		// TODO Auto-generated method stub
//		return questionMstDao.findAll();
		return questionMstDao.findAll(Sort.by(Sort.Order.asc("id")));
	}

	public List<QuestionMst> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return questionMstDao.findByCategory(category);
	}

	public void saveQuestion(QuestionMst questionMst) {
		// TODO Auto-generated method stub
		questionMstDao.save(questionMst);
//		questionMstDao.deleteById(null);
	}
	
	public String saveQuestions(List<QuestionMst> questionList) {
		// TODO Auto-generated method stub
		int cnt = 0; String msg;
		for(QuestionMst questionMst:questionList) {
			cnt++;
			questionMstDao.save(questionMst);
		}
		msg = cnt+" question inserted successfully";
		return ("{\"status\":\""+msg+"\"}").toString();
	}
	
	public void deleteQuestionById(int id) {
		if(!questionMstDao.existsById(id)) {
			String errMsg = "Invalid ID";
			String errDtl = "No record found in the system for given ID ("+id+")";
			throw new AppException(errMsg,errDtl,HttpStatus.NOT_FOUND);
		}
		questionMstDao.deleteById(id);
    }
	
	public List<QuestionMst> getRandomQuestion(String category, int numQ){
		return questionMstDao.findRandomQuestionByCategory(category, numQ);
	}

		
}
