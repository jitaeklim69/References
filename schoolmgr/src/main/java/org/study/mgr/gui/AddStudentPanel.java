package org.study.mgr.gui;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;

public class AddStudentPanel {
	public Panel panel;
	public Panel returnPanel;
	public BasicWindow parent;
	
	public AddStudentPanel(BasicWindow window, Panel backPanel) {
		this.parent = window;
		this.returnPanel = backPanel;
		panel = new Panel();
		
		panel.setLayoutManager(new GridLayout(2));
		
		panel.addComponent(new Label("학생이름"));
		panel.addComponent(new TextBox());
		panel.addComponent(new Button("Close", new Runnable() {
			public void run() {
				parent.setComponent(returnPanel);
			}
		}));
	}
	
	
}
