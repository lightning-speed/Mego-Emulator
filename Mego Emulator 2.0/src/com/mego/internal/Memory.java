package com.mego.internal;

import java.io.File;

import com.mego.Emulator;
import com.mego.util.FileManager;

public class Memory {
   public static int AA = 0;
   public static int AB = 0;
   public static int AC = 0;
   public static int AD = 0;
   public static int AE = 0;
   public static int AF = 0;
   public static int AG = 0;
   public static int AH = 0;
   public static int AI = 0;
   public static int AJ = 0;
   public static int AK = 0;
   public static int AL = 0;
   public static int virtual_memory[] = new int[8192];
   public static int mem_pointer = 0;
   public static int stack_pointer = 2048;
   public static void mem_init() {
	   for(int i = 0;i<8192;i++)
	   virtual_memory[i]=0;
   }
   public static void load_memory(String mem) {
    for(int i = 0;i<mem.length()-1;i++) {
    	virtual_memory[mem_pointer] = (int)mem.charAt(i);
    	mem_pointer++;
    }
   }
   public static void push(int num) {
	   virtual_memory[stack_pointer]=num;
	   stack_pointer++;

   }
   public static int pop() {
	   int out = virtual_memory[2048];
	   for(int i = 2048;i<stack_pointer;i++) {
		   virtual_memory[i] = virtual_memory[i+1];
	   }
	   stack_pointer--;
	   return out;
   }
   public static void setRegValueOf(int reg,int value) {
	   if(reg==30)AA = value;
	   if(reg==31)AB = value;
	   if(reg==32)AC = value;
	   if(reg==33)AD = value;
	   if(reg==34)AE = value;
	   if(reg==35)AF = value;
	   if(reg==36)AG = value;
	   if(reg==37)AH = value;
	   if(reg==38)AI = value;
	   if(reg==39)AJ = value;
	   if(reg==40)AK = value;
	   if(reg==41)AL = value;
   }
   public static int getRegValueOf(int reg) {
	   if(reg==30)return AA;
	   if(reg==31)return AB;
	   if(reg==32)return AC;
	   if(reg==33)return AD;
	   if(reg==34)return AE;
	   if(reg==35)return AF;
	   if(reg==36)return AG;
	   if(reg==37)return AH;
	   if(reg==38)return AI;
	   if(reg==39)return AJ;
	   if(reg==40)return AK;
	   if(reg==41)return AL;
	   return 0;
   }
   public static void dump() {
	   String out="";
	    for(int i = 0;i<8192;i++) {
	    	out+=(char)virtual_memory[i];
	    }
	    FileManager.write(new File(Emulator.in_file).getParent()+"/mem_dump.bin",out);
   }
}
