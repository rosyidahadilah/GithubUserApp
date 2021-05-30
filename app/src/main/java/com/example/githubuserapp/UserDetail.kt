package com.example.githubuserapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_detail.*

class UserDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)

        val listUser : UserData = intent.getParcelableExtra(EXTRA_DATA)!!

        detail_avatar.setImageResource(listUser.avatar!!)
        detail_username.text = getString(R.string.username)
        detail_name.text = getString(R.string.name)
        detail_location.text = getString(R.string.location, listUser.location)
        detail_repository.text = getString(R.string.repository, listUser.repository)
        detail_company.text = getString(R.string.company, listUser.company)
        detail_followers.text = getString(R.string.followers, listUser.followers)
        detail_following.text = getString(R.string.following, listUser.following)

    }
}