package com.my.openanime;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.view.View;
import android.widget.FrameLayout;
import android.content.res.Configuration;
import android.webkit.WebSettings;

public class MenuActivity extends AppCompatActivity {
	
	private boolean Dark_webview = false;
	
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.menu);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setDomStorageEnabled(true);
		webview1.getSettings().setLoadWithOverviewMode(true);
		webview1.getSettings().setUseWideViewPort(true);
		webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webview1.getSettings().setDomStorageEnabled(true);
		webview1.setWebChromeClient(new CustomWebClient());
		webview1.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		webview1.getSettings().setDomStorageEnabled(true); // localStorage desteği
		webview1.getSettings().setDatabaseEnabled(true);   // Web SQL, IndexedDB
		WebSettings webSettings = webview1.getSettings();
		        webSettings.setJavaScriptEnabled(true);
		        webSettings.setDomStorageEnabled(true); // DOM depolamayı etkinleştirir
		        webSettings.setDatabaseEnabled(true); // Veritabanı desteğini etkinleştirir
		        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); // Önbelleği kullanır
		
		        CookieManager cookieManager = CookieManager.getInstance();
		        cookieManager.setAcceptCookie(true);
		        cookieManager.setAcceptThirdPartyCookies(webview1, true);
		        cookieManager.setAcceptFileSchemeCookies(true);
		        
		        // WebView içinde çerezleri senkronize etmek için WebViewClient kullan
		        webview1.setWebViewClient(new WebViewClient() {
			            @Override
			            public void onPageFinished(WebView view, String url) {
				                super.onPageFinished(view, url);
				                CookieManager.getInstance().flush(); // Çerezleri kaydet
				            }
			        });
		webview1.loadUrl("https://openani.me/");
		_dark();
		if (Dark_webview) {
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_ON);
		} else {
			if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK));
			WebSettingsCompat.setForceDark(webview1.getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
		}
	}
	
	
	@Override
	public void onBackPressed() {
		if (webview1.canGoBack()) {
			webview1.goBack();
		} else {
			finish();
		}
	}
	public void _extra() {
	}
	
	public class CustomWebClient extends WebChromeClient {
		private View mCustomView;
		private WebChromeClient.CustomViewCallback mCustomViewCallback;
		protected FrameLayout frame;
		
		// Initially mOriginalOrientation is set to Landscape
		private int mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		private int mOriginalSystemUiVisibility;
		
		// Constructor for CustomWebClient
		public CustomWebClient() {}
		
		public Bitmap getDefaultVideoPoster() {
			if (MenuActivity.this == null) {
				return null; }
			return BitmapFactory.decodeResource(MenuActivity.this.getApplicationContext().getResources(), 2130837573); }
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			if (this.mCustomView != null) {
				onHideCustomView();
				return; }
			this.mCustomView = paramView;
			this.mOriginalSystemUiVisibility = MenuActivity.this.getWindow().getDecorView().getSystemUiVisibility();
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			MenuActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			// After that mOriginalOrientation is set to portrait.
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
			this.mCustomViewCallback = viewCallback; ((FrameLayout)MenuActivity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); MenuActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
		}
		
		public void onHideCustomView() {
			((FrameLayout)MenuActivity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			this.mCustomView = null;
			MenuActivity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			// When CustomView is hidden, screen orientation is set to mOriginalOrientation (portrait).
			MenuActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			// After that mOriginalOrientation is set to landscape.
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			this.mCustomViewCallback = null;
		}
	}
	
	{
	}
	
	
	public void _dark() {
		int nightModeFlags = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
		Dark_webview = true;
		boolean darkModeEnabled = (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}