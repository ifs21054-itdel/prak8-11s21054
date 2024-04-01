package com.ifs21054.youtube.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ifs21054.youtube.DetailMovieActivity
import com.ifs21054.youtube.Movie
import com.ifs21054.youtube.MovieAdapter
import com.ifs21054.youtube.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieArrayList: ArrayList<Movie>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_movie)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MovieAdapter(movieArrayList){
            val intent = Intent(context, DetailMovieActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.malficent,
            R.drawable.narnia,
            R.drawable.alladin,
            R.drawable.beauty,
            R.drawable.lionking,
            R.drawable.cinderella,
            R.drawable.junglekruise,
            R.drawable.togo,
            R.drawable.hamilton,
            R.drawable.cruella,
            )
        title = arrayOf(
            getString(R.string.malficent),
            getString(R.string.narnia),
            getString(R.string.alladin),
            getString(R.string.beauty),
            getString(R.string.lionking),
            getString(R.string.cinderella),
            getString(R.string.junglekruise),
            getString(R.string.togo),
            getString(R.string.hamilton),
            getString(R.string.cruella),

        )
        descriptions = arrayOf(
            getString(R.string.malficent),
            getString(R.string.narnia),
            getString(R.string.alladin),
            getString(R.string.beauty),
            getString(R.string.lionking),
            getString(R.string.cinderella),
            getString(R.string.junglekruise),
            getString(R.string.togo),
            getString(R.string.hamilton),
            getString(R.string.cruella),
        )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}

