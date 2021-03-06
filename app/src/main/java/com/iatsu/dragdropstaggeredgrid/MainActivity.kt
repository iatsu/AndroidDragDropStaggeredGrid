package com.iatsu.dragdropstaggeredgrid

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.iatsu.dragdropstaggeredgridlibrary.DragDropStaggeredGrid
import com.iatsu.dragdropstaggeredgridlibrary.Draggable

class MainActivity : AppCompatActivity(), Draggable {

    lateinit var dragDropStaggeredGrid: DragDropStaggeredGrid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dragDropStaggeredGrid = findViewById(R.id.dragDropStaggeredGrid)
        dragDropStaggeredGrid.callback = this


        //region add view list to layout
        val textViewList = mutableListOf<View>()
        for (i in 0 until 10) {
            val textView = TextView(this)
            textView.tag = i.toString()
            textView.setBackgroundColor(Color.BLACK)
            textView.setTextColor(Color.WHITE)
            textView.text = "Lorem ipsum " + i * 6847987465468486854
            textViewList.add(textView)
        }

        dragDropStaggeredGrid.setViews(textViewList, 5)
        //endregion

        val viewList = dragDropStaggeredGrid.getViews()

        //region update item with tag
        val textView = TextView(this)
        textView.setBackgroundColor(Color.BLACK)
        textView.setTextColor(Color.WHITE)
        textView.text = "Lorem ipsum"
        dragDropStaggeredGrid.setViewByTag(textView, "0")
        //endregion

        val view = dragDropStaggeredGrid.getViewByTag("0")
    }

    override fun dragging(localStateView: View, view: View?) {
        Log.i("i", "dragging")
    }

    override fun dragEnded(localStateView: View, view: View?) {
        Log.i("i", "drag ended")
        //Check if view changed places
        Log.i("Changed Places", dragDropStaggeredGrid.hasChangedPlaces().toString())
    }
}
