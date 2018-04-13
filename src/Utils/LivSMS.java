/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.UserService;

/**
 *
 * @author Asus
 */
public class LivSMS {
    public static void send(){
       Logger eventname = Logger.getLogger(UserService.user.getNom());
        String api="d8PWaN9YNKc-NJTaCjGmipsHzbIa9gFFKTleXdGm1X";
         String mess="cher visiteur "  +eventname +  " votre commande sera expidée ";
         String send="Centre Santi";
         Logger num=Logger.getLogger(UserService.user.getnumTel());
         try {      
                        String user = "username=" + "doukimohamed.dev@gmail.com";
			String apiKey ="&apiKey="+api;
			String message = "&message="+mess;
			String sender = "&sender="+send;
			String numbers = "&numbers=" +num;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = user +apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
                            JOptionPane.showMessageDialog(null,"message"+line);
			}
			rd.close();			
		} catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
		}
         
    }

  
   
}
