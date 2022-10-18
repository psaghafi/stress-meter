package com.example.a4stressmeter.ui.home

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a4stressmeter.HomeActivity
import com.example.a4stressmeter.R
import com.example.a4stressmeter.databinding.FragmentHomeBinding
import java.io.Serializable

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var stopThread= false
    lateinit var courseGRV: GridView
//    lateinit var courseList: List<GridViewModal>
    lateinit var moreImageBtn: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val mediaPlayer=MediaPlayer.create(context,R.raw.sound)
        val vibrator= activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        object : Thread(){
            override fun run() {
                super.run()
                sleep(600)
                while (true){
                    if(stopThread){
                        mediaPlayer.stop()
                        break
                    }
                    vibrator.vibrate(600)
                    mediaPlayer.start()
                    sleep(700)
                }
            }
        }.start()

        //val homeViewModel =
          //  ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        courseGRV=binding.idGRV
        val more_image_Btn = binding.moreImageBtn
        //val Grid_RV_Adapter=GridRVAdapter(context = )


        //courseGRV = root.findViewById(R.id.idGRV)
      /*  courseList = ArrayList<GridViewModal>()
// on below line we are adding data to
        // our course list with image and course name.
        courseList = courseList + GridViewModal("C++", R.drawable.psm_alarm_clock)
        courseList = courseList + GridViewModal("Java", R.drawable.psm_anxious)
        courseList = courseList + GridViewModal("Android", R.drawable.psm_baby_sleeping)
        courseList = courseList + GridViewModal("Python", R.drawable.psm_blue_drop)
        courseList = courseList + GridViewModal("Javascript", R.drawable.psm_bird3)
*/

       // courseList = ArrayList<GridViewModal>()

        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter = GridRVAdapter(requireContext())
        val random_image_page=(0..2).shuffled().first()
        courseAdapter.gridChange(random_image_page)
        val courses = courseAdapter.courses

// on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter
        var image_number= random_image_page

        more_image_Btn.setOnClickListener(){
            stopThread=true
            image_number=(image_number+1).mod(3)
            courseAdapter.gridChange(image_number)
            val courses = courseAdapter.courses
            courseGRV.adapter = courseAdapter

        }

        // on below line we are adding on item
        // click listener for our grid view.
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            stopThread=true
            var intent= Intent(context, HomeActivity::class.java)
            intent.putExtra("image_number", image_number)
            intent.putExtra("position", position)
            intent.putExtra("image",courses[position])
            //intent.putExtra("position", courses[position])
            //intent.putExtra("image", courseList[position].courseImg)
            //intent.putExtra("name", courseList[position].courseName)
            //requireContext().startActivity(intent)
            requireContext().startActivity(intent)


            // inside on click method we are simply displaying
            // a toast message with course name.
           /* Toast.makeText(
                requireContext(), courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()*/
        }

        /*val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*private val gridview1 = arrayOf(
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

    private val gridview2 = arrayOf(
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

    private val gridview3 = arrayOf(
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
    var courses: Array<Int> = gridview1
    fun gridChange(grid_view: Int){
        print("home fragment")
        when(grid_view){
            0-> courses=gridview1
            1->courses=gridview2
            2->courses=gridview3
        }
    }*/
}