import java.util.Scanner;
import java.io.*;

public class TesterReddit {
	public static void main(String[] args) {
		
		//Declare Variables
		
		String fileName="redditPosts.txt";
		String fileAuthors="redditAuthors.txt";
		boolean Exit = true;	
			RedditReader myreader= new RedditReader();
			Scanner scan = new Scanner(System.in);
			String one="1";
			String two="2";
			String three="3";
			String four="4";
			String five="5";
			String nine="9";
			
			
		//Intro
		System.out.println("Hello, I am DA BOT. (Data Analysis BOT)  I can help you analyze data.");
		System.out.println("I will help you through a menu system, you will be able to input  number to make a selection of the given menu.");
					
			//Main Loop
			while(Exit) {
				String SearchSelection=null;
				System.out.println("\n\n\nThis is a list of available tools I have available to me:");
				System.out.println("Please input the given number of the analysis you want to perform:");
				System.out.println("1) Percentage of times two words appear in a single post of the given data.");
				System.out.println("2) Percentage of times a single word appears in the posts of the given data.");
				System.out.println("3) Percentage of times a single word appears in the name of the authors of the posts.");
				System.out.println("4) How many times a certain word occurs in the set of posts.");
				System.out.println("5) How many times a certain word occurs in the set of Authors of the posts.");
				System.out.println("9) Exits the program.");
				//Recieve Search Selection
				SearchSelection=scan.next();
				
				//use search selection to determine code to run
				if (SearchSelection.equals(one)) {
					System.out.println("Input the first word to be searched for:");
					String doubleinput1=scan.next();
					System.out.println("Input the second word to be searched for:");
					String doubleinput2=scan.next();
					double doubleinputtotal=(myreader.doubleInputCompare(fileName, doubleinput1, doubleinput2));
					System.out.println("The Words: " + doubleinput1+" "+"&" +" " + doubleinput2 +" " + "occur together in the given posts ");
					System.out.printf("%.2f percent of the time.", doubleinputtotal);
					}				
				if (SearchSelection.equals(two)) {
					System.out.println("Input The word to be searched for:");
					String singleinput1=scan.next();
					double singleinputtotal=(myreader.doubleInputCompare(fileName, singleinput1, singleinput1));
					System.out.println("The Word: " + singleinput1+" "+"occurs the given posts ");
					System.out.printf("%.2f percent of the time.", singleinputtotal);
					}
				if (SearchSelection.equals(three)) {
					System.out.println("Input The word to be searched for:");
					String singleauthor=scan.next();
					double singleauthortotal=(myreader.doubleInputCompare(fileAuthors, singleauthor, singleauthor));
					System.out.println("The Word: " + singleauthor+" "+"occurs the given Author's names ");
					System.out.printf("%.2f percent of the time.", singleauthortotal);
					}
				if (SearchSelection.equals(four)) {
					System.out.println("Input The word to be searched for:");
					String countinput=scan.next();
					int counttotal=myreader.Count(fileName, countinput);
					System.out.println("The word " + countinput + " occurs");
					System.out.println(counttotal + " many times.");					
					}
				if (SearchSelection.equals(five)) {
					System.out.println("Input The word to be searched for:");
					String searchinput=scan.next();
					int searchtotal=myreader.Count(fileAuthors, searchinput);
					System.out.println("The word " + searchinput + " occurs");
					System.out.println(searchtotal + " many times.");					
					}	
				if (SearchSelection.equals(nine)) {
					Exit=false;
					}
				
			}
			//Outro
			System.out.println("\nThanks for using me, I hope my tools were useful.  If you ever want to use more DataAnalysis please feel free to try me again.");
	}
}
