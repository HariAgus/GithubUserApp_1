package com.example.submission1githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.submission1githubuser.databinding.ItemListUserBinding

class AdapterUser(
    var dataUser: List<DataUser>
) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view = ItemListUserBinding.inflate(
            LayoutInflater.from(
                parent.context
            ), parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder, position: Int
    ) {
        holder.bindItem(dataUser[position])
    }

    override fun getItemCount(): Int = dataUser.size

    class ViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItem(dataUser: DataUser) {
            binding.apply {
                tvName.text = dataUser.name
                tvLocation.text = dataUser.locatioan
                circleImg.setImageResource(dataUser.avatar)

                circleImg.setOnClickListener {
                    val intent = Intent(
                        itemView.context, DetailUserActivity::class.java
                    )
                    intent.putExtra(
                        DetailUserActivity.DATA, dataUser
                    )
                    itemView.context.startActivity(intent)
                }
            }
        }

    }


}