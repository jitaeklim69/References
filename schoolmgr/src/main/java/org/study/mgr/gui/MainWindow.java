package org.study.mgr.gui;

import java.util.Arrays;

import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Window;

public class MainWindow {

	public BasicWindow window;
	public MenuPanel menuPanel;
	public AddStudentPanel addStudentPanel;

	public MainWindow(String title) {
		window = new BasicWindow(title);
		menuPanel = new MenuPanel(window);

		window.setHints(Arrays.asList(Window.Hint.CENTERED));
		// window.setSize(new TerminalSize(60, 18));

		window.setComponent(menuPanel.panel);
	}

}
