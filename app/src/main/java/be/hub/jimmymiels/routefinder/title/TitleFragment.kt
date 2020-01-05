package be.hub.jimmymiels.routefinder.title


import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_title.*


class TitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel

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
            false
        )

        // get viewModel
        // to call methods in viewmodel add viewModel. to methods

        viewModel = ViewModelProviders.of(activity!!).get(TitleViewModel::class.java)

        binding.titleViewModel = viewModel
        binding.lifecycleOwner = this


        // Navigation to fragment

        binding.searchButton.setOnClickListener { v: View ->
            if (editText.text.isNotEmpty()) {
            viewModel!!.setSearchTerm(editText.text.toString())
            viewModel!!.setImage()
            v.findNavController()
                .navigate(TitleFragmentDirections.actionTitleFragmentToRouteFragment())
        }
            else
            { editText?.setError(" Please set destination")
            }
        }
        return binding.root
    }


}



