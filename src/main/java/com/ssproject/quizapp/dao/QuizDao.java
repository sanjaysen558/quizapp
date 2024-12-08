package com.ssproject.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssproject.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

	public boolean existsByTitle(String title);
}
