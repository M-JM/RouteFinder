package be.hub.jimmymiels.routefinder.map


import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import be.hub.jimmymiels.routefinder.R
import be.hub.jimmymiels.routefinder.databinding.FragmentMapBinding
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
        Toast.makeText(context, viewModel.searchTerm.toString(), Toast.LENGTH_LONG).show()

        viewModel.searchTerm.observe(this, object : Observer<Any> {
            override fun onChanged(t: Any?) {
                textView4.text = t!!.toString()
                textView3.text = R.drawable.antwerpen.toString()
                resultImage.setImageResource(viewModel.default)


            }
        })



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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.share -> startActivity(viewModel.getShareIntent())
        }
        return super.onOptionsItemSelected(item)
    }

}
