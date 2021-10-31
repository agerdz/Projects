package com.example.lifecycleawareproject.ui.main
import java.time.format.DateTimeFormatter
import java.time.LocalDateTime
import androidx.lifecycle.ViewModel
import com.example.lifecycleawareproject.DemoObserver
import androidx.lifecycle.MutableLiveData
//import com.example.lifecycleawareproject.DemoObserver.Companion.outputList


class MainViewModel : ViewModel() {

    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    val formatted = current.format(formatter)

    //var stringList : MutableLiveData<String> = MutableLiveData()
    //var stringList : MutableLiveData<String> = MutableLiveData()
    companion object{
        //var stringList : MutableLiveData<String> = MutableLiveData()
        var stringList : MutableLiveData<String> = MutableLiveData()
        }
    fun setToEmptyList() {
        stringList.value = ""
    }


    // TODO: Implement the ViewModel
}


