package com.example.charityapp.ui.emergency.allEmergency

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.charityapp.R
import com.example.charityapp.classes.Post
import com.example.charityapp.databinding.FragmentAllEmergencyBinding
import com.example.charityapp.ui.recyclerViews.PostClickHandler
import com.example.charityapp.ui.recyclerViews.PostRVAdapter

class AllEmergencyFragment : Fragment(), PostClickHandler {

    companion object {
        fun newInstance() = AllEmergencyFragment()
    }
    private var _binding: FragmentAllEmergencyBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AllEmergencyViewModel
    private val TAG = "AllEmergencyFragment"
    private lateinit var postRV : RecyclerView
    private lateinit var adapter : PostRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllEmergencyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val postList = ArrayList<Post>()
        postList.add(Post("Needs AB+ bloodtype","Emergency","Setif",5,2))
        postList.add(Post("Needing B- as soon as possible","Emergency","Bejaia",2,0))


        adapter= PostRVAdapter(postList,this)
        postRV =binding.allEmergencyRV
        postRV.layoutManager = LinearLayoutManager(requireContext())
        postRV.adapter = adapter

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllEmergencyViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun clickedPostItem(post: Post) {
        Log.d(TAG, post.title)
        val bundle= bundleOf("title" to post.title)
        findNavController().navigate(R.id.navigation_details,bundle)
    }

}