package com.example.designpatternsapp.adaptermodel.circlr

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.designpatternsapp.databinding.ItemCircleMenuBinding

class CircleMenuAdapter(
    private val circleMenuItems: List<CircleMenuItem>
): BaseAdapter() {

    override fun getCount(): Int = circleMenuItems.size

    override fun getItem(position: Int): Any  = circleMenuItems[position]

    override fun getItemId(position: Int): Long = circleMenuItems[position].hashCode().toLong()

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = ItemCircleMenuBinding.inflate(
            LayoutInflater.from(parent?.context),
            parent,
            false
        )
        binding.itemCircleMenuText.setText(circleMenuItems[position].title)
        binding.itemCircleMenuImage.setImageResource(circleMenuItems[position].imageId)
        return binding.root
    }
}