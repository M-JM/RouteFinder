package be.hub.jimmymiels.routefinder.title

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hub.jimmymiels.routefinder.R


class TitleViewModel : ViewModel() {


    var searchTerm = MutableLiveData<String>()
    var routes: Map<String, String> =
        mapOf("Brussels" to "Brussels to Schaarbeek", "Antwerpen" to "Antwerpen to Borgenhout")
    private val _route = MutableLiveData<String>()
    val route: LiveData<String>
        get() = _route
    var default = 0
    val sendIntent: Intent = Intent(_route.value.toString()).apply {
        action = Intent.ACTION_SEND
        type = "text/plain"
    }

    fun setSearchTerm(msg: String) {
        searchTerm.setValue(msg)
        _route.value = routes.getValue(searchTerm.value.toString())

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








