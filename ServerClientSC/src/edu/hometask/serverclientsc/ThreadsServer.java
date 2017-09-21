package edu.hometask.serverclientsc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class ThreadsServer implements Runnable
{
	private Socket s;
	private Gson gson;
	private Integer number;
	private Order order;

	public ThreadsServer(Socket s)
	{
		this.s = s;
	}
	
	public void run() 
	{
		number=null;
		try
		{
			DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
			
			String chat=null;
			
			if ((chat = dis.readUTF()) != null) //readline deprecated ???
			{
				
				number = Integer.parseInt(chat);
				
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
				//зарегистрировали драйвер
				String user = "javaUser";
				String pass = "1234567";//TODO input from keyboard
				
				
				Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=SC;user="+user+";password="+pass+";");
				
			//	Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true;databaseName=SC");
				
				CallableStatement st = con.prepareCall("{call getRepairByNumber(?)}");
				st.setInt("number", number);
				
				if(st.execute())
				{
					order = new Order();
					ResultSet rs = st.getResultSet();
					ResultSetMetaData md = rs.getMetaData();
					
					order.setNumberTitle(md.getColumnLabel(1));
					order.setDateTitle(md.getColumnLabel(2));
					order.setClientTitle(md.getColumnLabel(3));
					order.setContactTitle(md.getColumnLabel(4));
					order.setPhoneTitle(md.getColumnLabel(5));
					order.setDeviceTitle(md.getColumnLabel(6));
					order.setSnTitle(md.getColumnLabel(7));
					order.setTypeRepairTitle(md.getColumnLabel(8));
					order.setDefectTitle(md.getColumnLabel(9));
					order.setCompletenessTitle(md.getColumnLabel(10));
					order.setEngineerTitle(md.getColumnLabel(11));
					order.setResultTitle(md.getColumnLabel(12));
					order.setPriceTitle(md.getColumnLabel(13));
					order.setStatusTitle(md.getColumnLabel(14));
					
					while(rs.next())
					{
						order.setId(Integer.parseInt(rs.getString(1)));
							order.setDate(rs.getString(2));
							order.setClient(rs.getString(3));
							order.setContact(rs.getString(4));
							order.setPhone(rs.getString(5));
							order.setDevice(rs.getString(6));
							order.setSn(rs.getString(7));
							order.setTypeRepair(rs.getString(8));
							order.setDefect(rs.getString(9));
							order.setCompleteness(rs.getString(10));
							order.setEngineer(rs.getString(11));
							order.setResult(rs.getString(12));
							order.setPrice(rs.getString(13));
							order.setStatus(rs.getString(14));
					}
				}
				
				st.close();//free tables involved in query
				con.close();//free connection resources
				
				gson = new Gson();
				
//				System.out.println(order.toString());
				
				dos.writeUTF(gson.toJson(order));
				dos.flush();
				s.close();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
