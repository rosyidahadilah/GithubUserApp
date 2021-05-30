package com.example.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context): BaseAdapter() {
    internal var users= arrayListOf<UserData>()
    override fun getCount(): Int =users.size

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.user_data, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as UserData
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtLocation: TextView = view.findViewById(R.id.txt_location)
        private val txtCompany: TextView = view.findViewById(R.id.txt_company)

        internal fun bind(user: UserData) {
            user.avatar?.let { imgAvatar.setImageResource(it) }
            txtName.text = user.name
            txtLocation.text = user.location
            txtCompany.text = user.company
        }
    }
}