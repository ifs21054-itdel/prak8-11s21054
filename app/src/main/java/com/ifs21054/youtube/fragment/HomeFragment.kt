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


class HomeFragment : Fragment() {
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
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
            intent.putExtra(ExploreFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        movieArrayList = arrayListOf<Movie>()

        image = arrayOf(
            R.drawable.avatar,
            R.drawable.titanic,
            R.drawable.starwars,
            R.drawable.spiderman,
            R.drawable.jurassic,
            R.drawable.avengers,
            R.drawable.spiderman,
            R.drawable.furious,
        )

        title = arrayOf(
            getString(R.string.avatar),
            getString(R.string.titanic),
            getString(R.string.starwars),
            getString(R.string.spiderman),
            getString(R.string.jurassic),
            getString(R.string.avengers),
            getString(R.string.spiderman),
            getString(R.string.fastfurious),
        )
        descriptions = arrayOf(
            getString(R.string.avatar),
            getString(R.string.titanic),
            getString(R.string.starwars),
            getString(R.string.spiderman),
            getString(R.string.jurassic),
            getString(R.string.avengers),
            getString(R.string.spiderman),
            getString(R.string.fastfurious),

            )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}