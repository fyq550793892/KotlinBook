package com.kotlin.book.UI.FragmentWidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kotlin.book.R

private const val TAG = "FragmentTestActivity"
class FragmentTestActivity : AppCompatActivity() {
    private lateinit var  fragmentManager:FragmentManager
    private lateinit var leftFragment:Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        fragmentManager = supportFragmentManager
        leftFragment = fragmentManager.findFragmentById(R.id.leftFragment)!!

        val button:Button = leftFragment.requireView().findViewById(R.id.replaceBt)
        button.setOnClickListener{
            Log.d(TAG, "onCreate: 点击了按钮")
            replaceFragment(LeftFragment())
        }
        replaceFragment(RightFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}