package com.example.submission1githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataUser(
    var username: String?,
    var name: String?,
    var locatioan: String?,
    var repository: String?,
    var company: String?,
    var followers: String?,
    var following: String?,
    var avatar: Int
) : Parcelable