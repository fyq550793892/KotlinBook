package com.kotlin.book.RecycDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.kotlin.book.Bean.Fruit
import com.kotlin.book.R
import com.kotlin.book.databinding.ActivityRecycBinding

class RecycActivity : AppCompatActivity() {

    private val fruitListAll = ArrayList<Fruit>()
    private lateinit var binding: ActivityRecycBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList())
        binding.recyView.adapter = adapter


    }

    fun fruitList():List<Fruit> {
        repeat(10) {
            fruitListAll.add(Fruit("1","type1"))
        }
        return fruitListAll
    }
}