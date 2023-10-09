package com.example.chattingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chattingapp.databinding.ActivityCreateUserBinding
import java.util.Random


class CreateUserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCreateUserBinding
    var userAvatar = "profileDefault"
    var avatarColor = "[0.5,0.5,0.5,1]"
//    override fun onCreateView(inflater: Inflater,container:ViewGroup)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateUserBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_create_user)
        setContentView(binding.root)
    }
    fun generateUserAvatar(view: View){
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)
        if (color == 0)
        {
            userAvatar = "light$avatar"
        }
        else
        {
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        binding.createAvatarImageView.setImageResource(resourceId)
    }
    fun generateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        binding.createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
    }
    fun createUserClicked(view: View){

    }

}