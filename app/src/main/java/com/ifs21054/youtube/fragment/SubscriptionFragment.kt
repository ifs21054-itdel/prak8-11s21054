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


class SubscriptionFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_subscription, container, false)
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
            R.drawable.harrypotter,
            R.drawable.conjuring,
            R.drawable.insideout,
            R.drawable.agaklaen,
            R.drawable.gangster,
            R.drawable.johnwick,
            R.drawable.encanto

        )
        title = arrayOf(
            getString(R.string.harrypotter),
            getString(R.string.conjuring),
            getString(R.string.insideout),
            getString(R.string.agaklaen),
            getString(R.string.gangster),
            getString(R.string.johnwick),
            getString(R.string.encanto),

            )
        descriptions = arrayOf(
            getString(R.string.harrypotter),
            getString(R.string.conjuring),
            getString(R.string.insideout),
            getString(R.string.agaklaen),
            getString(R.string.gangster),
            getString(R.string.johnwick),
            getString(R.string.encanto),


        )
        for (i in image.indices) {

            val movie = Movie(image[i],title[i], descriptions[i])
            movieArrayList.add(movie)
        }
    }
}

