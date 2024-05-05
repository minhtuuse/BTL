package basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
	Scanner scanner=new Scanner(System.in);
	public void insertFromCommandline(List<Word> list)
	{
		System.out.println("NHAP SO LUONG TU: ");
		int number=scanner.nextInt();
        scanner.nextLine(); // Consume newline character
		for(int i=1;i<=number;i++)
		{
			System.out.println("nhap tu tieng anh: ");
			String word_targertString=scanner.nextLine();
			System.out.println("nhap nghia tieng viet: ");
			String word_explainString=scanner.nextLine();
			Word word=new Word(word_targertString, word_explainString);
			list.add(word);
		}
	}
	public void insertFromFile(List<Word> list) {
	    try {
	        File file = new File("D:\\OOP\\DIC_\\src\\main\\java\\source.txt");
	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String word_targetString;
	        String word_explainString;
	        while ((word_targetString = bufferedReader.readLine())!= null&&(word_explainString=bufferedReader.readLine())!= null) {
	            	
	                Word word = new Word(word_targetString, word_explainString);
	                list.add(word);
	        }
	        bufferedReader.close();
	        System.out.println("NHAP TU TEP THANH CONG");
	    }
	    catch (Exception e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	}
	public String lookup(String word,List<Word> list)
	{
		Collections.sort(list,(w1,w2)->w1.getWordTarget().compareToIgnoreCase(w2.getWordTarget()));
		int start=0;
		int end=list.size();
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(list.get(mid).getWordTarget().compareToIgnoreCase(word)==0)
			{
				return list.get(mid).getWordExplain();
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))>0)
			{
				end=mid-1;
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))<0)
			{
				start=mid+1;
			}
		}
		return "KHONG CO TRONG TU DIEN";
	}
	public void RemoveWord(List<Word> list,String word)
	{
		Collections.sort(list,(w1,w2)->w1.getWordTarget().compareToIgnoreCase(w2.getWordTarget()));
		int start=0;
		int end=list.size();
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(list.get(mid).getWordTarget().compareToIgnoreCase(word)==0)
			{
				list.remove(mid);
				System.out.println("Word has been deleted");
				return;
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))>0)
			{
				end=mid-1;
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))<0)
			{
				start=mid+1;
			}
		}
		System.out.println("List dont have this word");
		return;
	}
	public void UpdateWord(List<Word> list,String word,String meaning)
	{
		Collections.sort(list,(w1,w2)->w1.getWordTarget().compareToIgnoreCase(w2.getWordTarget()));
		int start=0;
		int end=list.size();
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(list.get(mid).getWordTarget().compareToIgnoreCase(word)==0)
			{
				list.get(mid).setWordExplain(meaning);
				System.out.println("Word has been update");
				return;
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))>0)
			{
				end=mid-1;
			}
			else if(((list.get(mid).getWordTarget()).compareToIgnoreCase(word))<0)
			{
				start=mid+1;
			}
		}
		System.out.println("List dont have this word");
		return;
	}
}	

