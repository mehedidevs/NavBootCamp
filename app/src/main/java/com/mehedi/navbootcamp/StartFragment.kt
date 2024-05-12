package com.mehedi.navbootcamp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mehedi.navbootcamp.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    
    
    lateinit var binding: FragmentStartBinding
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        
        binding.playButton.setOnClickListener {
            
            
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToGameFragment())
            
            
        }
        
        
        
        return binding.root
    }
    
    
}