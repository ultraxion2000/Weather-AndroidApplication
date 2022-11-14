package com.example.weather.fragments

import android.icu.number.NumberRangeFormatter.with
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresPermission
import androidx.fragment.app.FragmentActivity
import com.example.weather.R
import com.example.weather.adapters.VpAdapter
import com.example.weather.databinding.FragmentMainBinding
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.material.tabs.TabLayoutMediator
import java.util.jar.Manifest


class MainFragment : Fragment() {

    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance(),
    )
    private val tList = listOf(
        "Hours",
        "Days"
    )
    private  lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var  binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }

    private fun init() {
        val adapter = VpAdapter(activity as FragmentActivity,fList)
        binding.vp.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.vp){
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }
    private fun permissionListener(){
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission(){
        if(!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
    companion object {
        fun newInstance() = MainFragment()
    }
}


