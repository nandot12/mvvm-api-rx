package com.lauwba.mvvmrxapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lauwba.mvvmrxapi.model.ModelResponse
import com.lauwba.mvvmrxapi.ui.mainactivity2.MainActivity2ViewModel

class MainActivity : AppCompatActivity() {

  private  var viewModel : MainActivity2ViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel  = CreateViewModel()
        viewModel?.getNews()
        setUpObserver()
    }

    private fun setUpObserver() {


        viewModel?.progressBar?.observe(this, Observer { showProgressBar(it) })
        viewModel?.apiError?.observe(this, Observer { showError(it) })
        viewModel?.apiSucess?.observe(this, Observer { showSuccess(it) })
    }

    private fun showSuccess(it: ModelResponse?) {
      //  it.articles
        //show ke recyclerview

    }

    private fun showError(it: Throwable?) {

        //show alert error nya

    }

    private fun showProgressBar(it: Boolean) {

        if (it) //shoow progress
            else{
            //hide progress
        }

    }

    private fun CreateViewModel() = ViewModelProviders.of(this).get(MainActivity2ViewModel::class.java)



}
