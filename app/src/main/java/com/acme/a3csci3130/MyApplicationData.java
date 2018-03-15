package com.acme.a3csci3130;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Franz on 2017-05-31.
 * Used by Brent Crane for assignment 3
 */

public class MyApplicationData extends Application {

    /**
     * Public reference to the firebase database
     */
    public DatabaseReference firebaseReference;

    /**
     * Public reference to the firebase instance
     */
    public FirebaseDatabase firebaseDBInstance;

}
