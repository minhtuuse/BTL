package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {
	private List<Word> list =new ArrayList<Word>();
	void setList(List<Word> list)
	{
		this.list=list;
	}
	List<Word> getList()
	{
		return list;
	}
}

