package com.example.ContactProject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ContactProject.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ContactProject.Contact
import androidx.fragment.app.viewModels
import java.util.*
import com.example.ContactProject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val quantity = binding.contactNumber.text.toString()
            if (name != "" && quantity != "") {
                val contact = Contact(name, Integer.parseInt(quantity))
                viewModel.insertProduct(contact)
                clearFields()
            } else {
                binding.productID.text = "Incomplete information"
            }
        }

        binding.findButton.setOnClickListener { viewModel.findProduct(
            binding.contactName.text.toString()) }

        //binding.sortASCButton.setOnClickListener {
        //    viewModel.sortASC()
        //    clearFields()
        //}
        binding.sortASCButton.setOnClickListener {
            var contacts = viewModel.getAllProducts()?.value
            adapter?.ascSort(contacts)
        }
        binding.sortDSCButton.setOnClickListener {
            var contacts = viewModel.getAllProducts()?.value
            adapter?.descSort(contacts)
        }
        //binding.sortDSCButton.setOnClickListener {
        //    viewModel.sortDES()
        //    clearFields()
        //}
        //binding.sortDSCButton.setOnClickListener {
            //viewModel.deleteProduct(binding.contactName.text.toString())
            //clearFields()
        //}


    }

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(this, Observer { products ->
            products?.let {
                adapter?.setProductList(it)
            }
        })
        viewModel.getSearchResults().observe(this, Observer { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.contactName.setText(it[0].contactName)
                    binding.contactNumber.setText(String.format(Locale.US, "%d",
                        it[0].phoneNumber))
                } else {
                    binding.productID.text = "No Match"
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String){
                var id: Int = parseInt(id)
                viewModel.deleteProduct(id)
            }
        })
    }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }

}