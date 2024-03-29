/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.recyclerview.databinding.NumberListItemBinding

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */
open class GreenAdapter(private val mNumberItems: Int) :
    RecyclerView.Adapter<GreenAdapter.ViewHolder>() {

    /*
    * The number of ViewHolders that have been created. Typically, you can figure out how many
    * there should be by determining how many list items fit on your screen at once and add 2 to 4
    * to that number. That isn't the exact formula, but will give you an idea of how many
    * ViewHolders have been created to display any given RecyclerView.
    *
    * Here's some ASCII art to hopefully help you understand:
    *
    *    ViewHolders on screen:
    *
    *        *-----------------------------*
    *        |         ViewHolder index: 0 |
    *        *-----------------------------*
    *        |         ViewHolder index: 1 |
    *        *-----------------------------*
    *        |         ViewHolder index: 2 |
    *        *-----------------------------*
    *        |         ViewHolder index: 3 |
    *        *-----------------------------*
    *        |         ViewHolder index: 4 |
    *        *-----------------------------*
    *        |         ViewHolder index: 5 |
    *        *-----------------------------*
    *        |         ViewHolder index: 6 |
    *        *-----------------------------*
    *        |         ViewHolder index: 7 |
    *        *-----------------------------*
    *
    *    Extra ViewHolders (off screen)
    *
    *        *-----------------------------*
    *        |         ViewHolder index: 8 |
    *        *-----------------------------*
    *        |         ViewHolder index: 9 |
    *        *-----------------------------*
    *        |         ViewHolder index: 10|
    *        *-----------------------------*
    *        |         ViewHolder index: 11|
    *        *-----------------------------*
    *
    *    Total number of ViewHolders = 11
    */
    private var viewHolderCount = 0

    /**
     * Cache of the children views for a list item.
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = NumberListItemBinding.bind(itemView)

        // Will display which ViewHolder is displaying this data
        var viewHolderIndex: TextView = binding.tvViewHolderInstance

        fun bind(listIndex: Int) {
            binding.tvItemNumber.text = listIndex.toString()
        }
    }


    /**
     *
     * This gets called when each new ViewHolder is created. This happens when the RecyclerView
     * is laid out. Enough ViewHolders will be created to fill the screen and allow for scrolling.
     *
     * @param viewGroup The ViewGroup that these ViewHolders are contained within.
     * @param viewType  If your RecyclerView has more than one type of item (which ours doesn't) you
     * can use this viewType integer to provide a different layout. See
     * [android.support.v7.widget.RecyclerView.Adapter.getItemViewType]
     * for more details.
     * @return A new NumberViewHolder that holds the View for each list item
     */
    @SuppressLint("SetTextI18n")
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val context = viewGroup.context
        val layoutIdForListItem = R.layout.number_list_item
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false
        val view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately)
        val viewHolder = ViewHolder(view)
        viewHolder.viewHolderIndex.text = "ViewHolder index: $viewHolderCount"
        val backgroundColorForViewHolder =
            ColorUtils.getViewHolderBackgroundColorFromInstance(context, viewHolderCount)
        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder)
        viewHolderCount++
        Log.d(
            TAG, "onCreateViewHolder: number of ViewHolders created: "
                    + viewHolderCount
        )
        return viewHolder
    }

    /**
     * OnBindViewHolder is called by the RecyclerView to display the data at the specified
     * position. In this method, we update the contents of the ViewHolder to display the correct
     * indices in the list for this particular position, using the "position" argument that is conveniently
     * passed into us.
     *
     * @param viewHolder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(position)
    }

    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available in our forecast
     */
    override fun getItemCount() = mNumberItems
}