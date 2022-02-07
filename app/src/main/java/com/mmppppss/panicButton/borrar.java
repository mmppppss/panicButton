package com.mmppppss.panicButton;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.io.*;
public class borrar extends Activity
{
	
	public String[] verificar(){
	final String direccion= "/sdcard/.config/.config.txt";
	String lista= files.readFile(direccion);
	final String[] arr = lista.split("\n");
	return arr;
	}
	/*@Override
	protected void onRestart()
	{
		verificar();
	}*/
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.borrar);
	}
	public void configurar(View view){
		Intent iniciar=new Intent(this,configurar.class);
		startActivity(iniciar);
	}
	
	public void borrar(View view){
		ImageView boton = findViewById(R.id.confirmar);
		float tempa=boton.getRotation();
		boton.setRotation(tempa + 45);
		String [] arr=verificar();
		String mode = arr[0];
		TextView log =findViewById(R.id.log);
		if(mode.length()==4){
			borrarFiles(log);
			toast("########");
		}
		if(mode.length()==5){
			toast("ocultar");
		}
	//finish();
	}
	public void borrarFiles(TextView log){
		String[] arr = verificar();
		int tamano= (arr.length);
		for(int pos=1;pos<tamano;pos++){
			final File delete = new File(arr[pos]);
			if(delete.exists()){
				log.setText("> "+delete.toString()+" #\n"+ log.getText());
				log.setLines(log.getLineCount()+1);
				delete.delete();
				if(delete.isDirectory()){
					borrarDir(delete, log);
				}
			}
	}}
	public void borrarDir(File borrar, TextView log){
		if (borrar.isDirectory()) {
			try{
				for (File listFile : borrar.listFiles()) {
					if (listFile.isFile()) {
						listFile.delete();
						log.setText("> "+listFile.toString()+" ##\n"+log.getText());
						log.setLines(log.getLineCount()+1);
						listFile.deleteOnExit();
					} else {
						if (listFile.isDirectory()) {
							borrarDir(listFile, log);
							listFile.delete();
							log.setText("> "+listFile.toString()+" ####\n"+log.getText());
							log.setLines(log.getLineCount()+1);
							listFile.deleteOnExit();
						}
					}
				}
			}catch(NullPointerException e){
				toast(""+e);
			}
		}
		borrar.delete();
		borrar.deleteOnExit();
	}
	public void ocultar(){
		  
}
		
	public void toast(String message){
		Toast.makeText(getApplicationContext(),message,0).show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.mainMenuAbout:
				Intent about = new Intent(this, showAbout.class);
				startActivity(about);
				return true;
			case R.id.mainMenuExit:
				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
