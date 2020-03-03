package com.lauwba.mvvmrxapi.repo

import com.lauwba.mvvmrxapi.model.ModelResponse
import com.lauwba.mvvmrxapi.network.NetworkConfig
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoNews {



    val api = NetworkConfig.ApiService()

    val compositeDisposable = CompositeDisposable()



    fun getNews(successHandler: (ModelResponse) -> Unit , error : (Throwable) -> Unit){


        compositeDisposable.add( api.getNews().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                successHandler(it)

            },{

                error(it)
            }))

    }
}