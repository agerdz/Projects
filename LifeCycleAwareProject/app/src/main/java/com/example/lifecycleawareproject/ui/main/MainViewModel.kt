package com.example.lifecycleawareproject.ui.main
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import androidx.lifecycle.ViewModel
import com.example.lifecycleawareproject.DemoObserver
import androidx.lifecycle.MutableLiveData
//import com.example.lifecycleawareproject.DemoObserver.Companion.outputList


class MainViewModel : ViewModel() {

    var current = LocalDateTime.now()
    var formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    var formatted = current.format(formatter)



    //var stringList : MutableLiveData<String> = MutableLiveData()
    //var stringList : MutableLiveData<String> = MutableLiveData()
    companion object{
        //var stringList : MutableLiveData<String> = MutableLiveData()
        var stringList : MutableLiveData<String> = MutableLiveData()
        }
    fun setToEmptyList() {
        stringList.value = ""
    }
    fun getStringList() : MutableLiveData<String>{
        return stringList
    }


    // TODO: Implement the ViewModel
}


