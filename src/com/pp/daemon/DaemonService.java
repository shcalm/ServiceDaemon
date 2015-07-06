package com.pp.daemon;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.os.Process;

public class DaemonService extends Service {

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	@Override
	public void onCreate() {
		Log.d("===","oncreate");
		startNativeDaemon();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				int i = 0;
				while(true){
					Log.d("=======","value = " + i++ + Process.myPid());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		return Service.START_STICKY;
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
	}
	static {
		System.loadLibrary("dameon_jni");
	}
	public static native void startNativeDaemon();
	
}
