package com.example.ContactProject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ContactProject.Contact
import com.example.ContactProject.ProductRepository

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository: ProductRepository = ProductRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
    }
    fun insertProduct(product: Contact) {
        repository.insertContact(product)
    }
    fun findProduct(name: String) {
        repository.findContact(name)
    }
    fun deleteProduct(id: Int) {
        repository.deleteContact(id)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllProducts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun sortASC(){
        repository.sortASC()
    }
    fun sortDES(){
        repository.sortDES()
    }
}