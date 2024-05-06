package basic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DictionaryCommandline {
	DictionaryManagement dictionaryManagement=new DictionaryManagement();
	private List<Word> words = new ArrayList<Word>();
	public void setList(List<Word>list)
	{
		this.words=list;
	}
	public void showAllWords()
	{
		Collections.sort(words,(w1,w2)->w1.getWordTarget().compareToIgnoreCase(w2.getWordTarget()));
		for(Word word:words)
		{
			System.out.println(word.getWordTarget()+" : "+word.getWordExplain());
		}
	}
	public void dictionaryBasic()
	{
		dictionaryManagement.insertFromCommandline(words);
		showAllWords();
	}
	public void dictionarySearcher()
	{
		List<Word> allWords=new ArrayList<Word>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("nhap vao tu ban muon tim");
		String wordString=scanner.nextLine();
		for(Word word:words)
		{
			if(word.getWordTarget().startsWith(wordString))
			{
				allWords.add(word);
			}
		}
		for(Word word:allWords)
		{
			System.out.println(word.getWordTarget());
		}
	}
	public void dictionaryExportToFile()
	{
		BufferedWriter bufferedWriter=null;
		try {
			File file=new File("src/main/java/output_file");
			FileWriter fileWriter=new FileWriter(file);
			bufferedWriter= new BufferedWriter(fileWriter);
			for(Word word :words)
			{
				bufferedWriter.write(word.getWordTarget()+":"+word.getWordExplain());
				bufferedWriter.newLine();
			}
			System.out.println("da xuat xong file");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(bufferedWriter!=null)
				{
					bufferedWriter.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void printaction()
	{
		System.out.println("0 : Exit");
		System.out.println("1 : Add");
		System.out.println("2 : Remove");
		System.out.println("3 : Update");
		System.out.println("4 : Display");
		System.out.println("5 : Lookup");
		System.out.println("6 : Search");
		System.out.println("7 : Game");
		System.out.println("8 : Import from file");
		System.out.println("9 : Export to file");
		System.out.println("enter your action");
	}
	public void dictionaryAdvanced()
	{	
		Scanner scanner = new Scanner(System.in);
		int action=999;
		while(action!=0)
		{
			printaction();
			action=scanner.nextInt();
			scanner.nextLine();
			if(action<0||action>9)
			{
				System.out.println("Action not supported");
			}
			else if(action==0)
			{
				System.out.println("exit");
				break;
			}
			else if(action==1)
			{
				dictionaryManagement.insertFromCommandline(words);
			}
			else if (action==2) 
			{
				System.out.println("enter the word need to delete");
				String wordString=scanner.nextLine();
				dictionaryManagement.RemoveWord(words, wordString);
			}
			else if (action==3)
			{
				System.out.println("enter the word need to update");
				String word=scanner.nextLine();
				System.out.println("enter the meaning");
				String meaning=scanner.nextLine();
				dictionaryManagement.UpdateWord(words, word, meaning);
			}
			else if (action==4)
			{
				showAllWords();
			}
			else if (action==5) 
			{
				System.out.println("enter the word need to search");
				String wordString=scanner.nextLine();
				System.out.println(dictionaryManagement.lookup(wordString, words));
			}
			else if (action==6)
			{
				dictionarySearcher();
			}
			else if (action==7) 
			{
				System.out.println("tinh nang chua duoc ho tro");
			}
			else if (action==8)
			{
				dictionaryManagement.insertFromFile(words);
			}
			else if (action==9) 
			{
				dictionaryExportToFile();
			}
		}
	}
}

