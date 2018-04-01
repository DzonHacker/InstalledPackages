package com.example.vamp.installedpackages

import android.Manifest
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.vamp.installedpackages.adapter.CostomRecyclerAdapter
import com.example.vamp.installedpackages.model.PackageModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var costomRecyclerAdapter:CostomRecyclerAdapter?=null
    var packageModel = ArrayList<PackageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scanningInstalled()
        costomRecyclerAdapter = CostomRecyclerAdapter(packageModel)
        var layoutManager = LinearLayoutManager(applicationContext)
        main_recyclerview.layoutManager = layoutManager
        main_recyclerview.adapter = costomRecyclerAdapter

    }

    fun scanningInstalled(){
        var appinfo = packageManager.getInstalledPackages(0)
        for(i in 0 until appinfo.size){
            if(!packageManager(appinfo[i])) {
                val appName = appinfo[i].applicationInfo.loadLabel(packageManager).toString()
                val appVer = appinfo[i].versionName;
                val appIcon = appinfo[i].applicationInfo.loadIcon(packageManager)
                packageModel.add(PackageModel(appName,appVer,appIcon))
            }
        }
    }
    fun packageManager(appinfo:PackageInfo):Boolean{
        return ((appinfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM)!=0)
    }

}
