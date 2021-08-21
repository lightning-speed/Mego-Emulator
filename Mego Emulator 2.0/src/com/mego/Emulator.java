package com.mego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Timer;

import com.mego.internal.CPU;
import com.mego.internal.Memory;
import com.mego.ui.VGA;
import com.mego.ui.Window;
import com.mego.util.FileManager;

public class Emulator {
  public static String File_Content = "";
  public static String in_file;
  public static Window win;
  public static void start_emulator(String file_path) {
	  in_file = file_path;
	  Memory.mem_init();
	  win = new Window();
	  new Thread(new Runnable() {

		@Override
		public void run() {
			for(;;) {
				try {
					Thread.sleep(100);
					VGA.update();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}}).start();
	  Timer t = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Memory.dump();
			}
			  
		  });
		  t.start();
	  if(!new File(file_path).exists()) {
		  System.out.println("File not exists");
		  return;
	  }
	  else {
		  File_Content = FileManager.read(file_path);
		  Memory.load_memory(File_Content);
		  CPU.start_execution();
	  }
  }
}
