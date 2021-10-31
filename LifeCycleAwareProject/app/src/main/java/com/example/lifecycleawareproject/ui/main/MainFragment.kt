package com.example.lifecycleawareproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.lifecycleawareproject.R
import com.example.lifecycleawareproject.databinding.MainFragmentBinding
import com.example.lifecycleawareproject.DemoObserver
import com.example.lifecycleawareproject.ui.main.MainViewModel.Companion.stringList

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        if (stringList.value.isNullOrEmpty()) {
            viewModel.setToEmptyList()
        }
        lifecycle.addObserver(DemoObserver())

        binding.output.text = stringList.value.toString()

        ///val resultObserver = Observer<String> { stringList ->
        val resultObserver = Observer<String> {
                stringList -> binding.output.text = stringList
        }
        viewModel.getStringList().observe(viewLifecycleOwner, resultObserver)
        //binding.output.text = stringList.toString()
       // }
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}