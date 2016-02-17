package com.sauravarya.toc;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.sauravarya.TOS.R;

import java.net.InetAddress;


public class MainActivity extends ActionBarActivity {




    private WebView mWebView;





    //enable back press button on the screen
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);




        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://rigassembler.com");

    }

    private ShareActionProvider mShareActionProvider;

    //here we add the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }


//here we have to add inside the menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.menu_item_share:
                shareURL();


        }

        int id = item.getItemId();


        //noinspection SimplifiableIfStatement---refresh button
        if (item.getItemId() == R.id.action_refresh) {
            mWebView.reload();
            return true;
        }
        if (item.getItemId() == R.id.action_about) {
            mWebView.loadUrl("http://www.rigassembler.com/pages/about-us");

        }
        if (item.getItemId() == R.id.action_bar) {
            mWebView.loadData("If your Application is not working then check your internet connection and try again or Contact: +91-9716704269", "text/html", "UTF-8");
        }
        if (item.getItemId() == R.id.action_context_bar) {
            mWebView.loadUrl("http://www.rigassembler.com");
        }
        return super.onOptionsItemSelected(item);


    }

    //share link but not working as per need
    private void shareURL() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "TECHNOTRONIC ONLINE SHOPPING");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "-Assemble Computer Online & Buy Electronic Products At Reasonable Price Visit-");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mWebView.getUrl());
        startActivity(Intent.createChooser(shareIntent, "Share Using"));
    }


}



