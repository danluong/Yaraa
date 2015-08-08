package com.danluong.yaraa.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.danluong.yaraa.R;
import com.danluong.yaraa.apis.RedditApi;
import com.danluong.yaraa.models.listing.Child;
import com.danluong.yaraa.models.listing.Listing;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ArticleListActivity extends AppCompatActivity {

    @Bind(R.id.list)
    ListView listview;

    RedditApi mRedditApi;
    List<Child> mArticleList = new ArrayList<>();
    List<String> mArticleTitleList = new ArrayList<>();
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        ButterKnife.bind(this);

        mAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mArticleTitleList);
        listview.setAdapter(mAdapter);

        mRedditApi = new RedditApi();
        mRedditApi.getmService().listArticles("top", new Callback<Listing>() {

            @Override
            public void success(Listing articles, Response response) {
                mArticleList = articles.getData().getChildren();
                updateListView(mArticleList);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(ArticleListActivity.class.toString(), "RetrofitError error: " + error.getResponse().getReason().toString());
            }
        });

    }

    void updateListView(List<Child> articleList){
        if(!articleList.isEmpty()) {
            for (Child child : articleList) {
                mArticleTitleList.add(child.getData().getTitle());
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_article_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
