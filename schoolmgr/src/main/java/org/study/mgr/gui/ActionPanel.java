package org.study.mgr.gui;

import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.Panel;

public class ActionPanel {
	
	public final int numOfActions = 4;
	public final String[] strOfActions = {
			" 학생 등록", " 학생 조회", "클라스 등록", "클라스 조회"
	};
	
	public Panel panel;
	public Button[] buttons;
	
	public ActionPanel() {
		panel = new Panel();
		buttons = new Button[numOfActions];
		
		RegisterButtons();
	}
	
	private void RegisterButtons() {
		
		for (int i = 0; i < numOfActions; i++) {
			buttons[i] = new Button(strOfActions[i]);
		}
		
		for (int i = 0; i < numOfActions; i++) {
			panel.addComponent(buttons[i]);
		}
		
	}
	
}
