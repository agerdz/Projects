package com.example.recycleviewproject

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.Data.Companion.detailstwo
import com.example.recycleviewproject.Data.Companion.imagestwo
import com.example.recycleviewproject.Data.Companion.setDetailsArray
import com.example.recycleviewproject.Data.Companion.setImagesArray
import com.example.recycleviewproject.Data.Companion.setTitlesArray
import com.example.recycleviewproject.Data.Companion.titlestwo

import com.example.recycleviewproject.R
import java.util.Collections.shuffle

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
        }
    }

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    //private val titlesTwo = shuffle(titles.toMutableList())

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    //private val detailsTwo = details.shuffle()

    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)

    private val imagesTwo = images.shuffle()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        //titlestwo.shuffle()
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // titlestwo.shuffle()
        // details.shuffle()
        // images.shuffle()
        //setTitlesArray()
        //setDetailsArray()
        //()
        viewHolder.itemTitle.text = titlestwo[i]
        viewHolder.itemDetail.text = detailstwo[i]
        viewHolder.itemImage.setImageResource(imagestwo[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}