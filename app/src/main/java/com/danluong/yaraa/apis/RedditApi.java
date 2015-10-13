package com.danluong.yaraa.apis;

import com.danluong.yaraa.models.listing.Listing;
import com.danluong.yaraa.models.user.User;

import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by dluong on 8/6/2015.
 */
public class RedditApi {
    public static final String API_URL = "http://www.reddit.com";
    RedditService mService;

    public RedditService getmService() {
        return mService;
    }

    public RedditApi() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)  // Do this for development too.
                .build();

        mService = restAdapter.create(RedditService.class);
    }

    public interface RedditService {
        @GET("/{sub}.json")
        void listArticles(@Path("sub") String sub, @QueryMap Map<String, String> params, Callback<Listing> articles);

        @GET("/user/{username}/about.json")
        void listUser(@Path("username") String userId, Callback<User> user);
    }
}
