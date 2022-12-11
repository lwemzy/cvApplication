package com.lwemzy.cvApplication.ui.webview

import android.content.Context
import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.lwemzy.cvApplication.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_web_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val homeSharedPref = activity?.getSharedPreferences("home", Context.MODE_PRIVATE)
        val linkedIn = homeSharedPref?.getString("linkedIn", "")

        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view?.loadUrl(url)
                return true
            }
        }


        webview.loadUrl("https://www.linkedin.com/in/$linkedIn/")
        webview.settings.javaScriptEnabled = true
        webview.settings.allowContentAccess = true
        webview.settings.domStorageEnabled = true
    }
}