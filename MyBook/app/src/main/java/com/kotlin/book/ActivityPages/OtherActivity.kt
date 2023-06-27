package com.kotlin.book.ActivityPages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.book.databinding.ActivityOtherBinding


class OtherActivity : AppCompatActivity() {
    private val TAG = "OtherActivity"
    private lateinit var binding: ActivityOtherBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraData = intent.getStringExtra("my_data")
//        println("收到数据 $extraData")
        Log.d(TAG, "onCreate: 收到数据 $extraData ")
        binding.textViewShow.text = extraData

        binding.textViewShow.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_back", "吃了吗")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}