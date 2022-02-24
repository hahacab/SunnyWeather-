package com.example.activitytest

import android.app.Activity

object ActivityCollector {
    private val activities = ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing){
                activity.finish()
                android.os.Process.killProcess(android.os.Process.myPid())//杀掉当前进程的代码，保证程序完全退出
            }
        }
    }
}