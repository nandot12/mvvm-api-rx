package com.lauwba.mvvmrxapi.ui.mainactivity2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lauwba.mvvmrxapi.model.ModelResponse
import com.lauwba.mvvmrxapi.repo.RepoNews

class MainActivity2ViewModel : ViewModel() {


   private val repo = RepoNews()
    val progressBar = MutableLiveData<Boolean>()
   val apiSucess = MutableLiveData<ModelResponse>()
    val apiError = MutableLiveData<Throwable>()



    fun getNews(){

        progressBar.value = true

        repo.getNews({it ->
            progressBar.value = false
            apiSucess.value = it

        },{
            it ->
            progressBar.value = false ; apiError.value = it
        })
    }
}
