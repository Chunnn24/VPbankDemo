package com.example.vpbankapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.example.vpbankapp.databinding.ActivityMainBinding

/*
TODO: Đổ dữ liệu thật lên view
-Bước 1: Lấy dữ liệu json từ server
-bước 2: Đổ dữ liệu json vào entity(parser json to entity android kotlin)
-bước 3: Vẽ dữ liệu entity lên giao diện()
 */
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var imgList = mutableListOf<Int>()
    private var txtList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
            val i = Intent(this, ActivityAfter::class.java)
            startActivity(i)
        }
    }


}