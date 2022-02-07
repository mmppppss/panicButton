package com.mmppppss.panicButton;
import android.app.*;
import android.os.*;
import android.view.*;
import java.io.File;
import android.widget.*;
import android.view.View.*;
import java.io.*;

public class configurar extends Activity
{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.configurar);
		
		final String direccion= "/sdcard/.config/.config.txt";
		String eeeee= files.readFile(direccion);
		String a= eliMode(eeeee);
		final ToggleButton tog = findViewById(R.id.Toggle);
		tog.setChecked(true);
		tog.setClickable(false);
		final EditText listIndex =findViewById(R.id.listaIndice);
		Button ok = findViewById(R.id.ok);
		listIndex.setText(a);
		ok.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1){
				files.delete(direccion);
				String list=lista(listIndex);
				files.crear("/sdcard/.config","dir");
				files.crear(direccion,"file");
				files.write(direccion,"true"+"\n"+list+"\n");
				toast("++++++++");
			}});
			
	}
	public String lista(EditText listIndex){
		String list=(listIndex.getEditableText()).toString();
		return list;
	}
	public String eliMode(String a){
		String c=a.replaceFirst("false","");
		String d=c.replaceFirst("true","");
		String e=d.replaceFirst("\n","");
		return e;
	}
	
	public void toast(String message){
		Toast.makeText(getApplicationContext(),message,0).show();
	}
	
}
