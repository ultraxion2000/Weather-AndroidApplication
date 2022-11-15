package com.example.weather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.adapters.WeatherAdapter
import com.example.weather.adapters.WeatherModel
import com.example.weather.databinding.FragmentHoursBinding
import com.google.android.gms.common.util.CollectionUtils.listOf

class HoursFragment : Fragment() {
    private lateinit var binding : FragmentHoursBinding
    private lateinit var adapter : WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() {
        binding.rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        binding.rcView.adapter = adapter
        val list = listOf(
        WeatherModel(
            "", "22:26",
            "Sunny", "1°C",
            "", "", "", ""),
        WeatherModel(
            "", "23:26",
            "Sunny", "0°C",
            "", "", "", ""),
        WeatherModel(
            "", "00:00",
            "Sunny", "-5°C",
            "", "", "", "")
        )
        adapter.submitList(list)
    }

    companion object {
        fun newInstance() = HoursFragment()
    }
}