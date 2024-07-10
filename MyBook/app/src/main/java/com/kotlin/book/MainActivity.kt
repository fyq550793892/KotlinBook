package com.kotlin.book

import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.book.RecycDemo.RecycActivity
import com.kotlin.book.Service.Notification.NotificationActivity
import com.kotlin.book.UI.FragmentWidget.FragmentTestActivity
import com.kotlin.book.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    // binding见郭琳文章 https://mp.weixin.qq.com/s/keR7bO-Nu9bBr5Nhevbe1Q
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

        supportActionBar?.hide()

        binding.btClick.setOnClickListener {
            // 弹toast
//            Toast.makeText(this, "你好吗", Toast.LENGTH_LONG).show()
//            binding.btClick.text = "ok"


//            val intent = Intent(this, OtherActivity::class.java)
//            intent.putExtra("my_data", "data")
////            startActivity(intent)
//            launchOne.launch(intent) // 代替 startActivityForResult

            // 设置progressBar
//            binding.pbShow.progress = binding.pbShow.progress + 10

            // 弹出dialog
            AlertDialog.Builder(this).apply {
                setTitle("标题")
                setMessage("提示")
                setCancelable(false)
                setNegativeButton("cancle") { dialog, which ->
                    binding.ivShow.visibility = View.GONE
                    Log.d(TAG, "onCreate: 123")
                }
                show()
            }
        }

        binding.ivShow.setOnClickListener {
            binding.ivShow.setImageResource(R.drawable.ic_launcher_foreground)
        }

        binding.btToRecy.setOnClickListener{
            var intent  = Intent(this,RecycActivity::class.java)
            startActivity(intent)
        }

        binding.btToFragment.setOnClickListener{
            startActivity(Intent(this,FragmentTestActivity::class.java))
        }

        binding.btToNotification.setOnClickListener {
            startActivity(Intent(this,NotificationActivity::class.java))
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