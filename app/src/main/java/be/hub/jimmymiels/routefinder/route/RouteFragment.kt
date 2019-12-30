package be.hub.jimmymiels.routefinder.route


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import be.hub.jimmymiels.routefinder.databinding.FragmentRouteBinding
import be.hub.jimmymiels.routefinder.R

/**
 * A simple [Fragment] subclass.
 */
class RouteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentRouteBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_route,
            container,
            false)

        binding.newsearchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_routeFragment_to_titleFragment))
        binding.mapButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_routeFragment_to_mapFragment))

        setHasOptionsMenu(true)


        return binding.root

        //return inflater.inflate(R.layout.fragment_route, container, false)


    }
// Inflate the Menu xml
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

   // private fun getShareIntent() : Intent {
   //     val shareIntent = Intent(Intent.ACTION_SEND)
   //     shareIntent.setType("text/plain")

   // }


}
