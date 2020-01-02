package com.example.mylistviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HeroAdapter internal constructor(private val context: Context):BaseAdapter() {
    internal var heroes = ArrayList<People>()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View? {
        var itemView = p1
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_people, p2, false)
        }
        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(p0) as People
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        private val tvName : TextView = view.findViewById(R.id.tv_name)
        private val tvDescription : TextView = view.findViewById(R.id.tv_description)
        private val ivPhoto : ImageView = view.findViewById(R.id.iv_photo)

        internal fun bind(people: People){
            tvName.text = people.name
            tvDescription.text = people.description
            ivPhoto.setImageResource(people.photo)
        }
    }

    override fun getItem(p0: Int): Any {
        return heroes[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return heroes.size
    }
}