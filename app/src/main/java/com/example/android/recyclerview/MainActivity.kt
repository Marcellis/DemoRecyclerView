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

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    /*
     * References to RecyclerView and Adapter to reset the list to its
     * "pretty" state when the reset menu item is clicked.
     */
    private var mAdapter: GreenAdapter? = null
    private var mNumbersList: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
         * Using findViewById, we get a reference to our RecyclerView from xml. This allows us to
         * do things like set the adapter of the RecyclerView and toggle the visibility.
         */mNumbersList = findViewById(R.id.rv_numbers) as RecyclerView
        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list. This means that it can produce either a horizontal or
         * vertical list depending on which parameter you pass in to the LinearLayoutManager
         * constructor. By default, if you don't specify an orientation, you get a vertical list.
         * In our case, we want a vertical list, so we don't need to pass in an orientation flag to
         * the LinearLayoutManager constructor.
         *
         * There are other LayoutManagers available to display your data in uniform grids,
         * staggered grids, and more! See the developer documentation for more details.
         */
        val layoutManager = LinearLayoutManager(this)
        mNumbersList!!.layoutManager = layoutManager
        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */mNumbersList!!.setHasFixedSize(true)
        /*
         * The GreenAdapter is responsible for displaying each item in the list.
         */mAdapter = GreenAdapter(NUM_LIST_ITEMS)
        mNumbersList!!.adapter = mAdapter
    }

    // COMPLETED (7) Override onCreateOptionsMenu
// COMPLETED (8) Use getMenuInflater().inflate to inflate the menu
// COMPLETED (9) Return true to display this menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // COMPLETED (10) Override onOptionsItemSelected
// COMPLETED (11) Within this method, get the ID from the MenuItem
// COMPLETED (12) If the ID equals R.id.action_refresh, create and set a new adapter on the RecyclerView and return true
// COMPLETED (13) For now, for all other IDs, return super.onOptionsItemSelected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        when (itemId) {
            R.id.action_refresh -> {
                mAdapter = GreenAdapter(NUM_LIST_ITEMS)
                mNumbersList!!.adapter = mAdapter
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val NUM_LIST_ITEMS = 100
    }
}