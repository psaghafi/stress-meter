package com.example.a4stressmeter

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.navigation.navOptions
import com.example.a4stressmeter.ui.home.GridRVAdapter
import com.example.a4stressmeter.ui.home.GridViewModal
import com.example.a4stressmeter.ui.home.HomeFragment
import java.io.*
import java.sql.Timestamp

class HomeActivity : AppCompatActivity()  {
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var saveBtn: Button
    private lateinit var GridRVAdapter: GridRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //val textView: TextView=findViewById(R.id.textView)
        val imageView: ImageView = findViewById(R.id.viewImage)
        var bundle: Bundle? =intent.extras
        val imagenumber=intent.getIntExtra("image_number", -1)
        val position =intent.getIntExtra("position",-1)
//        val courseGRV = GridRVAdapter.getItem(position)
  //      val imagepage= GridRVAdapter.getItem(imagenumber)

        //val callinghomefragment= GridRVAdapter().gridChange(imagenumber)
        //callinghomefragment.gridChange(imagenumber)
        //imageView.setImageResource(bundle!!.getInt("image"))
        //extView.text=bundle!!.getString("name")
        imageView.setImageResource(bundle!!.getInt("image"))

        val saveButton: Button=findViewById(R.id.save_button)
        val cancelButton: Button=findViewById(R.id.cancel_button)


        cancelButton.setOnClickListener(){
           finish()

        }

        saveButton.setOnClickListener(){
            var stressScore:Int?=null
            val file = File(getExternalFilesDir(null),"stress_timestamp.csv")
            val position_=intent.getIntExtra("position",-1)
            val timestamp=Timestamp(System.currentTimeMillis()).time
            val createNewFile = file.createNewFile()
            when(position_){
                0 -> stressScore = 6
                1 -> stressScore = 8
                2 -> stressScore = 14
                3 -> stressScore = 16
                4 -> stressScore = 5
                5 -> stressScore = 7
                6 -> stressScore = 13
                7 -> stressScore = 15
                8 -> stressScore = 2
                9 -> stressScore = 4
                10 -> stressScore = 10
                11 -> stressScore = 12
                12 -> stressScore = 1
                13 -> stressScore = 3
                14 -> stressScore = 9
                15 -> stressScore = 11
            }
            val file_content="$timestamp,$stressScore\n"
            file.appendText(file_content)
            finishAffinity()
        }



    }



}