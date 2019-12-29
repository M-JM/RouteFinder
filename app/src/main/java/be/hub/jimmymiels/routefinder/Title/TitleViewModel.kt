package be.hub.jimmymiels.routefinder.Title

import android.util.Log
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {

    init {
        Log.i("TitleViewModel","TitleViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TitleViewModel","TitleViewModel destroyed!")
    }
}