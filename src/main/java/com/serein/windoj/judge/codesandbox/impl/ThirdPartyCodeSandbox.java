package com.serein.windoj.judge.codesandbox.impl;

import com.serein.windoj.judge.codesandbox.CodeSandbox;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: serein
 * @date: 2024/9/5 11:35
 * @description: 第三方代码沙箱（调用现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
