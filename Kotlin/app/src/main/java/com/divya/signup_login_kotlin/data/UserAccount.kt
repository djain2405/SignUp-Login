package com.divya.rememberyourpasswords.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey


/**
 * Created by divya on 5/14/2018.
 */

@Entity(tableName = "useraccounts")
data class UserAccount
    (@PrimaryKey
    var userId: String,
    var password: String)





