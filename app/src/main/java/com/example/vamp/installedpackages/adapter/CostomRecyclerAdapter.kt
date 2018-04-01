package com.example.vamp.installedpackages.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vamp.installedpackages.R
import com.example.vamp.installedpackages.model.PackageModel
import kotlinx.android.synthetic.main.item_view.view.*

class CostomRecyclerAdapter(packageModel:ArrayList<PackageModel>): RecyclerView.Adapter<CostomRecyclerAdapter.CostomViewHolder>() {

    var model = packageModel;

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CostomViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_view,parent,false)
        return CostomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: CostomViewHolder?, position: Int) {
        var dataModel = model[position]
        holder!!.appName.text = dataModel.appName
        holder.appVer.text = dataModel.appVer
        holder.iconView.setImageDrawable(dataModel.appIcon)
    }

    class CostomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        var appName = itemView.findViewById<TextView>(R.id.app_name)
        var appVer = itemView.findViewById<TextView>(R.id.app_ver)
        var iconView = itemView.findViewById<ImageView>(R.id.app_icon)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {

        }
    }
}