package com.example.ContactProject.ui.main

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ContactProject.Contact
import com.example.ContactProject.R

class ContactListAdapter(private val contactItemLayout: Int) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    //----------------------------------------------------
    var listener: onItemClickListener?= null

    fun settingListener(listener: onItemClickListener){
        this.listener = listener
    }

    interface onItemClickListener{
        fun onClick(str: String)
    }
    //----------------------------------------------------
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        //val item = holder.item
        val name = holder.name
        val phone = holder.phone
        val id = holder.id
        var deleteButton = holder.deleteButton
        //val contactID = holder.id


        contactList.let {
            //item.text = it!![listPosition].contactName
            name.text = it!![listPosition].contactName
            phone.text = it!![listPosition].phoneNumber.toString()
            id.text = it!![listPosition].id.toString()
        }

        deleteButton.setOnClickListener(View.OnClickListener {
            var id = id.text.toString()
            listener?.onClick(id)
        })
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }
    fun setProductList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var item: TextView = itemView.findViewById(R.id.productID)
        var name: TextView = itemView.findViewById(R.id.nameTextView)
        var phone: TextView = itemView.findViewById(R.id.numberTextView)
        var id: TextView = itemView.findViewById(R.id.IDtextView)
        var deleteButton: ImageButton = itemView.findViewById(R.id.imageButton)
    }
    fun ascSort(contacts: List<Contact>?){
        contactList = contacts
        contactList = contactList?.sortedBy { it.contactName }
        notifyDataSetChanged()
    }
    fun descSort(contacts: List<Contact>?){
        contactList = contacts
        contactList = contactList?.sortedByDescending { it.contactName }
        notifyDataSetChanged()
    }


}


