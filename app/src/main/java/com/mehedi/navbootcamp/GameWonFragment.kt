package com.mehedi.navbootcamp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.mehedi.navbootcamp.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment() {
    
    lateinit var binding: FragmentGameWonBinding
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        
        binding = FragmentGameWonBinding.inflate(layoutInflater, container, false)
        
        val score = GameWonFragmentArgs.fromBundle(requireArguments()).score
        val numberOfQuestion = GameWonFragmentArgs.fromBundle(requireArguments()).numberOfQuestion
        
        binding.apply {
            txtScore.text = "Your Score is $score out of $numberOfQuestion questions"
        }
        setAppbarMenu()
        
        
        
        
        return binding.root
    }
    
    private fun setAppbarMenu() {
        
        val menuHost: MenuHost = requireActivity()
        
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.winner_menu, menu)
                
            }
            
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                
                return when (menuItem.itemId) {
                    R.id.share -> {
                        shareAchievement()
                        true
                    }
                    
                    else -> false
                }
                
                
            }
            
        })
        
        
    }
    
    private fun shareAchievement() {
        
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, binding.txtScore.text.toString())
        
        startActivity(shareIntent)
        
        
    }
    
    
}


