import java.io.File;

public class Main {
	public static File inFile;
	public static String out = "";
	public static void main(String args[]) {
		try {
			out = args[1];
			if(!new File(args[0]).exists()||new File(args[0]).isDirectory()) {
				System.out.println("File Does not exists");
			}
			else {
				inFile = new File(args[0]);
				Compiler.FC = FileManager.read(args[0]);
				Compiler.startCompilation();
			}
		}
		catch(Exception e) {
			System.out.println("args:<input file> <output file>");
		}
	}
}
