package be.hub.jimmymiels.routefinder.Map


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation

import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentMapBinding

/**
 * A simple [Fragment] subclass.
 */
class MapFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentMapBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_map,
            container,
            false)

        binding.newsearchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mapFragment_to_titleFragment))
        binding.showrouteButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mapFragment_to_routeFragment))

        setHasOptionsMenu(true)

        return binding.root

        //return inflater.inflate(R.layout.fragment_map, container, false)
    }
    // Inflate the Menu xml
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

}
