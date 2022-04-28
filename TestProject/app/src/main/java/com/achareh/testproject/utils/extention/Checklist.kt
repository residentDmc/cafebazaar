package com.achareh.testproject.utils.extention

import android.view.View

fun initCheckShowList(vParent: View, vNoItem: View, checkList:Boolean){
    if (checkList){
        vNoItem.visibility= View.VISIBLE
        vParent.visibility= View.GONE
    }else{
        vNoItem.visibility= View.GONE
        vParent.visibility= View.VISIBLE
    }
}