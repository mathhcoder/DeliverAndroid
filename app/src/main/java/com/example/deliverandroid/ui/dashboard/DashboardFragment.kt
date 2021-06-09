package com.example.deliverandroid.ui.dashboard

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.deliverandroid.R
import com.example.deliverandroid.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Glide.with(imageView1.context)
            .asBitmap()
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1A-XKPWpFXfZBc6kWcuL4uEI_rKMeZFN99g&usqp=CAU")
            .into(imageView1)

        Glide.with(imageView2.context)
            .load("https://sag.uz/image/collection_1588574294.jpg")
            .placeholder(R.drawable.ic_card)
            .centerCrop()
            .into(imageView2)


    }

}