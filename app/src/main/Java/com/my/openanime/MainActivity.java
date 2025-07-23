package com.my.openanime;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.webkit.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.net.NetworkInterface;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private boolean Dark_webview = false;
	
	private LinearLayout linear1;
	private ImageView imageview1;
	
	private Intent t = new Intent();
	private ProgressDialog b;
	private TimerTask bb;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
	}
	
	private void initializeLogic() {
		_dark();
		if (Dark_webview) {
			linear1.setBackgroundColor(0xFF000000);
		} else {
			linear1.setBackgroundColor(0xFFFFFFFF);
		}
		if (_isVpnUsed()) {
			SketchwareUtil.showMessage(getApplicationContext(), "VPN tespit edildi! Uygulama kapatılıyor.");
			bb = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							finish();
						}
					});
				}
			};
			_timer.schedule(bb, (int)(1000));
		} else {
			b = new ProgressDialog(MainActivity.this);
			bb = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							b.dismiss();
							t.setClass(getApplicationContext(), MenuActivity.class);
							startActivity(t);
							finish();
						}
					});
				}
			};
			_timer.schedule(bb, (int)(3000));
		}
	}
	
	public void _dark() {
		int nightModeFlags = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
		Dark_webview = true;
		boolean darkModeEnabled = (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES);
	}
	
	
	public boolean _isVpnUsed() {
		try {
			    for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
				        if (ni.isUp() && ni.getInterfaceAddresses().size() != 0) {
					            String name = ni.getName();
					            if (name.contains("tun") || name.contains("ppp") || name.contains("ipsec")) {
						                return true;
						            }
					        }
				    }
		} catch (Exception e) {
			    return false;
		}
		return false;
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