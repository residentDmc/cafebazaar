package com.dev.alarmapplication.utils.extention

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import com.dev.alarmapplication.R

fun initPalletColor(context: Context,textView: TextView, color:Int){
    when(color){
        1-> textView.text=context.resources.getString(R.string.white)
        2-> textView.text=context.resources.getString(R.string.white_duck)
        3-> textView.text=context.resources.getString(R.string.pine)
        4-> textView.text=context.resources.getString(R.string.shine)
        5-> textView.text=context.resources.getString(R.string.light)
        6-> textView.text=context.resources.getString(R.string.design)
        7-> textView.text=context.resources.getString(R.string.carpet)
        8-> textView.text=context.resources.getString(R.string.stone)
        9-> textView.text=context.resources.getString(R.string.dark_stone)
        10-> textView.text=context.resources.getString(R.string.rafia_roshan)
        11-> textView.text=context.resources.getString(R.string.dark_rafia)
        12-> textView.text=context.resources.getString(R.string.gray)
        13-> textView.text=context.resources.getString(R.string.walnut)
        14-> textView.text=context.resources.getString(R.string.melch)
        15-> textView.text=context.resources.getString(R.string.white_silver)
        16-> textView.text=context.resources.getString(R.string.white_silver_gold)
    }
}

fun initPalletValidPiece(context: Context,textView: TextView, color:Int){
    when(color){
        0-> textView.text=context.resources.getString(R.string.is_a_service)
        1-> textView.text=context.resources.getString(R.string.is_a_piece_of_work)
    }
}

fun initPalletKnobs(context: Context, view: View, textView: TextView, knobs:Int){
    view.visibility=View.VISIBLE
    when(knobs){
        1-> textView.text=context.resources.getString(R.string.plastic)
        2-> textView.text=context.resources.getString(R.string.steel)
        3-> view.visibility=View.GONE
    }
}

fun initPalletBase(context: Context, view: View, textView: TextView, knobs:Int){
    view.visibility=View.VISIBLE
    when(knobs){
        1-> textView.text=context.resources.getString(R.string.plastic)
        2-> textView.text=context.resources.getString(R.string.metal)
        3-> view.visibility=View.GONE
    }
}



@SuppressLint("SetTextI18n")
fun initPalletPiece(context: Context, textView: TextView, piece:String){
   textView.text="$piece ${context.resources.getString(R.string.piece_value)}"
}

@SuppressLint("SetTextI18n")
fun initPalletThickness(context: Context, view: View, textView: TextView, thickness:Double?){
    if (thickness==null){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$thickness ${context.resources.getString(R.string.thickness_value)}"
    }
}

@SuppressLint("SetTextI18n")
fun initPalletScreenDepth(context: Context, view: View, textView: TextView, screenDepth:Double?){
    if (screenDepth==null){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$screenDepth ${context.resources.getString(R.string.thickness_value)}"
    }
}

@SuppressLint("SetTextI18n")
fun initPalletScreen(view: View, textView: TextView, screen:String?){
    if (screen.isNullOrEmpty()){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text=screen
    }
}

@SuppressLint("SetTextI18n")
fun initPalletAerialHeight(context: Context, view: View, textView: TextView, aerialHeight:Int){
    if (aerialHeight==0){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$aerialHeight ${context.resources.getString(R.string.centimeter_value)}"
    }
}

@SuppressLint("SetTextI18n")
fun initPalletAerialDepth(context: Context, view: View, textView: TextView, aerialHeight:Int){
    if (aerialHeight==0){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$aerialHeight ${context.resources.getString(R.string.centimeter_value)}"
    }
}

@SuppressLint("SetTextI18n")
fun initPalletGroundHeight(context: Context, view: View, textView: TextView, groundHeight:Int){
    if (groundHeight==0){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$groundHeight ${context.resources.getString(R.string.centimeter_value)}"
    }

}

@SuppressLint("SetTextI18n")
fun initPalletGroundDepth(context: Context, view: View, textView: TextView, groundHeight:Int){
    if (groundHeight==0){
        view.visibility=View.GONE
    }else{
        view.visibility=View.VISIBLE
        textView.text="$groundHeight ${context.resources.getString(R.string.centimeter_value)}"
    }

}
