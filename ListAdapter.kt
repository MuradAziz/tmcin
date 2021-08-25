package com.example.tmcin.adapter





import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmcin.R
import com.example.tmcin.model.Products
import com.example.tmcin.uitel.loadImage
import com.example.tmcin.view.Details


class ListAdapter (var mContext:Context, var producList:List<Products>):
    RecyclerView.Adapter<ListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(var v: View):RecyclerView.ViewHolder(v){

        var imgT=v.findViewById<ImageView>(R.id.productimage)
        var nameT=v.findViewById<TextView>(R.id.nameTextview)
        var descriT=v.findViewById<TextView>(R.id.descriptionTextview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var infalter=LayoutInflater.from(parent.context)
        var v=infalter.inflate(R.layout.row_item, parent, false)
        return ListViewHolder(v)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList=producList[position]
        holder.nameT.text=newList.name
        holder.descriT.text=newList.description
        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener{

            val name=newList.name
            val descrip=newList.description
            val imgurl=newList.imageUrl


            val mIntent=Intent(mContext, Details::class.java)
            mIntent.putExtra("NAMET", name)
            mIntent.putExtra("DESCRIT", descrip)
            mIntent.putExtra("IMGURI", imgurl)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int=producList.size
}