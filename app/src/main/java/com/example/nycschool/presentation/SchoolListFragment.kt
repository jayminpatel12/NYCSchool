package com.example.nycschool.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.nycschool.data.remote.model.SchoolList
import com.example.nycschool.data.remote.repository.SchoolListRepository
import com.example.nycschool.data.remote.services.RetrofitServices
import com.example.nycschool.databinding.FragmentSchoolListBinding
import com.example.nycschool.viewmodel.SchoolListViewModel
import com.example.nycschool.viewmodel.SchoolListViewModelFactory

class SchoolListFragment : Fragment() {
    private lateinit var binding:FragmentSchoolListBinding
    private lateinit var schoolListViewModel: SchoolListViewModel
    private val retrofitService = RetrofitServices.getInstance()
    private var schoolListItemArrayList: ArrayList<SchoolList>? = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        schoolListViewModel = ViewModelProvider(this, SchoolListViewModelFactory(SchoolListRepository(retrofitService))).get(SchoolListViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        binding = FragmentSchoolListBinding.inflate(inflater, container, false)
        schoolListViewModel.getAllSchool()

        val adapter = SchoolListAdapter(schoolListItemArrayList!!)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.visibility = View.VISIBLE

        adapter.SetOnItemClickListener(object : SchoolListAdapter.ListItemClickListener {
            override fun onItemClick(listItem: SchoolList, position: Int, view: View) {

                //Navigate From Home Screen To SAT Result Screen
                val actionNavSchoolToNavSatResult: SchoolListFragmentDirections.ActionSchoolListFragmentToSchoolSATResultFragment =
                    SchoolListFragmentDirections.actionSchoolListFragmentToSchoolSATResultFragment(listItem.dbn)
                Navigation.findNavController(view).navigate(actionNavSchoolToNavSatResult)
            }
        })


        schoolListViewModel.schoolList.observe(viewLifecycleOwner, Observer {
            schoolListItemArrayList!!.addAll(it)
            adapter.submitList(schoolListItemArrayList)
            binding.progressLoader.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE

        })

        schoolListViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })

        return binding.root
    }



}