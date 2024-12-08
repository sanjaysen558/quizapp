package com.ssproject.quizapp.controller;

import com.ssproject.quizapp.model.QuizResponse;
import com.ssproject.quizapp.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssproject.quizapp.service.QuizService;
import com.ssproject.quizapp.service.wrapper.QuizWrapper;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numq,@RequestParam String title) {
		return quizService.createQuiz(category,numq,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<QuizWrapper> getQuiz(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<QuizResult> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse> quizResponseList) {
		return quizService.evaluateQuizResponse(id,quizResponseList);
	}

}
