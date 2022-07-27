package com.example.nycschool.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.nycschool.data.remote.model.SchoolList

class SchoolListAdapterDiffCheck : DiffUtil.ItemCallback<SchoolList>()  {
    override fun areItemsTheSame(oldItem: SchoolList, newItem: SchoolList): Boolean {
        return oldItem.dbn == newItem.dbn
    }

    override fun areContentsTheSame(oldItem: SchoolList, newItem: SchoolList): Boolean {
        return oldItem == newItem
    }
}