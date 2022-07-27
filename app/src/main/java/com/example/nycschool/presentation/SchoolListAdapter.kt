package com.example.nycschool.presentation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschool.data.remote.model.SchoolList
import com.example.nycschool.databinding.SchoolListItemBinding

class SchoolListAdapter(
    private val schoolList : ArrayList<SchoolList>
) : ListAdapter<SchoolList, SchoolListAdapter.SchoolViewHolder>(SchoolListAdapterDiffCheck()) {

    var mItemClickListener: ListItemClickListener? = null

    interface ListItemClickListener {
        fun onItemClick(listItem: SchoolList, position: Int ,view:View)
    }

    //Create Custom Click Interface for Adapter Item
    fun SetOnItemClickListener(mItemClickListener: ListItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = SchoolListItemBinding.inflate(inflater, parent, false)
        return SchoolViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = schoolList[position]
        holder.bind(school,position)
    }


    override fun getItemCount(): Int {
        return schoolList.size
    }

    inner class SchoolViewHolder(val binding: SchoolListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(school: SchoolList, position: Int) {
            binding.title.text = school.school_name
            binding.address.text = school.location
            binding.email.text = school.school_email
            binding.description.text = school.overview_paragraph
            binding.schoolSports.text = school.school_sports
            binding.root.setOnClickListener{
                mItemClickListener?.onItemClick(school,position,it)
            }
        }

    }
}


