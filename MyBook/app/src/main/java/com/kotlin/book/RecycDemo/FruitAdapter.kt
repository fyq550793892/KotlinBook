package com.kotlin.book.RecycDemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.book.Bean.Fruit
import com.kotlin.book.R
import kotlinx.android.synthetic.main.fruit_item.view.*
import org.w3c.dom.Text

//class FruitAdapter(val fruitList:List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>(){
//
//    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
//        val fruitName:TextView = view.findViewById(R.id.fruitName)
//        val fruitType:TextView = view.findViewById(R.id.fruitType)
//    }
//
//    override fun getItemCount(): Int {
//        return fruitList.size
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item,parent,false)
//        return  ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        var fruit = fruitList[position]
//        holder.fruitName.text = fruit.name
//        holder.fruitType.text  =fruit.type
//    }
//}


class FruitAdapter(val fruitList: List<Fruit>) :RecyclerView.Adapter<FruitAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        var fruitName:TextView = itemView.findViewById(R.id.fruitName)
        var fruitType:TextView = itemView.findViewById(R.id.fruitType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fruit_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var fruit = fruitList[position]
        holder.fruitName.text  = fruit.name
        holder.fruitType.text = fruit.type
    }

    override fun getItemCount(): Int {
        return  fruitList.size
    }

}