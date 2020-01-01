package be.hub.jimmymiels.routefinder.title

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    var searchTerm = MutableLiveData<String>()

fun setSearchTerm(msg:String) {
    searchTerm.setValue(msg)
}



}