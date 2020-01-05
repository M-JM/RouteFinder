package be.hub.jimmymiels.routefinder.title

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hub.jimmymiels.routefinder.R
import java.util.*


class TitleViewModel : ViewModel() {

    // val = immutable , only initialized once
    // var = mutable variable


    var searchTerm = MutableLiveData<String>()
    val routelist = mutableListOf(
        "Take a left and turn \nTurn right and go straight",
        "Take a right and go straight \nTake a left and go 500m ahead",
        "Take the first right on the turnabout \nGo straight for 400m")
    var routes: Map<String, String> =
        mapOf("Brussels" to "Brussels to Schaarbeek", "Antwerpen" to "Antwerpen to Borgenhout")
    private val _route = MutableLiveData<String>()
    val route: LiveData<String>
        get() = _route
    var default = 0

    var cards = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
        )

    var generateRandom = 0


    fun setSearchTerm(msg: String) {
        searchTerm.setValue(msg)
        if(routes.containsKey(searchTerm.value.toString())) {
            _route.value = routes.getValue(searchTerm.value.toString())

                }
        else {
            _route.value = routelist.random()

        }
        }

    fun setImage() {
        generateRandom = Random().nextInt(4)
        // drawables are stored as Int

        default = when (searchTerm.value.toString()) {
            "Antwerpen" -> R.drawable.antwerpen
            "Brussels" -> R.drawable.brussels
            else -> cards[generateRandom]
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








