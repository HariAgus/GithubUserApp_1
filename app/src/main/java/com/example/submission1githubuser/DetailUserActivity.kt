package com.example.submission1githubuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val user = intent.getParcelableExtra(DATA) as DataUser

        tv_name_detail.text = user.name
        tv_username.text = user.username
        tv_followers.text = user.followers
        tv_following.text = user.following
        tv_repository.text = user.repository
        tv_company.text = user.company
        tv_location_detail.text = user.locatioan
        circle_img_detail.setImageResource(user.avatar)

    }
}