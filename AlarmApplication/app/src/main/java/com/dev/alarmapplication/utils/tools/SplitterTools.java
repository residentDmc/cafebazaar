package com.dev.alarmapplication.utils.tools;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SplitterTools {

    public List<String> splitterStringList(String messageText) {
        List<String> splitterList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageText.length(); i++)
            if (!(messageText.charAt(i) == ',')) sb.append(messageText.charAt(i));
            else {
                if (!sb.toString().isEmpty())
                    splitterList.add(0, sb.toString().trim());
                sb.delete(0, sb.length());
            }
        if (!sb.toString().isEmpty())
            splitterList.add(0, sb.toString().trim());
        return splitterList;
    }

    @NonNull
    public String codeSplitter(@NonNull String messageText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageText.length(); i++)
            if (messageText.charAt(i) >= '0' && messageText.charAt(i) <= '9') {
                sb.append(messageText.charAt(i));
            }
        return sb.toString();
    }
}
