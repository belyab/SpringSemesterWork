package ru.kpfu.itis.baigulova.springsemesterwork.helper;

public class TextHelper {

    public static String editText(String text) {
        String result = text;

        if(result.length() > 225) {
            result = result.substring(0, 222) + "...";
        }

        return result;
    }
}
