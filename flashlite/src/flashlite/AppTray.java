package flashlite;

import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class AppTray {
	SystemTray tray;
	int NEW_WIDTH =16;
	int NEW_HEIGHT = 16;
	
	//InputStream stream = AppTray.class.getResourceAsStream("Flashlight-32x32.png");
	//Image image1 = null;

	//Image image1 =  ImageIO.read(stream);


	
	
	public AppTray() {
		if(!SystemTray.isSupported())
			return;
		
		Image icon= Toolkit.getDefaultToolkit().getImage(
				AppTray.class.getResource("/Flashlight-32x32.png"));
		//URL iconURL = AppTray.class.getClass().getResource("Flashlight-32x32.png");
		//URL iconURL =null;
		//iconURL = AppTray.class.getResource("Flashlight-32x32.png");
		//Image icon= Toolkit.getDefaultToolkit().createImage(iconURL);
		Image scaledIcon = icon.getScaledInstance( NEW_WIDTH, NEW_HEIGHT,  java.awt.Image.SCALE_SMOOTH ) ; 
		
		
		
		
		
		tray = SystemTray.getSystemTray();
		//add finally to send a message to server that you quit the program
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screens = ge.getScreenDevices();
		//Robot r = new Robot()
		
		final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon =
                new TrayIcon(scaledIcon, null, popup);
        final SystemTray tray = SystemTray.getSystemTray();
       
        MenuItem aboutItem = new MenuItem("About");
        CheckboxMenuItem cb1 = new CheckboxMenuItem("Set auto size");
        CheckboxMenuItem cb2 = new CheckboxMenuItem("Set tooltip");
        Menu displayMenu = new Menu("Display");
       
        MenuItem monitorCapture = new MenuItem("Select monitor to capture:");
        for (GraphicsDevice screen : screens) {
        	//System.out.println(screen.toString());
        popup.add(new MenuItem(screen.toString()));	
        }
        
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
        
        monitorCapture.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
			}
        	
        });
        
        exitItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//SystemTray.remove(trayIcon);
				
			}
        	
        }
        );
        
       
        //Add components to pop-up menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(cb1);
        popup.add(cb2);
        popup.addSeparator();
        popup.add(displayMenu);
     
        
        displayMenu.add(infoItem);
        displayMenu.add(noneItem);
        popup.add(exitItem);
       
        trayIcon.setPopupMenu(popup);
       
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
		
		
	}

}
