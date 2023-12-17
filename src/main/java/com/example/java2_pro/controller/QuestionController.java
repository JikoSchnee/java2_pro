package com.example.java2_pro.controller;

import com.example.java2_pro.entity.special.QuestionWithTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.java2_pro.service.QuestionService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // 获得某关键词相关的问题
    @GetMapping("/keyword/{keyword}")
    public List<QuestionWithTags> getQuestionByKeyword(@PathVariable String keyword){
        return questionService.getQuestionsWithKeywords(keyword);
    }

    // 获得所有问题的记数
    @GetMapping("/count")
    public List<Integer> getQuestionCount(){
        return questionService.getQuestionsCount();
    }

    // 获得某关键词相关问题的记数
    @GetMapping("/count/keyword/{keyword}")
    public List<Integer> getQuestionCountByKeyword(@PathVariable String keyword) {
        return questionService.getQuestionsCountByKeyword(keyword);
    }
}
