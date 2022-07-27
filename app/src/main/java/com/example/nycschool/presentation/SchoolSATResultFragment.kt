package com.example.nycschool.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nycschool.data.remote.model.SATResult
import com.example.nycschool.data.remote.repository.SchoolSATResultRepository
import com.example.nycschool.data.remote.services.RetrofitServices
import com.example.nycschool.databinding.FragmentSchoolSATResultBinding
import com.example.nycschool.viewmodel.SchoolSATResultViewModel
import com.example.nycschool.viewmodel.SchoolSATResultViewModelFactory

class SchoolSATResultFragment : Fragment() {

    private lateinit var viewModel: SchoolSATResultViewModel
    private val retrofitService = RetrofitServices.getInstance()
    private lateinit var binding: FragmentSchoolSATResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            SchoolSATResultViewModelFactory(SchoolSATResultRepository(retrofitService))
        ).get(SchoolSATResultViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolSATResultBinding.inflate(inflater, container, false)

        val dbn = SchoolSATResultFragmentArgs.fromBundle(arguments!!).dbnID
        viewModel.getAllSATResults()

        viewModel.satResult.observe(viewLifecycleOwner, Observer {
            setData(it, dbn)
            binding.progressLoader.visibility = View.GONE
            binding.layout.visibility = View.VISIBLE
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })

        return binding.root
    }

    private fun setData(it: List<SATResult>?, dbn: String) {
        val satResult: List<SATResult> = it!!.filter { satResult -> dbn == satResult.dbn }
        binding.schoolName.text = satResult.get(0).school_name
        binding.noOfSatTakenNumber.text = satResult.get(0).num_of_sat_test_takers
        binding.satMathAvgScoreNumber.text = satResult.get(0).sat_math_avg_score
        binding.satWritingAvgScoreNumber.text = satResult.get(0).sat_writing_avg_score
        binding.readingAvgScoreNumber.text = satResult.get(0).sat_critical_reading_avg_score
    }
}