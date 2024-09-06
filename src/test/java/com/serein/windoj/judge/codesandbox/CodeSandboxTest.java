package com.serein.windoj.judge.codesandbox;

import com.serein.windoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.serein.windoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.serein.windoj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: serein
 * @date: 2024/9/5 11:42
 * @description: 代码沙箱测试类
 */
@SpringBootTest
class CodeSandboxTest {

    // 从yml配置文件中直接读取代码沙箱type的值
    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        CodeSandbox codeSandBox = new RemoteCodeSandbox();
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    @Test
    void executeCodeByValue() {
        CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
        codeSandBox = new CodeSandboxProxy(codeSandBox);
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandbox codeSandBox = CodeSandboxFactory.newInstance(type);
            String code = "int main() {}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandBox.executeCode(executeCodeRequest);
        }
    }
}