package com.example.submission1githubuser

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1githubuser.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterUser: AdapterUser
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataAvatar: TypedArray

    private var dataUser = arrayListOf<DataUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterUser = AdapterUser(dataUser)
        binding.rvUser.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterUser
        }

        prepare()
        addItem()
    }

    private fun prepare() {
        resources.apply {
            dataName = getStringArray(R.array.name)
            dataLocation = getStringArray(R.array.location)
            dataAvatar = obtainTypedArray(R.array.avatar)
            dataRepository = getStringArray(R.array.repository)
            dataUsername = getStringArray(R.array.username)
            dataCompany = getStringArray(R.array.company)
            dataFollowers = getStringArray(R.array.followers)
            dataFollowing = getStringArray(R.array.following)
        }
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = DataUser(
                dataUsername[position],
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