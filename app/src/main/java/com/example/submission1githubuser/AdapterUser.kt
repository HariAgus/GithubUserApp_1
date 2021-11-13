package com.example.submission1githubuser

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class AdapterUser (private val context: Context, var dataUser: List<DataUser>) :
    RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_user, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.bindItem(dataUser[i])
    }

    override fun getItemCount(): Int = dataUser.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvLoc: TextView = view.findViewById(R.id.tv_location)
        private val circleImg: CircleImageView = view.findViewById(R.id.circle_img)

        fun bindItem(dataUser: DataUser) {
            tvName.text = dataUser.name
            tvLoc.text = dataUser.locatioan
            circleImg.setImageResource(dataUser.avatar)

            circleImg.setOnClickListener {
                val intent = Intent(itemView.context, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.DATA, dataUser)
                itemView.context.startActivity(intent)
            }
        }

    }


}