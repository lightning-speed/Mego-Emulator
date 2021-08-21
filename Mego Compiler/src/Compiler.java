
public class Compiler {
   public static String FC="";
   public static String out = "";
   public static String out_file_text = "";
   public static void startCompilation() {
	   tokanise();
	   String all[] = FC.split("\n");
	   for(int i = 0;i<all.length;i++)
	   compile(all[i]);
	   FileManager.write(Main.out, out_file_text);
	   System.out.print(out_file_text);
   }
   public static void tokanise() {
	   for(int i = 0;i<10;i++)
	   FC = FC.replace("  "," ");
	   for(int i = 0;i<10;i++)
	   FC = FC.replace("\n "," \n");
	   for(int i = 0;i<10;i++)
	   FC = FC.replace("\n\n"," \n");
   }
   public static void compile(String line) {
	   line = line.replace("movr", ""+(char)1);
	   line = line.replace("addr", ""+(char)2);
	   line = line.replace("subr", ""+(char)3);
	   line = line.replace("mulr", ""+(char)4);
	   line = line.replace("divr", ""+(char)5);
	   line = line.replace("andr", ""+(char)6);
	   line = line.replace("orr",  ""+(char)7);
	   line = line.replace("xorr", ""+(char)8);
	   line = line.replace("mov", ""+(char)11);
	   line = line.replace("add", ""+(char)12);
	   line = line.replace("sub", ""+(char)42);
	   line = line.replace("mul", ""+(char)14);
	   line = line.replace("div", ""+(char)15);
	   line = line.replace("and", ""+(char)16);
	   line = line.replace("or", ""+(char)17);
	   line = line.replace("xor", ""+(char)18);
	   line = line.replace("push", ""+(char)19);
	   line = line.replace("pop", ""+(char)20);
	   line = line.replace("jmp", ""+(char)21);
	   line = line.replace("jnz", ""+(char)22);
	   line = line.replace("inb", ""+(char)23);
	   line = line.replace("outb", ""+(char)24);
	   line = line.replace("nop", ""+(char)25);
	   line = line.replace("int", ""+(char)26);
	   line = line.replace("dec",""+(char)44);
	   line = line.replace("equ",""+(char)45);
	   line = line.replace("min",""+(char)46);
	   line = line.replace("aa", ""+(byte)30);
	   line = line.replace("ab", ""+(byte)31);
	   line = line.replace("ac", ""+(byte)32);
	   line = line.replace("ad", ""+(byte)33);
	   line = line.replace("ae", ""+(byte)34);
	   line = line.replace("af", ""+(byte)35);
	   line = line.replace("ag", ""+(byte)36);
	   line = line.replace("ah", ""+(byte)37);
	   line = line.replace("ai", ""+(byte)38);
	   line = line.replace("aj", ""+(byte)39);
	   line = line.replace("ak", ""+(byte)40);
	   line = line.replace("al", ""+(byte)41);
       String out_line = line.split(" ")[0];
       line = line.replace("'", "");
	   try {
		   if(!(line.split(" ")[1].charAt(0)>='0'&&line.split(" ")[1].charAt(0)<='9'))
		   out_line+=line.split(" ")[1];
	       if(line.split(" ")[1].charAt(0)>='0'&&line.split(" ")[1].charAt(0)<='9')out_line+=(char)Integer.parseInt(line.split(" ")[1]);
	   }
	   catch(Exception e) {
		   
	   }
	   try {
		   if(!(line.split(" ")[2].charAt(0)>='0'&&line.split(" ")[2].charAt(0)<='9'))
			   out_line+=line.split(" ")[2];
	   if(line.split(" ")[2].charAt(0)>='0'&&line.split(" ")[2].charAt(0)<='9')out_line+=(char)Integer.parseInt(line.split(" ")[2]);
	   }
	   catch(Exception e) {

	   }
	   out_line = out_line.replace((char)0,(char)101);
	   out_file_text += out_line +((char)43);
   }
}