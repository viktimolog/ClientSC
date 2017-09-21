package edu.hometask.androidclientsc;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity 
{
	public static final int HANDLER_KEYIDREPAIR=0;

	public static final int HANDLER_KEYGETORDER = 1;
	
	private String IPServer;
	private Order order;
	private int number;
	
	static Handler hMain;
	
	static class MyHandler extends Handler
    {
    	WeakReference<MainActivity> wrActivity;

		public MyHandler(MainActivity activity)
		{
			wrActivity = new WeakReference<>(activity);
		}

		@Override
		public void handleMessage(Message msg)
		{
			if(msg.what==MainActivity.HANDLER_KEYIDREPAIR)
			{
				MainActivity ma = wrActivity.get();
				if(ma!=null)
				{
					if(ma.isNumeric(msg.obj.toString()))
					{
						ma.setNumber(Integer.parseInt(msg.obj.toString()));
					}
					else
					{
						ma.setNumber(0);
					}
					new Thread(new GetThread(ma.getNumber(), ma.getIPServer())).start();
				}
			}
			if(msg.what==MainActivity.HANDLER_KEYGETORDER)
			{
				MainActivity ma = wrActivity.get();
				if(ma!=null)
				{
					ma.setOrder((Order)msg.obj);
					ma.getResult();
				}
			}
		}
    }
	
	private boolean isNumeric(String s) throws NumberFormatException 
	{
	    try 
	    {
	        Integer.parseInt(s);
	        return true;
	    } 
	    catch (NumberFormatException e) 
	    {
	        return false;
	    }
	}
	
    public void getResult()
    {
        if(order==null)
        {
        	order = new Order();
//        	order.setNumberTitle(R.string.IDnotfound);
        	order.setNumberTitle("Ваш ремонт не был найден");
        }
        
        if(order.getId()==0)
        {
        	order.setNumberTitle("Ваш ремонт не был найден");
        }
        
        arrListRes = order.createArrList();  		
        		
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
     
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.mylistview, arrListRes);
                
        lvMain.setAdapter(adapter);
    }
	
	public String getIPServer()
	{
		return IPServer;
	}

	public void setIPServer(String iPServer) 
	{
		IPServer = iPServer;
	}

	public int getNumber() 
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public Order getOrder() 
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	private ArrayList<String> arrListRes;
	private EditText etIdRepair;
	
	@Override
	protected void onDestroy()
	{
		if(hMain!=null) hMain.removeCallbacksAndMessages(null);//очищает отправленные с задержкой сообщения
		super.onDestroy();
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        hMain = new MyHandler(this);
        
       	IPServer = "192.168.1.104";
//    	IPServer = "10.1.100.78";
       	
        View viewName = View.inflate(this, R.layout.idrepair, null);
	    AlertDialog.Builder alertName = new AlertDialog.Builder(MainActivity.this);
	    alertName.setView(viewName);
	    alertName.setTitle(R.string.idrepairtitle);
//	    alertName.setMessage(R.string.personName);
	    alertName.setCancelable(false);
	    
	    etIdRepair = (EditText) viewName.findViewById(R.id.dialog1EditText);
	    
	    alertName.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener()
        {
			@Override
			public void onClick(DialogInterface dialog, int which)
			{
				MainActivity.hMain.sendMessage(
						MainActivity.hMain.obtainMessage(
								MainActivity.HANDLER_KEYIDREPAIR, etIdRepair.getText().toString()));
				dialog.cancel();
			}
		});
	    
	    AlertDialog ad1 = alertName.create();
	    
	    ad1.show();
    }
}
