package com.dev.alarmapplication.utils.text_watcher;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.FontRes;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.textfield.TextInputLayout;
import com.dev.alarmapplication.R;
import com.dev.alarmapplication.utils.custom_view.CustomTypefaceSpan;
import com.dev.alarmapplication.utils.tools.HandleErrorTools;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CustomNumberWatcher implements TextWatcher {
    private final EditText editText;
    private final TextInputLayout textInputLayout;
    private final Context context;
    private final HandleErrorTools handelErrorTools;
    private OnCallBack callBack;

    private static final String[] bigNames = {
            "هزار", "میلیون", "میلیارد"};

    public CustomNumberWatcher(Context context, EditText editText, TextInputLayout tl, HandleErrorTools handelErrorTools) {
        this.context = context;
        this.editText = editText;
        this.textInputLayout = tl;
        this.handelErrorTools = handelErrorTools;

    }

    public CustomNumberWatcher(Context context, EditText editText, TextInputLayout tl, HandleErrorTools handelErrorTools,OnCallBack callBack) {
        this.context = context;
        this.editText = editText;
        this.textInputLayout = tl;
        this.handelErrorTools = handelErrorTools;
        this.callBack = callBack;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (textInputLayout == null) return;
        callBack.callBack(s);
        s = s.toString().replace(",", "");
        if (((String) s).isEmpty())
            textInputLayout.setHelperText(setFont(context, s.toString(), R.font.iran_sans_regular));
        else if (s.length() <= 12) {
            String ss = convertNumberToWords(Long.parseLong(s.toString()));
            textInputLayout.setHelperText(setFont(context, ss + " تومان ", R.font.iran_sans_regular));
        }
    }

    public static CharSequence setFont(Context context, String state, @FontRes int fontRes) {
        SpannableString s = new SpannableString(state);
        Typeface font = ResourcesCompat.getFont(context, fontRes);
        s.setSpan(new CustomTypefaceSpan("", font), 0, s.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return s;
    }

    public void afterTextChanged(Editable s) {
        try {
            editText.removeTextChangedListener(this);
            String value = s.toString();
            if (!value.isEmpty()) {
                if (value.startsWith("0")) editText.setText(value);
                value = value.replaceAll(",", "");
                editText.setText(getDecimalFormattedString(value));
                editText.setSelection(editText.getText().toString().length());
            }
            editText.addTextChangedListener(this);
        } catch (Exception e) {
            handelErrorTools.handleError(e);
            editText.addTextChangedListener(this);
        }

    }

    private static String getDecimalFormattedString(String value) {
        if (value.isEmpty()) return "";
        try {
            BigDecimal parsed = new BigDecimal(value);
            DecimalFormat formatter =
                    new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.US));
            return formatter.format(parsed);
        } catch (Exception ignored) {
            return value;
        }

    }

    // Range 0 to 999.
    private static String convert999(long n) {
        return String.valueOf(n);
    }

    private String convertNumberToWords(long n) {

        if (n < 0) {
            return "منفی " + convertNumberToWords(-n);
        }
        if (n <= 999) {
            return convert999(n);
        }
        StringBuilder s = null;
        int t = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                String s2 = convert999(n % 1000);
                if (t > 0) {
                    s2 = s2 + " " + bigNames[t - 1];
                }
                if (s == null) {
                    s = new StringBuilder(s2);
                } else {
                    s.insert(0, s2 + " و ");
                }
            }
            n /= 1000;
            t++;
        }
        return s == null ? null : s.toString();
    }

    public interface OnCallBack{
        void callBack(CharSequence charSequence);
    }


}