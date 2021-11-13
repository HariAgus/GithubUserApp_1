package com.example.submission1githubuser

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapterUser: AdapterUser
    private var dataUser = arrayListOf<DataUser>()
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository : Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing : Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataAvatar: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterUser = AdapterUser(this, dataUser)
        rv_user.layoutManager = LinearLayoutManager(this)
        rv_user.adapter = adapterUser

        prepare()
        addItem()
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataRepository = resources.getStringArray(R.array.repository)
        dataUsername = resources.getStringArray(R.array.username)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = DataUser(dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataAvatar.getResourceId(position, -1)
            )
            dataUser.add(user)
        }
        adapterUser.dataUser = dataUser
    }

}