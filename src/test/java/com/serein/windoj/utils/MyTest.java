package com.serein.windoj.utils;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: serein
 * @date: 2024/8/12 15:23
 * @description:
 */
public class MyTest {
    List<String> path = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.partition("aabaa");
        System.out.println(myTest.ans);
    }

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return ans;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < s.length(); i++) {
            String cut = s.substring(startIndex, i + 1);    // substring包前不包后
            if (isPalindrome(cut)) {
                path.add(cut);
                backTracking(s, i + 1);
                path.remove(path.size() -  1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isValid(String ipcut) {
        if (ipcut.length() > 1 && ipcut.startsWith("0")) {
            return false;
        }
        int ipNum = Integer.parseInt(ipcut);
        if (ipNum < 0 || ipNum > 255) {
            return false;
        }
        return true;
    }
}
