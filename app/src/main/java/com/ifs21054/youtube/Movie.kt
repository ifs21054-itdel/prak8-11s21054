package com.ifs21054.youtube

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Movie(
    var imageMovie: Int,
    var titleMovie: String,
    var descMovie: String
) : Parcelable