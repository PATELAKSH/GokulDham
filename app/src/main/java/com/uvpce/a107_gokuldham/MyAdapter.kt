package com.uvpce.a107_gokuldham

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class MyAdapter(private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ic_contacts, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = userList[position]
        holder.Name.text = currentitem.name
        holder.Number.text = currentitem.number
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var Name:TextView =itemView.findViewById(R.id.cname)
        var Number:TextView = itemView.findViewById(R.id.cnumber)

    }
}


//class MyAdapter(private var context: Activity, private var userList:List<User>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
//    class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
//        var name:TextView
//        var num:TextView
//        init{
//            name = itemView.findViewById(R.id.cname)
//            num = itemView.findViewById(R.id.cnumber)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(context).inflate(R.layout.ic_contacts, null, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentitem = userList[position]
//        holder.name.text = currentitem.name
//        holder.num.text = currentitem.number
//    }
//
//    override fun getItemCount(): Int {
//        return userList.size
//    }
//}