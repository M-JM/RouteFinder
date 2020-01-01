package be.hub.jimmymiels.routefinder.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*



class TitleViewModel : ViewModel() {

    data class Place(var city: String, var routegps: String )


    var searchTerm = MutableLiveData<String>()
    var routes : Map<String,String> = mapOf("Brussels" to "Brussels to Schaarbeek", "Antwerpen" to "Antwerpen to Borgenhout")
    private val _route = MutableLiveData<String>()
    val route: LiveData<String>
    get() = _route







  fun setSearchTerm(msg:String) {
    searchTerm.setValue(msg)
      _route.value = routes.getValue(searchTerm.value.toString())


}

}







/**fun setRoute() {
    route.value= routes.filterValues { searchTerm == routes.keys }.toString()
        }

    }
*/