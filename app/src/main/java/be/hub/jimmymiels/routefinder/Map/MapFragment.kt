package be.hub.jimmymiels.routefinder.Map


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return binding.root

        //return inflater.inflate(R.layout.fragment_map, container, false)
    }


}
