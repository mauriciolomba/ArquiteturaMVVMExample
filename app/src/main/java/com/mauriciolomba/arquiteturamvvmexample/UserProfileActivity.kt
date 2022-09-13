package com.mauriciolomba.arquiteturamvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mauriciolomba.arquiteturamvvmexample.databinding.ActivityUserProfileBinding

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        viewModel.profileInfo.observe(this, ::updateUi)
        viewModel.loadProfile()
    }

    private fun updateUi(userInfo: UserInfo) = binding.run {
        imageviewHeader.setImageResource(userInfo.headerImage)
        imageviewProfile.setImageResource(userInfo.profileImage)
        textviewUsername.setText(userInfo.name)
        textviewDescription.setText(userInfo.description)
        textviewBio.setText(userInfo.bio)
    }
}