package com.dev.alarmapplication.utils.extention

import com.dev.alarmapplication.data.model.response.view_mile.ViewMileLeave
import com.dev.alarmapplication.data.model.response.view_mile.ViewMileMission
import java.util.*


fun filterListByUserNameLeave(
    viewMileLeave: List<ViewMileLeave>,
    userName: String
): List<ViewMileLeave> =
    viewMileLeave.filter { item -> item.userName == userName }

fun filterListByUserNameLeave(viewMileLeave: List<ViewMileLeave>):List<ViewMileLeave> {
    val set: MutableSet<ViewMileLeave> = TreeSet { viewMileLeave1, mileLeave2 ->
        when {
            viewMileLeave1.userName.contentEquals(mileLeave2.userName) -> 0
            else -> 1
        }
    }
    set.addAll(viewMileLeave)
    return ArrayList(set)
}


fun sizeListByUserNameLeave(viewMileLeaveName: List<ViewMileLeave>, viewMileLeaveAll: List<ViewMileLeave>):List<ViewMileLeave> {
    viewMileLeaveName.forEach { itemViewMileLeaveName ->
        viewMileLeaveAll.forEach { itemViewMileLeaveAll ->
            if (itemViewMileLeaveName.userName==itemViewMileLeaveAll.userName){
                val size=itemViewMileLeaveName.size
                itemViewMileLeaveName.size=size+1
            }

        }
    }
    return viewMileLeaveName
}

fun filterListByUserNameMission(
    viewMileLeave: List<ViewMileMission>,
    userName: String
): List<ViewMileMission> =
    viewMileLeave.filter { item -> item.userName == userName }

fun filterListByUserNameMission(viewMileMission: List<ViewMileMission>):List<ViewMileMission> {
    val set: MutableSet<ViewMileMission> = TreeSet { viewMileLeave1, mileLeave2 ->
        when {
            viewMileLeave1.userName.contentEquals(mileLeave2.userName) -> 0
            else -> 1
        }
    }
    set.addAll(viewMileMission)
    return ArrayList(set)
}


fun sizeListByUserNameMission(viewMileLeaveName: List<ViewMileMission>, viewMileMissionAll: List<ViewMileMission>):List<ViewMileMission> {
    viewMileLeaveName.forEach { itemViewMileLeaveName ->
        viewMileMissionAll.forEach { itemViewMileLeaveAll ->
            if (itemViewMileLeaveName.userName==itemViewMileLeaveAll.userName){
                val size=itemViewMileLeaveName.size
                itemViewMileLeaveName.size=size+1
            }

        }
    }
    return viewMileLeaveName
}






