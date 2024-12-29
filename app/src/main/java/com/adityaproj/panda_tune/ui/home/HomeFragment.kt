package com.adityaproj.panda_tune.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.adityaproj.panda_tune.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Nullable binding, avoids the need for !! operator
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize ViewModel
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        // Bind the TextView and observe changes from the ViewModel
        val textView: TextView = binding!!.eminemName
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Nullify the binding to avoid memory leaks
        _binding = null
    }
}
