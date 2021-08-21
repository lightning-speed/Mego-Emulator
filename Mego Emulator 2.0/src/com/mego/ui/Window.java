package com.mego.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Window {

	public static JFrame frame;
    public static JTextArea vga = new JTextArea();
	public Window() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize((int)(80*7.1),(int)(25*17.5));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		vga.setBackground(Color.BLACK);
		vga.setForeground(Color.LIGHT_GRAY);
		vga.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 13));
		vga.setRows(25);
		vga.setColumns(80);
		
		
		vga.setLineWrap(true);
		vga.setBounds(0, 0, 562, 409);
		frame.getContentPane().add(vga);
		frame.setVisible(true);
	}
}
