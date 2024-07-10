package com.kotlin.book

import android.app.Activity
import android.content.AttributionSource
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.kotlin.book.databinding.ActivityMainBinding
import com.kotlin.book.databinding.TitleLayoutBinding

class TitleLayout(context:Context,attrs:AttributeSet):LinearLayout(context,attrs) {

    private lateinit var binding: TitleLayoutBinding

    init{
      var root =  LayoutInflater.from(context).inflate(R.layout.title_layout,this)
        binding = TitleLayoutBinding.bind(root)
        binding.titleBack.setOnClickListener {
//            val activity = context as Activity
//            activity.finish()
            Toast.makeText(context,"返回",Toast.LENGTH_LONG).show()
        }
    }
}