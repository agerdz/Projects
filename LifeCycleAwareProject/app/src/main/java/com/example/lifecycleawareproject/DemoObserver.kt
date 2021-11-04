package com.example.lifecycleawareproject

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import androidx.lifecycle.MutableLiveData
import com.example.lifecycleawareproject.ui.main.MainViewModel.Companion.stringList

class DemoObserver: LifecycleObserver {

    //var current = LocalDateTime.now()
    //var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    //var formatted = current.format(formatter)

    //companion object{
    //    var outputList : MutableLiveData<String> = MutableLiveData()

    //}

    //fun addName(lifecycleaction: String){
    //    outputList.value = outputList.value.plus(lifecycleaction).plus(formatted).plus("\n")
    //}

    private val LOG_TAG = "DemoObserver"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onResume")
        Log.i(LOG_TAG, stringList.toString())
        //outputList.setValue(outputList.value.plus("onResume").plus(formatted).plus("\n"))
        //outputList.value = outputList.value.plus("onResume").plus(formatted).plus("\n")
        //addName(    "onResume")
        stringList.value = stringList.value.plus("onResume was fired on ").plus(formatted).plus("\n").plus("*********").plus("\n")
        //stringList.setValue(stringList.value.plus("onResume").plus(formatted).plus("\n"))
        

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onPause")
        //outputList.value = outputList.value.plus("onPause").plus(formatted).plus("\n")
        stringList.value = stringList.value.plus("onPause was fired on ").plus(formatted).plus("\n").plus("*********").plus("\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onCreate")
        //Log.i(LOG_TAG, outputList.toString())
        //outputList.value = (outputList.value.plus("onCreate").plus(formatted).plus("\n"))
        stringList.value = stringList.value.plus("onCreate was fired on ").plus(formatted).plus("\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onStart")
        //outputList.value = (outputList.value.plus("onStart").plus(formatted).plus("\n"))
        stringList.value = stringList.value.plus("onStart was fired on ").plus(formatted).plus("\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onStop")
        //outputList.value = (outputList.value.plus("onStop").plus(formatted).plus("\n"))
        stringList.value = stringList.value.plus("onStop was fired on ").plus(formatted).plus("\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        var current = LocalDateTime.now()
        var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        var formatted = current.format(formatter)
        Log.i(LOG_TAG, "onDestroy")
        //outputList.value = (outputList.value.plus("onDestroy").plus(formatted).plus("\n"))
        stringList.value = stringList.value.plus("onDestroy was fired on ").plus(formatted).plus("\n").plus("*********").plus("\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)

    }

}