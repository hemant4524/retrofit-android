package com.htech.retrofit.service;

import com.htech.retrofit.model.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by software on 7/3/18.
 */

public interface ApiService {
    /*
   Retrofit get annotation with our URL
   And our method that will return us the List of ContactList
   */
    @GET("/json_data.json")
    Call<ContactList> getMyJSON();
}
