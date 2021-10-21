package com.example.savedata2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.savedata2.databinding.MainFragmentBinding
import androidx.databinding.DataBindingUtil

import com.example.savedata2.R
import com.example.savedata2.BR.myViewModel

class MainFragment : Fragment()
{

    //private var _binding: MainFragmentBinding? = null
    //private val binding get() = _binding!!

    companion object
    {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View
    {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        //_binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.setVariable(myViewModel, viewModel)

       // binding.message.text = viewModel.stringList.toString()

        //binding.button.setOnClickListener{
           // if(binding.editTextName.text.isNotEmpty())
            //{
                //viewModel.stringList = viewModel.stringList.plus(binding.editTextName.text.toString()).plus("\n")
                //binding.message.text = viewModel.stringList

            //}

    }

}
    //override fun onDestroyView()
    //{
       // super.onDestroyView()
       // _binding = null
    //}
