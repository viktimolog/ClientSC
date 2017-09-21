package edu.hometask.androidclientsc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.os.Message;
import android.widget.Toast;

public class GetThread implements Runnable
{
	private Order order;
	private int number;
	private Socket s;
	private String IPServer;
	private String str;
	private Gson gson;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public GetThread(int number, String IPServer)
	{
		this.IPServer = IPServer;
		this.number = number;
		gson = new Gson();
		str=null;
	}
	@Override
	public void run()
	{
		try 
		{
			s = new Socket(IPServer.toString(),3571);
			dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
			dos.writeUTF(Integer.toString(number));
			dos.flush();
			  
			while ((str = dis.readUTF()) != null) 
			{
			order = gson.fromJson(str, Order.class);
			
			MainActivity.hMain.sendMessage(
					MainActivity.hMain.obtainMessage(
							MainActivity.HANDLER_KEYGETORDER, order));
			}
		} 
		catch (JsonSyntaxException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
