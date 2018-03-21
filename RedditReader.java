
import java.io.*;
public class RedditReader {
	
	
	String fileToAnalyze;
	
	
	RedditReader(){
		fileToAnalyze="";
				   }
	
	//detect if Russia is in post
	boolean detectRussia(String linetoAnalyze) {
		String Russia= "russia";
		String Putin="putin";
		String Krima="krima";
		String Moscow="moscow";
		String WikiLeaks="wikileaks";
		linetoAnalyze=linetoAnalyze.toLowerCase();
		
		if(linetoAnalyze.contains(Russia)) {
			//System.out.println("Detect's Russia");
			return true;
										   }
		else if(linetoAnalyze.contains(Putin)) {
			return true;
											   }
		else if(linetoAnalyze.contains(Krima)) {
			return true;
											   }				
		else if(linetoAnalyze.contains(Moscow)) {
			return true;
												}
		else if(linetoAnalyze.contains(WikiLeaks)) {
			return true;
												   }
		else {
			return false;
			 }	
		}
	
	//count how many times russia occurs in posts
	int countRussia(String fileToRead) {
		int count=0;
		try {
			FileReader myFileReader=new FileReader(fileToRead);
			//System.out.println("I was able to successfully open your file.");
			BufferedReader myBufferReader=new BufferedReader(myFileReader);
			//System.out.println("Ready to start buffering");
			String line= "";

			while(line!= null) {
				
				line= myBufferReader.readLine();
				if(detectRussia(line)) {
					count=count+1;
				}
			}
		}		
		catch(Exception ex) {
			System.out.println("Error in conunt RUssia");
			}
		return count;	
	}

	
	
	//Read Reddit files
	void readRedditFile(String fileToRead) {
		System.out.println("Ready to read:  "+fileToRead);
		
		try {
			FileReader myFileReader=new FileReader(fileToRead);
			//System.out.println("I was able to successfully open your file.");
			BufferedReader myBufferReader=new BufferedReader(myFileReader);
			//System.out.println("Ready to start buffering");
			String line= "";
						
			while(line!= null) {
				line= myBufferReader.readLine();
				if(detectRussia(line)) {
					System.out.println(line);
					}
				}
			}
		
		catch(Exception ex) {
			System.out.println("Error in readRedditFile");			
		}		
	}
	
	//Take Two iputs and check if in line of file
	double doubleInputCompare(String FiletoAnalyze, String Input1, String Input2) {
		
		try {
			FileReader myFileReader1=new FileReader(FiletoAnalyze);
			FileReader myFileReader2=new FileReader(FiletoAnalyze);
			BufferedReader myBufferReader1=new BufferedReader(myFileReader1);
			BufferedReader myBufferReader2=new BufferedReader(myFileReader2);
			String line= "";
			Input1=Input1.toLowerCase();
			Input2=Input2.toLowerCase();
			
			
			int n=0;
			int m=0;
			int z=0;
			double total=0;
			
			int ArraySize= ArraySizer(FiletoAnalyze);
			
			boolean [] CompareArray1= new boolean[ArraySize];
			boolean [] CompareArray2= new boolean[ArraySize];
			
			
			while(ArraySize > n) {
				n=n+1;
				line= myBufferReader1.readLine();
				if (line!=null){	
					if( compareString(Input1, line) ) {
						CompareArray1[n]=true;
					}
					else {
						CompareArray1[n]=false;
					}
				}					
			}
			
			while(ArraySize > m) {
				m=m+1;
				line=myBufferReader2.readLine();				
				if (line != null) {
				if(compareString(Input2, line)) {
					CompareArray2[m]=true;
				}
				else {
					CompareArray2[m]=false;
				}	
				}
			}				
			while(ArraySize > z) {
				if(CompareArray1[z]) {
					if(CompareArray2[z]) {
						total=total+1;
					}					
				}
				z=z+1;
			}				
			total= total/ArraySize;
			total= total*100;
			
			return total;
		}
		
		catch(Exception ex) {
			System.out.println("Error on double input");
			return -1;
		}
		
		
	}
	
	//find if input is present in string
	
	boolean compareString(String Input, String line) {		
		line=line.toLowerCase();
		Input=Input.toLowerCase();		
		if(line.contains(Input)) {
			return true;
		}		
		else {
			return false;			
		}		
	}
	
	int ArraySizer(String FileToAnalyze) {
		try {
			FileReader myFileReader=new FileReader(FileToAnalyze);
			BufferedReader myBufferReader=new BufferedReader(myFileReader);
			String line= "";
			int Arraycounter=0;
			
			while(line!= null) {	
				line= myBufferReader.readLine();
				Arraycounter=Arraycounter+1;
				}	
			return Arraycounter;
			}
		
		catch(Exception ex) {
			System.out.println("Error on array sizer");
			return 0;			
		}
	}
	//output int of how many times a certain input occurs in file
int Count(String FileToAnalyze, String input) {
	int n = 0;
	try {
	FileReader myFileReader=new FileReader(FileToAnalyze);	
	BufferedReader myBufferReader=new BufferedReader(myFileReader);	
	RedditReader myreader= new RedditReader();	
	String line= "";
	
	while(line != null) {		
		line=myBufferReader.readLine();		
		if (line != null) {
			if(myreader.compareString(input, line)) {
				n=n+1;				
			}		
		}
	}
	return n;
	}
	catch(Exception ex) {
		System.out.println("Error on Count");
		return -1;		
	}
	
}

}
