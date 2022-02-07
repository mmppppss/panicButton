package com.mmppppss.panicButton;

import android.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
				|| checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
			}else{iniciar();}
		}else{iniciar();}
		}
	public void iniciar(){
		Intent iniciar=null;
		File index = new File("/sdcard/.config/.config.txt");
		if(index.exists()){
			iniciar=new Intent(MainActivity.this,borrar.class);
			startActivity(iniciar);
			finish();
		}else{
			iniciar=new Intent(MainActivity.this,configurar.class);
			startActivity(iniciar);
			finish();
			}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			toast("+++++");
			iniciar();
		}}
	
	public void toast(String message){
		Toast.makeText(getApplicationContext(),message,0).show();
	}
}
