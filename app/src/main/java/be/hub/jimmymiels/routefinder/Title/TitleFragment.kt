package be.hub.jimmymiels.routefinder.Title


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentTitleBinding

/**
 * Fragment for the starting or title screen of the app
 */
class TitleFragment : Fragment() {

private lateinit var viewModel : TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title,
            container,
            false)

        // get viewModel
        // to call methods in viewmodel add viewModel. to methods

        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)

        Log.i("TitleFragment","Called ViewModelProviders.of")

        // Navigation to fragment

        binding.searchButton.setOnClickListener{ v: View ->
            v.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRouteFragment())
        }
        return binding.root
    }

        //return inflater.inflate(R.layout.fragment_title, container, false)
    }



