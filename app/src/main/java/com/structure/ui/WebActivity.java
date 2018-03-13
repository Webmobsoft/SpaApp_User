/*
 *
 *  *
 *  *  * Copyright (c) 2016, Mobilyte Tech India Pvt. Ltd. and/or its affiliates. All rights reserved.
 *  *  *
 *  *  * Redistribution and use in source and binary forms, with or without
 *  *  * modification, are permitted provided that the following conditions are met:
 *  *  *
 *  *  *  - Redistributions of source code must retain the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer.
 *  *  *
 *  *  *  - Redistributions in binary form must reproduce the above copyright
 *  *  *    notice, this list of conditions and the following disclaimer in the
 *  *  *    documentation and/or other materials provided with the distribution.
 *  *
 *
 */

package com.structure.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.structure.R;
import com.structure.ui.base.BaseActivity;

public class WebActivity extends BaseActivity {
    private TextView toolbarTitle;
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        inflateToolbar();

        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebClient());

        loadUrl();

    }

    private class WebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            showProgressDialog();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            hideProgressDialog();
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);

            showCrouton(error.toString());
        }
    }

    private void inflateToolbar() {
        android.support.v7.widget.Toolbar mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbarTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        setToolbarTitle(getString(R.string.app_name), true);
    }

    // function to set the title of default_toolbar
    public void setToolbarTitle(String title, boolean isBackButton) {
        toolbarTitle.setText(title);
        if (isBackButton) {
        } else {
        }
    }

    @Override
    public void onBackPressed() {
        goBack();
        super.onBackPressed();
    }

    private void goBack() {
        finish();
    }

    private void loadUrl() {
        if (getIntent().getExtras() != null) {
            if (!TextUtils.isEmpty(getIntent().getExtras().getString(getString(R.string.urlIntentExtra)))) {
                webView.loadUrl(getIntent().getExtras().getString(getString(R.string.urlIntentExtra)));
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        loadUrl();
    }
}
