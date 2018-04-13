/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entite.User;
import entite.livraison;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Sms {
    public static void send(User event){
        String api="d8PWaN9YNKc-NJTaCjGmipsHzbIa9gFFKTleXdGm1X";
         String mess="cher visiteur"  +event.getNom() +  "vous etes bien enregistré(e)";
         String send="Centre Santi";
         String num=event.getNumTel();
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

    public static void send(livraison L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
