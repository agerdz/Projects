package com.example.recycleviewprojectintents


//import java.util.Collections.shuffle
import android.util.Log

class Data {

    companion object
    {
        private val LOG_TAG = "DemoObserver"

        var hasExecuted = false

        var titlestwo = arrayOf("Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight")

        var detailstwo = arrayOf("Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details")

        var imagestwo = intArrayOf(R.drawable.android_image_1,
            R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8)

        fun setTitlesArray() {
            Log.i(LOG_TAG, "at start")
            val titles = arrayOf("Chapter One",
                "Chapter Two", "Chapter Three", "Chapter Four",
                "Chapter Five", "Chapter Six", "Chapter Seven",
                "Chapter Eight")
            Log.i(LOG_TAG, "after array")
            val randomNumberArray = arrayOf("Chapter One",
                "Chapter Two", "Chapter Three", "Chapter Four",
                "Chapter Five", "Chapter Six", "Chapter Seven",
                "Chapter Eight")
            Log.i(LOG_TAG, "after new array")

            for (index in 0..7) {
                Log.i(LOG_TAG, "start of for")
                val rnds = (0..7).random()
                randomNumberArray[index] = titles[rnds]
                Log.i(LOG_TAG, "end of for loop")
            }
            titlestwo = randomNumberArray


        }
        fun setDetailsArray() {
            val details = arrayOf("Item one details", "Item two details",
                "Item three details", "Item four details",
                "Item five details", "Item six details",
                "Item seven details", "Item eight details")
            val randomNumberArray = arrayOf("Item one details", "Item two details",
                "Item three details", "Item four details",
                "Item five details", "Item six details",
                "Item seven details", "Item eight details")

            for (index in 0..7) {
                val rnds = (0..7).random()
                randomNumberArray[index] = details[rnds]
            }
            detailstwo= randomNumberArray

        }
        fun setImagesArray() {
            var images = intArrayOf(R.drawable.android_image_1,
                R.drawable.android_image_2, R.drawable.android_image_3,
                R.drawable.android_image_4, R.drawable.android_image_5,
                R.drawable.android_image_6, R.drawable.android_image_7,
                R.drawable.android_image_8)
            val randomNumberArray = intArrayOf(R.drawable.android_image_1,
                R.drawable.android_image_2, R.drawable.android_image_3,
                R.drawable.android_image_4, R.drawable.android_image_5,
                R.drawable.android_image_6, R.drawable.android_image_7,
                R.drawable.android_image_8)

            for (index in 0..7) {
                val rnds = (0..7).random()
                randomNumberArray[index] = images[rnds]
            }
            imagestwo= randomNumberArray
            hasExecuted = true
        }

    }

}


