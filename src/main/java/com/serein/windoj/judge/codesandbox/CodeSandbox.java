package com.serein.windoj.judge.codesandbox;

import com.serein.windoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: serein
 * @date: 2024/9/5 11:19
 * @description: 代码沙箱接口定义
 */
public interface CodeSandbox {
    /**
     * 沙箱执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
