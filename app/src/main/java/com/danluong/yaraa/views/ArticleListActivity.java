package com.danluong.yaraa.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeContainer;

    @Bind(R.id.list)
    ListView mListView;

    RedditApi mRedditApi;
    List<Child> mArticleList = new ArrayList<>();
    ChildAdapter mAdapter;
    String mCurrentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        ButterKnife.bind(this);

        mCurrentTitle = getResources().getString(R.string.default_sub);
        mToolbar.setTitle(mCurrentTitle);

        setupNavDrawer();

        setupArticleList();
        articleQuery(mCurrentTitle);

        mSwipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                resetList();
                articleQuery(mCurrentTitle);
            }
        });

        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Child element = (Child) mListView.getItemAtPosition(position);
                        String url = element.getData().getUrl();
                        openBrowser(url);
                    }
                }
        );
    }

    private void setupNavDrawer() {

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close
        );
        mDrawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getGroupId() == R.id.navigation_group_categories) {
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();

                    String title = menuItem.getTitle().toString();
                    mToolbar.setTitle(title);
                    mCurrentTitle = title;

                    resetList();
                    articleQuery(title);
                } else if (menuItem.getItemId() == R.id.navigation_item_setttings) {
                    Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private void setupArticleList() {
        mAdapter = new ChildAdapter(this, mArticleList);
        mListView.setAdapter(mAdapter);
        mRedditApi = new RedditApi();
    }

    private void articleQuery(String sub) {
        mRedditApi.getmService().listArticles(sub, new Callback<Listing>() {

            @Override
            public void success(Listing articles, Response response) {
                mArticleList = articles.getData().getChildren();
                updateList(mArticleList);
                mSwipeContainer.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                if (error.getResponse() != null) {
                    Toast.makeText(getApplicationContext(), R.string.error_no_connection, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void updateList(List<Child> articleList) {
        mAdapter.addAll(articleList);
        mAdapter.notifyDataSetChanged();
    }

    void resetList(){
        mArticleList.clear();
        mAdapter.clear();
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
        }

        return super.onOptionsItemSelected(item);
    }

    private static final String HTTPS = "https://";
    private static final String HTTP = "http://";

    public void openBrowser(String url) {
        if (!url.startsWith(HTTP) && !url.startsWith(HTTPS)) {
            url = HTTP + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}
