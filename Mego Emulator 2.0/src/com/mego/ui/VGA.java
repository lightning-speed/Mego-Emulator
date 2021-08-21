package com.mego.ui;

import com.mego.internal.Memory;

public class VGA {
  public static void update() {
	  String text = "";
	  for(int i = 4096;i<=6096;i++) {
		  text+=(char)Memory.virtual_memory[i];
	  }
	  text = text.replace((char)0, ' ');
	  Window.vga.setText(text);
  }
}
