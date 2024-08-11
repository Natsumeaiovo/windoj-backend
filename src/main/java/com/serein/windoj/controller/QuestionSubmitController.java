package com.serein.windoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.serein.windoj.common.BaseResponse;
import com.serein.windoj.common.ErrorCode;
import com.serein.windoj.common.ResultUtils;
import com.serein.windoj.exception.BusinessException;
import com.serein.windoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.serein.windoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.serein.windoj.model.entity.Question;
import com.serein.windoj.model.entity.QuestionSubmit;
import com.serein.windoj.model.entity.User;
import com.serein.windoj.model.vo.QuestionSubmitVO;
import com.serein.windoj.service.QuestionSubmitService;
import com.serein.windoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 *
 * @author serein
 * @from <a href="https://natsumeaiovo.github.io">serein's blog</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录的 id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                               HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能提交题目
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交信息列表（除了管理员外，普通用户只能看到非答案，非提交代码等公开信息）
     * @param questionSubmitQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(
            @RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent(); // 获取当前页
        long size = questionSubmitQueryRequest.getPageSize();   // 获取每页大小
        // 查询到原始的题目提交分页信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQuerySubmitWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);   // 获取到登录用户
        // 返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }
}