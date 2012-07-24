/*
 * ShowTimeApp.java
 *
 * Copyright 2007 Sun Microsystems, Inc. ALL RIGHTS RESERVED Use of 
 * this software is authorized pursuant to the terms of the license 
 * found at http://developers.sun.com/berkeley_license.html.
 * 
 *
 */

package ca.sixs;
/**
*
* @author John O'Conner (John.OConner@sun.com)
* modified by @author Rgr
*/


import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.Task;


public class NetworkTimeApp extends SingleFrameApplication {
    JPanel timePanel;
    JButton btnShowTime;
    JTextField txtShowTime;
    
    @Override
    protected void startup() {
        timePanel = new JPanel();
        btnShowTime = new JButton();
        txtShowTime = new JTextField();
        
        // Set the name of components so that
        // associated resources will be injected
        // automatically.
        txtShowTime.setName("txtShowTime");
        btnShowTime.setName("btnShowTime");
        
        // Retrieve and set Actions. 
        ActionMap map = getContext().getActionMap(this);
        javax.swing.Action action = map.get("retrieveTime");
        btnShowTime.setAction(action);
        
        timePanel.add(btnShowTime);
        timePanel.add(txtShowTime);
        
        show(timePanel);
    }
    
    @Action
    public Task<Date, Void> retrieveTime() {        
        Task<Date, Void> task = new NetworkTimeRetriever(this);
        return task;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(NetworkTimeApp.class, args);
    }


    class NetworkTimeRetriever extends Task<Date, Void> {
 
        public NetworkTimeRetriever(Application app) {
            super(app);
        }
        
        @Override
        protected Date doInBackground() throws Exception {
            URL nistServer = new URL("http://time.nist.gov:13");
            InputStream is = nistServer.openStream();
            int ch = is.read();
            StringBuffer dateInput = new StringBuffer();
            while(ch != -1) {
                dateInput.append((char)ch);
                ch = is.read();
            }
            String strDate = dateInput.substring(7, 24);
            DateFormat dateFormat = DateFormat.getDateTimeInstance();
            SimpleDateFormat sdf = (SimpleDateFormat)dateFormat;
            sdf.applyPattern("yy-MM-dd HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT-00:00"));
            Date now = dateFormat.parse(strDate);

            return now;
        }
        
        @Override
        protected void succeeded(Date time) {
            txtShowTime.setText(time.toString());
        }    
    }
}
