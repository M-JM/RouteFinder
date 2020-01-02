package be.hub.jimmymiels.routefinder.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hub.jimmymiels.routefinder.R
import kotlin.math.absoluteValue


class TitleViewModel : ViewModel() {


    var searchTerm = MutableLiveData<String>()
    var routes : Map<String,String> = mapOf("Brussels" to "Brussels to Schaarbeek", "Antwerpen" to "Antwerpen to Borgenhout")
    private val _route = MutableLiveData<String>()
    val route: LiveData<String>
    get() = _route
    var default = 0

  fun setSearchTerm(msg:String) {
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
}







/**fun setRoute() {
    route.value= routes.filterValues { searchTerm == routes.keys }.toString()
        }

    }
*/