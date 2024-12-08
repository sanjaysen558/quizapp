package com.ssproject.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssproject.quizapp.model.QuestionMst;

@Repository
public interface QuestionMstDao extends JpaRepository<QuestionMst, Integer> 
{
	
	List<QuestionMst> findByCategory(String categoryString);
	
	@Query(value = "SELECT * FROM(SELECT * FROM QUESTION_MST Q WHERE CATEGORY = :category ORDER BY DBMS_RANDOM.VALUE(1,10))\r\n"
			+ "WHERE ROWNUM<=:numQ", nativeQuery = true)
	List<QuestionMst> findRandomQuestionByCategory(String category, int numQ);
}
