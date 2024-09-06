package com.serein.windoj.judge.codesandbox;

import com.serein.windoj.judge.strategy.JudgeContext;
import com.serein.windoj.judge.strategy.JudgeStrategy;
import com.serein.windoj.judge.strategy.impl.DefaultJudgeStrategy;
import com.serein.windoj.judge.strategy.impl.JavaJudgeStrategy;
import com.serein.windoj.judge.codesandbox.model.JudgeInfo;
import com.serein.windoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * @author: serein
 * @date: 2024/9/6 11:35
 * @description: 自动根据语言判断选择对应判题策略，简化对判题功能的调用，让调用方更加方便。
 */
@Service
public class JudgeManager {

    /**
     * 根据语言选择判题策略执行判题
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
