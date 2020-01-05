package be.hub.jimmymiels.routefinder.map


import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController

import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentMapBinding
import be.hub.jimmymiels.routefinder.route.RouteFragmentDirections
import be.hub.jimmymiels.routefinder.title.TitleViewModel
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel
    lateinit var resultImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding: FragmentMapBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_map,
            container,
            false
        )

        viewModel = ViewModelProviders.of(activity!!).get(TitleViewModel::class.java)
        binding.titleViewModel = viewModel
        binding.lifecycleOwner = this
        resultImage = binding.imageView
        resultImage.setImageResource(viewModel.default)
        //Toast.makeText(context, viewModel.searchTerm.toString(), Toast.LENGTH_LONG).show()

       /* viewModel.searchTerm.observe(this, object : Observer<Any> {
            override fun onChanged(t: Any?) {
                resultImage.setImageResource(viewModel.default)
            }
        })
*/
        binding.newsearchButton.setOnClickListener{v: View ->
            viewModel!!.setSearchTerm("")
            v.findNavController()
                .navigate(MapFragmentDirections.actionMapFragmentToTitleFragment())
        }

        binding.showrouteButton.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(MapFragmentDirections.actionMapFragmentToRouteFragment())
        }

        setHasOptionsMenu(true)

        return binding.root

    }

    // Inflate the Menu xml
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> startActivity(viewModel.getShareIntent())
        }
        return super.onOptionsItemSelected(item)
    }

}
