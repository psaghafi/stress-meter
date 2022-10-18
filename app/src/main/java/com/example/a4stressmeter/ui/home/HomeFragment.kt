package com.example.a4stressmeter.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
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
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GridViewModal>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        courseGRV = root.findViewById(R.id.idGRV)
        courseList = ArrayList<GridViewModal>()
// on below line we are adding data to
        // our course list with image and course name.
        courseList = courseList + GridViewModal("C++", R.drawable.psm_alarm_clock)
        courseList = courseList + GridViewModal("Java", R.drawable.psm_anxious)
        courseList = courseList + GridViewModal("Android", R.drawable.psm_baby_sleeping)
        courseList = courseList + GridViewModal("Python", R.drawable.psm_blue_drop)
        courseList = courseList + GridViewModal("Javascript", R.drawable.psm_bird3)

        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter = GridRVAdapter(courseList = courseList, requireContext())
// on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter

        // on below line we are adding on item
        // click listener for our grid view.
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            var intent= Intent(context, HomeActivity::class.java)
            //intent.putExtra("courseList", courseList[position])
            //intent.putExtra("courseList", courseList[position])
            //Integer.parseInt(courseList[position].courseName)
            //intent.p
           intent.putExtra("image", courseList[position].courseImg)
            intent.putExtra("name", courseList[position].courseName)
           //requireContext().startActivity(intent)
         //   intent.putExtra("resId", courseList[position].courseName as Serializable)
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
}