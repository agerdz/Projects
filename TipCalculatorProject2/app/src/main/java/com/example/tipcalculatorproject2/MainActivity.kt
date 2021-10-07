package com.example.tipcalculatorproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tipcalculatorproject2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                if (binding.billAmount.text.isNotEmpty())
                {
                    val dollarValue = binding.billAmount.text.toString().toDouble()
                    val tenPercentTip = "%.2f".format(dollarValue * 1.1)
                    val fifteenPercentTip = "%.2f".format(dollarValue * 1.15)
                    val twentyPercentTip = "%.2f".format(dollarValue * 1.2)
                    val outputMessage = "The tips are as follows: \n \n10% = $tenPercentTip \n15% = $fifteenPercentTip \n20% = $twentyPercentTip"

                    binding.output.text = outputMessage
                }
                else
                {
                    binding.output.text = getString(R.string.error_message)
                }
            }
        })

    /*fun convertTip(view: View)
    {
        if (binding.billAmount.text.isNotEmpty())
        {
            val dollarValue = binding.billAmount.text.toString().toDouble()
            val tenPercentTip = "%.2f".format(dollarValue * 1.1)
            val fifteenPercentTip = "%.2f".format(dollarValue * 1.15)
            val twentyPercentTip = "%.2f".format(dollarValue * 1.2)
            val outputMessage = "The tips are as follows: \n \n10% = $tenPercentTip \n15% = $fifteenPercentTip \n20% = $twentyPercentTip"

            binding.output.text = outputMessage
        }
        else
        {
            binding.output.text = getString(R.string.error_message)
        }
    }*/
}}