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

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat

/**
 * ColorUtils is a class with one method, used to color the ViewHolders in
 * the RecyclerView. I put in a separate class in an attempt to keep the
 * code organized.
 *
 * We aren't going to go into detail about how this method works, but feel
 * free to explore!
 */
object ColorUtils {
    /**
     * This method returns the appropriate shade of green to form the gradient
     * seen in the list, based off of the order in which the
     * [com.example.android.recyclerview.GreenAdapter.ViewHolder]
     * instance was created.
     *
     * This method is used to show how ViewHolders are recycled in a RecyclerView.
     * At first, the colors will form a nice, consistent gradient. As the
     * RecyclerView is scrolled, the
     * [com.example.android.recyclerview.GreenAdapter.ViewHolder]'s will be
     * recycled and the list will no longer appear as a consistent gradient.
     *
     * @param context     Context for getting colors
     * @param instanceNum Order in which the calling ViewHolder was created
     *
     * @return A shade of green based off of when the calling ViewHolder
     * was created.
     */
    fun getViewHolderBackgroundColorFromInstance(context: Context, instanceNum: Int): Int {
        return when (instanceNum) {
            0 -> ContextCompat.getColor(context, R.color.material50Green)
            1 -> ContextCompat.getColor(context, R.color.material100Green)
            2 -> ContextCompat.getColor(context, R.color.material150Green)
            3 -> ContextCompat.getColor(context, R.color.material200Green)
            4 -> ContextCompat.getColor(context, R.color.material250Green)
            5 -> ContextCompat.getColor(context, R.color.material300Green)
            6 -> ContextCompat.getColor(context, R.color.material350Green)
            7 -> ContextCompat.getColor(context, R.color.material400Green)
            8 -> ContextCompat.getColor(context, R.color.material450Green)
            9 -> ContextCompat.getColor(context, R.color.material500Green)
            10 -> ContextCompat.getColor(context, R.color.material550Green)
            11 -> ContextCompat.getColor(context, R.color.material600Green)
            12 -> ContextCompat.getColor(context, R.color.material650Green)
            13 -> ContextCompat.getColor(context, R.color.material700Green)
            14 -> ContextCompat.getColor(context, R.color.material750Green)
            15 -> ContextCompat.getColor(context, R.color.material800Green)
            16 -> ContextCompat.getColor(context, R.color.material850Green)
            17 -> ContextCompat.getColor(context, R.color.material900Green)
            else -> Color.WHITE
        }
    }
}