package com.example.deliverandroid.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.deliverandroid.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.layout_header.*

class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        imageViewHeaderBack.visibility = View.GONE
        tabView.firstText = "Qabulga"
        tabView.secondText = "Balansim"

        textViewHeader.text = "Mahsulotlar Balansi"

        viewPager?.adapter = object : FragmentStateAdapter(this) {

            override fun getItemCount() = 2

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> FistFragment()
                    else -> SecondFragment()
                }
            }

        }

        onState(true)
        tabView?.onFirst = {
            viewPager.setCurrentItem(0, true)
        }

        tabView?.onSecond = {
            viewPager.setCurrentItem(1, true)
        }
        viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabView?.selectTab(position == 0)
            }
        })

    }

    private fun onState(isFirst: Boolean) {
        tabView?.selectTab(isFirst)

    }

}