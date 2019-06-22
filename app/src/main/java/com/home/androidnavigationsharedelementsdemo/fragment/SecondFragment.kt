package com.home.androidnavigationsharedelementsdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.home.androidnavigationsharedelementsdemo.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    /**
     * 系統創建Fragment的時候回調, 介於onAttach()和onCreateView()之間, 一般用於初始化一些數據
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeActionBar()
        initializeDataAndView()
    }

    private fun initializeActionBar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun initializeDataAndView() {
        val args = SecondFragmentArgs.fromBundle(this.arguments!!)
        val name = args.name
        nameTextView.text = name
        val identity = args.identity
        identityTextView.text = identity
        val introduction = args.moreIntroduction
        introductionTextView.text = introduction
        Glide.with(this).load(R.drawable.icon_wanted_order).into(wantedOrderImageView)
        Glide.with(this).load(R.drawable.background_one_piece).into(onePieceImageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> findNavController().navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}
