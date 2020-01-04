package be.hub.jimmymiels.routefinder.title

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hub.jimmymiels.routefinder.R


class TitleViewModel : ViewModel() {

    var searchTerm = MutableLiveData<String>()
    val list = mutableListOf(
        "Take a left and turn \nTurn right and go straight",
        "Take a right and go straight \nTake a left and go 500m ahead",
        "Take the first right on the turnabout \nGo straight for 400m")
    var routes: Map<String, String> =
        mapOf("Brussels" to "Brussels to Schaarbeek", "Antwerpen" to "Antwerpen to Borgenhout")
    private val _route = MutableLiveData<String>()
    val route: LiveData<String>
        get() = _route
    var default = 0

    fun setSearchTerm(msg: String) {
        searchTerm.setValue(msg)
        if(routes.containsKey(searchTerm.value.toString())) {
            _route.value = routes.getValue(searchTerm.value.toString())

                }
        else {
            _route.value = list.random()
        }
        }

    fun setImage() {
        default = when (searchTerm.value.toString()) {
            "Antwerpen" -> R.drawable.antwerpen
            "Brussels" -> R.drawable.brussels
            else -> R.drawable.share
        }
    }

    fun getShareIntent(): Intent {
        val args = _route.value.toString()
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, args)
        return shareIntent
    }
}








