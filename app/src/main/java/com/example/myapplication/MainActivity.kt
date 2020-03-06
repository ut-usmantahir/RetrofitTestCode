package com.example.myapplication

//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.MyMovieAdapter
import com.example.myapplication.common.Common
import com.example.myapplication.`interface`.RetrofitService
import com.example.myapplication.model.Movie
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A Login Form Example in Kotlin Android
 */
class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: android.app.AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

        private fun getAllMovieList(){
          dialog.show()
            mService.getAllMovieList().enqueue(object : Callback<MutableList<Movie>> {
                override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {

                }

                override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MyMovieAdapter(baseContext,response.body() as MutableList<Movie>)

                    adapter.notifyDataSetChanged()
                    recyclerMovieList.adapter = adapter

                    dialog.dismiss()
                }

            })
        }
    }
