package com.example.submission1githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.submission1githubuser.databinding.ActivityDetailUserBinding
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var user: DataUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.getParcelableExtra(DATA)!!

        binding.apply {
            tvNameDetail.text = user.name
            tvUsername.text = user.username
            tvFollowers.text = user.followers
            tvFollowing.text = user.following
            tvRepository.text = user.repository
            tvCompany.text = user.company
            tvLocationDetail.text = user.locatioan
            circleImgDetail.setImageResource(user.avatar)
        }

    }
}