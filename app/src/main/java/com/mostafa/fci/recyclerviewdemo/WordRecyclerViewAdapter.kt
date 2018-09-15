package com.mostafa.fci.recyclerviewdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*

class WordRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<WordRecyclerViewAdapter.WordHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        return WordHolder(view)
    }

    override fun getItemCount(): Int {
        return Supplier.words.size
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val word = Supplier.words[position]
        holder.arabicText = word.arabicText
        holder.englishText = word.englishText
    }


    inner class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var arabicText:String = "no text"
            set(value) { itemView.arabicText.text = value}
        var englishText:String = "no text"
            set(value) { itemView.englishText.text = value}

        init {
            itemView.setOnClickListener{
                Toast.makeText(context,"you click ${itemView.englishText.text}",Toast.LENGTH_SHORT).show()
            }

        }
    }

}