package org.study.mgr.gui;

import java.util.Arrays;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;

public class MainWindow {
	
	public BasicWindow window;
	public ActionPanel actionPanel;
	public AddStudentPanel addStudentPanel;
	
	public MainWindow(String title) {
		window = new BasicWindow(title);
		actionPanel = new ActionPanel();
		
		addListenerToActionPanel();
		
		window.setHints(Arrays.asList(Window.Hint.CENTERED));
		//window.setSize(new TerminalSize(60, 18));
		
		window.setComponent(actionPanel.panel);
	}

	public void addListenerToActionPanel() {
		actionPanel.buttons[0].addListener(new Button.Listener() {
			
			public void onTriggered(Button button) {
				AddStudentPanel studentPanel = new AddStudentPanel(window, actionPanel.panel);
				window.setComponent(studentPanel.panel);
				
			}
		});
	}
}
