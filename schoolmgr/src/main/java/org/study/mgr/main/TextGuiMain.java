package org.study.mgr.main;

import java.io.IOException;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class TextGuiMain {

	public static void main(String[] args) {
		DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
		Terminal terminal = null;
		final TextGraphics textGraphics;
		int startX = 2;
		int endX = 10;
		try {
			terminal = defaultTerminalFactory.createTerminal();
			terminal.enterPrivateMode();

			terminal.clearScreen();
			textGraphics = terminal.newTextGraphics();
			endX = terminal.getTerminalSize().getColumns() - 5;
			textGraphics.drawLine(startX, 1, endX, 1, '-');

			terminal.flush();

			KeyStroke keyStroke = terminal.readInput();

			while (keyStroke.getKeyType() != KeyType.Escape) {
				terminal.flush();
				keyStroke = terminal.readInput();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (terminal != null) {
				try {
					terminal.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
