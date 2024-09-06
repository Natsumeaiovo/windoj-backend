package com.serein.windoj.judge.codesandbox.impl;

import com.serein.windoj.judge.codesandbox.CodeSandbox;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author: serein
 * @date: 2024/9/5 11:35
 * @description: 远程代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        return null;
    }
}
