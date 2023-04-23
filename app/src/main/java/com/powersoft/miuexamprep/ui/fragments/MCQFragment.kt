package com.powersoft.miuexamprep.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.powersoft.miuexamprep.R
import com.powersoft.miuexamprep.databinding.FragmentMcqBinding

class MCQFragment : Fragment() {

    private lateinit var binding: FragmentMcqBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_mcq, container, false)
        binding = FragmentMcqBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Implement your code here...
    }
}