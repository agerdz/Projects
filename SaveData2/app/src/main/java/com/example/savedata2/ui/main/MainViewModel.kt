package com.example.savedata2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    var nameEnter: MutableLiveData<String> = MutableLiveData()
    var stringList : MutableLiveData<String> = MutableLiveData()



    fun addName ()
    {
        //if(binding.editTextName.text.isNotEmpty())
        //{
        //viewModel.stringList = viewModel.stringList.plus(binding.editTextName.text.toString()).plus("\n")
        //binding.message.text = viewModel.stringList
        if(stringList.value == null)
        {
            stringList.value = ""
        }

        if(nameEnter.value?.isNotEmpty() == true)
        {
            stringList.value = stringList.value.plus(nameEnter.value.toString().plus("\n"))
        }
        //stringList.value = stringList.value.plus(nameEnter.value.toString().plus("\n"))
        //stringList.value = "OK"

    }

// TODO: Implement the ViewModel
}