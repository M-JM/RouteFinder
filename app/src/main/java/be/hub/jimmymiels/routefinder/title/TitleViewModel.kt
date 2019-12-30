package be.hub.jimmymiels.routefinder.title

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    var searchTerm = MutableLiveData<String>()


    init {
        Log.i("TitleViewModel","TitleViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TitleViewModel","TitleViewModel destroyed!")
    }
}