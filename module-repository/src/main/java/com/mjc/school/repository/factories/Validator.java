package com.mjc.school.repository.factories;

public class Validator {
    public static String validate(String inLetter, String begin, String end){
        int startIndex = inLetter.indexOf(begin);

        if (startIndex == -1) {
            return "";
        }
        int endIndex = inLetter.indexOf(end, startIndex);
        if (endIndex == -1) {
            return inLetter.substring(startIndex + begin.length());
        }
        return inLetter.substring(startIndex + begin.length(), endIndex);
    }
}
