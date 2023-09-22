package com.nado.main;

import com.nado.service.StringService;

public class Main {
    public static void main(String[] args) {

        String input1 = "abd(JNB)asdf";
        String input2 = "abdjnbasdf";
        String input3 = "dd(df)a(ghhh)";

        System.out.println(StringService.reverseWordsInParentheses(input1));
        System.out.println(StringService.reverseWordsInParentheses(input2));
        System.out.println(StringService.reverseWordsInParentheses(input3));

    }
}