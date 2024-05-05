package basic;

public class Word {
	private String word_target;
	private String word_explain;
	public Word(String target,String explain)
	{
		this.word_explain=explain;
		this.word_target=target;
	}
	public Word()
	{
		this("","");
	}
	public void setWordTarget(String target)
	{
		this.word_target=target;
	}
	public void setWordExplain(String explain)
	{
		this.word_explain=explain;
	}
	public String getWordTarget()
	{
		return word_target;
	}
	public String getWordExplain()
	{
		return word_explain;
	}
}
