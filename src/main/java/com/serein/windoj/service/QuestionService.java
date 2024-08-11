package com.serein.windoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.serein.windoj.model.dto.question.QuestionQueryRequest;
import com.serein.windoj.model.entity.Question;
import com.serein.windoj.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.serein.windoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Kusanagi
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-08-08 00:08:42
*/
public interface QuestionService extends IService<Question> {

    /**
     * 校验
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 获取查询包装类（根据前端用户传来的请求对象（根据哪些字段查询），得到 mybatis 框架支持的查询 QueryWrapper 类）
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);

    /**
     * 获取题目封装
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 分页获取题目封装
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
}
