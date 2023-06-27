package com.kotlin.book

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.book.ActivityPages.OtherActivity
import com.kotlin.book.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // 必须放到这里,不要放到onCreate中,会报错
    private val launchOne =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                binding.btClick.text = it.data?.getStringExtra("data_back")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btClick.setOnClickListener {
//            Toast.makeText(this, "你好吗", Toast.LENGTH_LONG).show()
//            binding.btClick.text = "ok"
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("my_data", "data")
//            startActivity(intent)
            launchOne.launch(intent) // 代替 startActivityForResult
        }

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            1 -> {
//                if (resultCode == RESULT_OK) {
//                    binding.btClick.text = data?.getStringExtra("data_back")
//                }
//            }
//        }
//    }


}