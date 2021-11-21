package com.example.recycleviewprojectintents

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewprojectintents.Data.Companion.detailstwo
import com.example.recycleviewprojectintents.Data.Companion.imagestwo
import com.example.recycleviewprojectintents.Data.Companion.titlestwo

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemView.setOnClickListener { v: View ->
                val i = Intent(v.getContext(),MainActivity2::class.java)
                val myString = itemTitle.text
                val myString2 = itemDetail.text
                val myImage = adapterPosition
                i.putExtra("qString", myString )
                i.putExtra("qString2", myString2 )
                i.putExtra("qImage", myImage )
                startActivity(v.context,i,null)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        //titlestwo.shuffle()
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {


        viewHolder.itemTitle.text = titlestwo[i]
        viewHolder.itemDetail.text = detailstwo[i]
        viewHolder.itemImage.setImageResource(imagestwo[i])
    }

    override fun getItemCount(): Int {
        return Data.imagestwo.size
    }
}