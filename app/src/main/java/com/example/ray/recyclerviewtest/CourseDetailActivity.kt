package com.example.ray.recyclerviewtest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewMain.layoutManager = LinearLayoutManager(this)
        recyclerViewMain.adapter = CourseDetailAdapter()
    }

    private class CourseDetailAdapter : RecyclerView.Adapter<CourseLessonViewHolder>(){

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CourseLessonViewHolder {
            val blueView = View(p0?.context)
            blueView.setBackgroundColor(Color.BLUE)
            blueView.minimumHeight = 50
            return CourseLessonViewHolder(blueView)
        }

        override fun getItemCount(): Int {
            return 3
        }

        override fun onBindViewHolder(p0: CourseLessonViewHolder, p1: Int) {

        }

        }
    }
    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }

