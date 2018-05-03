package com.carlos.carlos.csgoitems.ui.activities

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.carlos.carlos.csgoitems.R
import com.carlos.carlos.csgoitems.data.CSGOApiInterface
import com.carlos.carlos.csgoitems.models.CSGOItems
import com.carlos.carlos.csgoitems.models.CSGOObject
import com.carlos.carlos.csgoitems.models.Item
import com.carlos.carlos.csgoitems.ui.adapters.ItemsAdapter
import com.carlos.carlos.csgoitems.utils.getRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val csgoList: MutableList<CSGOObject> = ArrayList()
    val adapterRec = ItemsAdapter(csgoList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        main__rcv__list_items.setHasFixedSize(true)
        main__rcv__list_items.adapter = adapterRec
        main__rcv__list_items.layoutManager = LinearLayoutManager(MainActivity@this, LinearLayoutManager.VERTICAL, false)

        getCharacters()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun getCharacters() {

        val api = getRetrofit().create(CSGOApiInterface::class.java)
        val call = api.getAllItems()
        call.enqueue(object : Callback<CSGOItems<Item>> {
            override fun onResponse(call: Call<CSGOItems<Item>>, response: Response<CSGOItems<Item>>) {
                if (!response.isSuccessful) {
                    Log.i("itemsss", "Error: ${response.code()}")
                } else {
                    csgoList.clear()
                    response.body()?.items?.let { csgoList.addAll(it) }
                    adapterRec.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<CSGOItems<Item>>, t: Throwable) {
                //Toast.makeText(rootView.context, t.message, Toast.LENGTH_SHORT).show()
                Log.i("error", "Error: ${t.message}")
            }
        })
    }

}
