package com.danluong.yaraa.views;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.danluong.yaraa.R;
import com.danluong.yaraa.adapters.ChildAdapter;
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

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    @Bind(R.id.list)
    ListView mListView;

    RedditApi mRedditApi;
    List<Child> mArticleList = new ArrayList<>();
    ChildAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        ButterKnife.bind(this);

        String title = getResources().getString(R.string.default_sub);
        mToolbar.setTitle(title);

        setupNavDrawer();

        setupArticleList();
        articleQuery(title);

    }

    private void setupNavDrawer() {

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close
        );
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();

                String title = menuItem.getTitle().toString();
                articleQuery(title.toString());
                mToolbar.setTitle(title);
                return true;
            }
        });
    }

    private void setupArticleList() {

        mAdapter = new ChildAdapter(this, mArticleList);

        mListView.setAdapter(mAdapter);

        mRedditApi = new RedditApi();

    }

    private void articleQuery(String sub){
        mAdapter.clear();
        mArticleList.clear();

        mRedditApi.getmService().listArticles(sub, new Callback<Listing>() {

            @Override
            public void success(Listing articles, Response response) {
                mArticleList = articles.getData().getChildren();
                updateListView(mArticleList);
            }

            @Override
            public void failure(RetrofitError error) {
                if (error.getResponse() != null) {
                    Log.d(ArticleListActivity.class.toString(), "RetrofitError error: " + error.getResponse().getReason());
                }
            }
        });
    }
    void updateListView(List<Child> articleList) {
        mAdapter.addAll(articleList);
        mAdapter.notifyDataSetChanged();
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

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
