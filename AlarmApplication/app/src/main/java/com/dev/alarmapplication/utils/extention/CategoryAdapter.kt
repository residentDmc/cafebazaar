package com.dev.alarmapplication.utils.extention

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.View
import android.widget.TextView
import com.dev.alarmapplication.R
import java.lang.Exception
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun initPalletDescription(context: Context,textView: TextView, model:Int){
    when(model){
        1-> textView.text=context.resources.getString(R.string.metal_cabinet)
        2-> textView.text=context.resources.getString(R.string.mdf)
        3-> textView.text=context.resources.getString(R.string.members)
        4-> textView.text=context.resources.getString(R.string.glass)
    }
}

fun initCheckDiscountMoney(context: Context,txtPrice: TextView,txtDiscountPrice: TextView, money:String?){
    money.let {
        if (it.isNullOrEmpty()){
            txtDiscountPrice.setTextColor(context.resources.getColor(R.color.black))
            txtPrice.setTextColor(context.resources.getColor(R.color.black))
        }else{
            txtDiscountPrice.setTextColor(context.resources.getColor(R.color.black))
            txtPrice.setTextColor(context.resources.getColor(R.color.red))
            txtDiscountPrice.paintFlags = txtDiscountPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }
}

fun initPalletMoney(textView: TextView, money:String?){
    money.let {
        if (it.isNullOrEmpty()){
            textView.visibility=View.INVISIBLE
        }else{
            initVisibleItem(textView, money!!)
        }
    }
}


fun initPalletMoney(context: Context,lnParent:View,textViewDisCounted: TextView,textView: TextView, money:String?){
    money.let {
        if (it.isNullOrEmpty()){
            textView.visibility=View.GONE
            lnParent.visibility=View.GONE
        }else{
            initVisibleItem(context,lnParent,textViewDisCounted,textView, money!!)
        }
    }
}

@SuppressLint("SetTextI18n")
fun initVisibleItem(textView: TextView, money: String) {
    textView.visibility=View.VISIBLE
    val resultMoney= try {
        val parsed = BigDecimal(money)
        val formatter = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US))
        formatter.format(parsed)
    } catch (ignored: Exception) {
        money
    }
    textView.text="$resultMoney تومان "
}

@SuppressLint("SetTextI18n")
fun initResultPalletMoney(money: String):String {
    val resultMoney= try {
        val parsed = BigDecimal(money)
        val formatter = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US))
        formatter.format(parsed)
    } catch (ignored: Exception) {
        money
    }
   return resultMoney
}

@SuppressLint("SetTextI18n")
fun initVisibleItem(context: Context,lnParent:View,textViewDisCounted: TextView,textView: TextView, money: String) {
    textView.visibility=View.VISIBLE
    lnParent.visibility=View.VISIBLE
    textViewDisCounted.text=context.resources.getString(R.string.discounted)
    val resultMoney= try {
        val parsed = BigDecimal(money)
        val formatter = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US))
        formatter.format(parsed)
    } catch (ignored: Exception) {
        money
    }
    textView.text="$resultMoney تومان "
}
