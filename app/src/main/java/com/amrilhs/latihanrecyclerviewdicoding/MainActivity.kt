package com.amrilhs.latihanrecyclerviewdicoding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrilhs.latihanrecyclerviewdicoding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvHero: RecyclerView
    private lateinit var mainBinding: ActivityMainBinding
    private var list: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        rvHero = mainBinding.rvHeroList
        rvHero.setHasFixedSize(true)
        list.addAll(HeroesData.listData)
        showRecyclerViewList()
    }

    private fun showRecyclerViewList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHero.adapter = listHeroAdapter
    }
    private fun showCardViewPupuk(){
        rvHero.layoutManager=LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rvHero.adapter = cardViewHeroAdapter
    }
    private fun showGridViewPupuk(){
        rvHero.layoutManager = GridLayoutManager(this,2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHero.adapter = gridHeroAdapter

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.action_cardview -> {
                showCardViewPupuk()
                supportActionBar?.title = resources.getString(R.string.cardview)
            }
            R.id.action_grid -> {
                showGridViewPupuk()
                supportActionBar?.title = resources.getString(R.string.gridView)

            }
            R.id.action_list ->{
                showRecyclerViewList()
                supportActionBar?.title =resources.getString(R.string.app_name)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}