package com.example.ContactProject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ProductRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ProductRoomDatabase? =
            ProductRoomDatabase.getDatabase(application)
        contactDao = db?.productDao()
        allContacts = contactDao?.getAllContacts()

    }

    fun insertContact(newproduct: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newproduct)
        }
    }
    private suspend fun asyncInsert(product: Contact) {
        contactDao?.insertContact(product)
    }

    fun deleteContact(name: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }
    private suspend fun asyncDelete(name: Int) {
        contactDao?.deleteContact(name)
    }

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }

    /*fun sortASC() {
        coroutineScope.launch(Dispatchers.IO) {
            asyncASC()
        }
    }
    private suspend fun asyncASC() {
        contactDao?.sortASC()*/
   //}
    fun sortASC(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncSortASC().await()
        }
    }

    private suspend fun asyncSortASC(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.sortASC()
        }

    fun sortDES(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncSortDES().await()
        }
    }

    private suspend fun asyncSortDES(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.sortDES()
        }


}