package com.iiitlucknow.android.festify.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iiitlucknow.android.festify.API.retrofitInstance
import com.iiitlucknow.android.festify.data_classes.EventData
import com.iiitlucknow.android.festify.data_classes.UserData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class HomeViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _myUserData = MutableLiveData<UserData>()
    val myUserData: LiveData<UserData> = _myUserData


    init {
        getuser()
    }

    fun getuser() {

        viewModelScope.launch {
            try {
                _myUserData.value =
                    retrofitInstance.api.getUserData()
                _status.value = "SUCCESS"


            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
