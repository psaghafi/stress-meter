package com.example.a4stressmeter.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.a4stressmeter.R
import android.util.Log


// on below line we are creating an
// adapter class for our grid view.
internal class GridRVAdapter(
    // on below line we are creating two
    // variables for course list and context
   // private val courseList: ArrayList<GridViewModal>,
    private val context: Context
) :
    BaseAdapter() {
     var gridview1 = arrayOf(
        R.drawable.psm_mountains11,
        R.drawable.psm_wine3,
        R.drawable.psm_barbed_wire2,
        R.drawable.psm_clutter,
        R.drawable.psm_blue_drop,
        R.drawable.psm_to_do_list,
        R.drawable.psm_stressed_person7,
        R.drawable.psm_stressed_person6,
        R.drawable.psm_yoga4,
        R.drawable.psm_bird3,
        R.drawable.psm_stressed_person8,
        R.drawable.psm_exam4,
        R.drawable.psm_kettle,
        R.drawable.psm_lawn_chairs3,
        R.drawable.psm_to_do_list3,
        R.drawable.psm_work4)

     var gridview2 = arrayOf(
        R.drawable.psm_talking_on_phone2,
        R.drawable.psm_stressed_person,
        R.drawable.psm_stressed_person12,
        R.drawable.psm_lonely,
        R.drawable.psm_gambling4,
        R.drawable.psm_clutter3,
        R.drawable.psm_reading_in_bed2,
        R.drawable.psm_stressed_person4,
        R.drawable.psm_lake3,
        R.drawable.psm_cat,
        R.drawable.psm_puppy3,
        R.drawable.psm_neutral_person2,
        R.drawable.psm_beach3,
        R.drawable.psm_peaceful_person,
        R.drawable.psm_alarm_clock2,
        R.drawable.psm_sticky_notes2)

     var gridview3 = arrayOf(
        R.drawable.psm_anxious,
        R.drawable.psm_hiking3,
        R.drawable.psm_stressed_person3,
        R.drawable.psm_lonely2,
        R.drawable.psm_dog_sleeping,
        R.drawable.psm_running4,
        R.drawable.psm_alarm_clock,
        R.drawable.psm_headache,
        R.drawable.psm_baby_sleeping,
        R.drawable.psm_puppy,
        R.drawable.psm_stressed_cat,
        R.drawable.psm_angry_face,
        R.drawable.psm_bar,
        R.drawable.psm_running3,
        R.drawable.psm_neutral_child,
        R.drawable.psm_headache2)
     //lateinit var courses: Array<Int>
    fun gridChange(grid_view: Int){
        print("GRID VIEW ADAPTER")
        when(grid_view){
            0->courses=gridview1
            1->courses=gridview2
            2->courses=gridview3
        }
    }
    lateinit var courses: Array<Int>

    // in base adapter class we are creating variables
    // for layout inflater, course image view and course text view.
    private var layoutInflater: LayoutInflater? = null
    //private lateinit var courseTV: TextView
    private lateinit var courseIV: ImageView

    // below method is use to return the count of course list
    override fun getCount(): Int {
        return courses.size
    }

    // below function is use to return the item of grid view.
    override fun getItem(position: Int): Any? {
            return courses[position]
    }

    // below function is use to return item id of grid view.
    override fun getItemId(position: Int): Long {
        return courses[position].toLong()
    }

    // in below function we are getting individual item of grid view.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val imageView=ImageView(context)
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        // on the below line we are checking if convert view is null.
        // If it is null we are initializing it.
        if (convertView == null) {
            // on below line we are passing the layout file
            // which we have to inflate for each item of grid view.
            convertView = layoutInflater!!.inflate(R.layout.gridview_items_home, null)
        }
        // on below line we are initializing our course image view
        // and course text view with their ids.
        courseIV = convertView!!.findViewById(R.id.idIVCourse)
        //courseTV = convertView!!.findViewById(R.id.idTVCourse)
        // on below line we are setting image for our course image view.
        courseIV.setImageResource(courses[position])
        // on below line we are setting text in our course text view.
        //courseTV.setText(courseList.get(position).courseName)
        // at last we are returning our convert view.
        return convertView
    }
}
