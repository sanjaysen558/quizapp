package com.ssproject.quizapp.controller;

import java.util.List;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssproject.quizapp.model.QuestionMst;
import com.ssproject.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public List<QuestionMst> getAllQue() {
		return questionService.getAllQuestion();
	}
	
	@GetMapping("category/{category}")
	public List<QuestionMst> getQueByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	@GetMapping("filter")
	public List<QuestionMst> getQueByCategoryParam(@RequestParam(name="category", required= false) String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("new")
	public String  postQue(@RequestBody QuestionMst questionMst) {
		questionService.saveQuestion(questionMst);
		return new JSONObject("{\"status\":\"success\"}").toString();
				
	}
	
	@PostMapping("v2/new")
	public String  postQue(@RequestBody List<QuestionMst> questionList) {
		return questionService.saveQuestions(questionList);
	}
	
	@DeleteMapping("/{id}")
	public String deleteQuestion(@PathVariable int id) {
        questionService.deleteQuestionById(id);
        String msg = "Question with ID ("+id+") has been deleted..!";
        return new JSONObject("{\"status\":\""+msg+"\"}").toString();
    } 
	
}
