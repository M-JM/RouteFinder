package be.hub.jimmymiels.routefinder.Title


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentTitleBinding

/**
 * Fragment for the starting or title screen of the app
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_title,container,false)
        binding.searchButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_routeFragment))


        return binding.root
    }

        //return inflater.inflate(R.layout.fragment_title, container, false)
    }



