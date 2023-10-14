package com.example.quizapp

import android.app.Application
import com.example.quizapp.api.ApiInterface
import com.example.quizapp.helper.ApiHelper
import com.example.quizapp.helper.RetrofitClientCalling.client

class AppCreator : Application() {
    companion object {

        private var mApiHelper: ApiHelper? = null
        fun getApiHelperInstance():ApiHelper{
            if(mApiHelper==null){
                mApiHelper = ApiHelper(client!!.create(ApiInterface::class.java))
            }
            return mApiHelper!!
        }

    }
}