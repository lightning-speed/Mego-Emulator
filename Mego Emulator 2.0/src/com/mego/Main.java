package com.mego;

public class Main {
   public static void main(String args[]) {
	   try {
		   Emulator.start_emulator(args[0]);
	   }
	   catch(Exception e) {
		   System.out.println("No input files");
	   }
   }
}
