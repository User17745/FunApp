package com.sauravarya.toc;

/**
 * Created by Saurav Arya on 04-02-2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyAppWebViewClient extends WebViewClient {

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);

        view.loadData("There seems to be a problem with your Internet connection. Please try later", "text/html", "UTF-8");
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().length() == 0)
            if(Uri.parse(url).getHost().endsWith("")) {
                return false;
            }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}