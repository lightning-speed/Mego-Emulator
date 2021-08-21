package com.mego.internal;

public class CPU {
  public static int cpu_pointer = 0;
  static int instruction[]  = new int[3];
  public static int instruction_pointer = 0;
  public static boolean last_run_sucess = true;
  public static int vga_pointer = 4096;
  public static void fetch() {
	  instruction[instruction_pointer]=Memory.virtual_memory[cpu_pointer];
	  if(instruction[instruction_pointer]==101)
	  instruction[instruction_pointer] = 0;
	  instruction_pointer++;
  }
  public static void start_execution() {
	  for(cpu_pointer = 0;Memory.virtual_memory[cpu_pointer]>0;cpu_pointer++) {
	      try {
              if (Memory.virtual_memory[cpu_pointer] != 43)
                  fetch();
              else {
                  exec(instruction);
                  instruction_pointer = 0;
                  instruction = new int[3];
              }
          }
	      catch (Exception e){
	    	 System.out.println("Pointer out of memory");
	    	
	      }
		  
	  }
	  Memory.dump();
	  System.out.println("\nNo more instructions left,System halted!");
  }
  public static void exec(int in[]) {
      if(in[0]==11) {
    	  //MOV number
    	  Memory.setRegValueOf(in[1],in[2]);
      }
      if(in[0]==1) {
    	  //MOV reg
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[2]));
      }
      if(in[0]==19){
    	  //Push
          Memory.push(in[1]);
      }
      if(in[0]==20) {
    	  //POP
    	  Memory.setRegValueOf(in[1], Memory.pop());
      }
      if(in[0]==12) {
    	  //ADD number
    	  Memory.setRegValueOf(in[1],in[2]+Memory.getRegValueOf(in[1]));
      }
      if(in[0]==2) {
    	  //ADD reg
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[2])+Memory.getRegValueOf(in[1]));
      }
      if(in[0]==42) {
    	  //SUB number
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])-in[2]);
      }
      if(in[0]==3) {
    	  //SUB reg
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])-Memory.getRegValueOf(in[2]));
      }
      if(in[0]==14) {
    	  //MUL number
    	  Memory.setRegValueOf(in[1],in[2]*Memory.getRegValueOf(in[1]));
      }
      if(in[0]==4) {
    	  //MUL reg
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[2])*Memory.getRegValueOf(in[1]));
      }
      if(in[0]==26) {
    	  //INT num
    	  if(in[1]==10) {
    		  Memory.virtual_memory[vga_pointer] = Memory.AC;
    		  if(vga_pointer==6096)
    			  vga_pointer=4096;
    		  else vga_pointer++;
    	  }
      }
      if(in[0]==15) {
    	  //DIV number
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])/in[2]);
      }
      if(in[0]==5) {
    	  //DIV reg
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])/Memory.getRegValueOf(in[2]));
      }
      if(in[0]==24) {
    	  //outb
    	  Memory.virtual_memory[Memory.getRegValueOf(in[1])] = in[2];
      }
      if(in[0]==23) {
          //inb
    	 Memory.setRegValueOf(in[1], Memory.virtual_memory[in[2]]);
      }
      if(in[0]==16) {
          //and
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])&in[2]);
      }
      if(in[0]==6) {
          //andr
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])&Memory.getRegValueOf(in[2]));
      }
      if(in[0]==17) {
          //or
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])|in[2]);
      }
      if(in[0]==7) {
          // orr
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])|Memory.getRegValueOf(in[2]));
      }
      if(in[0]==18) {
          //xor
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])^in[2]);
      }
      if(in[0]==8) {
          //xorr
          Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])^Memory.getRegValueOf(in[2]));
      }
      if(in[0]==21){
    	  //jmp
          cpu_pointer = in[1];
      }
      if(in[0]==44) {
    	  //dec
    	  if(Memory.getRegValueOf(in[1])>0) {
    	  Memory.setRegValueOf(in[1],Memory.getRegValueOf(in[1])-1);
    	  last_run_sucess = true;
    	  }
    	  else last_run_sucess = false;
      }
      if(in[0]==46) {
    	  //min
    	  if(Memory.getRegValueOf(in[1])<in[2]) {
    	  last_run_sucess = true;
    	  }
    	  else last_run_sucess = false;
      }
      if(in[0]==22) {
    	if(last_run_sucess == true) cpu_pointer = in[1];
      }
      if(in[0]==45) {
      	if(Memory.getRegValueOf(in[1])==in[2])last_run_sucess = true;
      	else last_run_sucess = false;
       }
      System.out.println(Memory.AA);
  }
}
