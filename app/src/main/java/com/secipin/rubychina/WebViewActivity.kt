package com.secipin.rubychina

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import java.util.*

class WebViewActivity : Activity() {

    private var webView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WebView.setWebContentsDebuggingEnabled(true)

        webView = WebView(this)
        webView?.overScrollMode = View.OVER_SCROLL_NEVER
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.javaScriptEnabled = true
        webView?.loadUrl("https://ruby-china.net/?_t=" + Random().nextInt())
        setContentView(webView)
    }

    override fun onBackPressed() {
        if (webView?.canGoBack() ?: false) {
            webView?.goBack()
        } else {
            moveTaskToBack(true)
        }
    }
}
