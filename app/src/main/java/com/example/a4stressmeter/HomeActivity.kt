package com.example.a4stressmeter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.a4stressmeter.ui.home.GridViewModal

class HomeActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        /*xtView = findViewById(R.id.testing)
        val testing = intent.getStringExtra("courseList")
        textView.text = testing*/
       /* val imageView: ImageView = findViewById(R.id.viewImage)

        var modalItems: GridViewModal= intent.getSerializableExtra("resId") as GridViewModal
        textView.text=modalItems.courseName
        imageView.setImageResource(modalItems.courseImg!!)*/
/*
        val imageView: ImageView = findViewById(R.id.viewImage)
        val bundle: Bundle? = intent.extras
        if(bundle!=null){
            //val resId: Int = bundle.getInt("resId")
            imageView.setImageResource(bundle!!.getInt("resId"))

        }*/
      //  val resId: Int = bundle.getInt("resId")
      //  imageView.setImageResource(resId)
        val textView: TextView=findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.viewImage)
        var bundle: Bundle? =intent.extras
        imageView.setImageResource(bundle!!.getInt("image"))
        textView.text=bundle!!.getString("name")



    }
}