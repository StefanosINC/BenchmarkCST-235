package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Verse") 

public class Verse implements Serializable {

	
	String BookName = "";
	String ChapterNumber = "";
	int VerseNumber = 0;
	//String text;
	
//	
//	public String getText() {
//		return text;
//	}
//

//
//	public void setText(String text) {
//		this.text = text;
//	}
//


	public Verse(String bookName, String chapterNumber, int verseNumber) {
		super();
		BookName = bookName;
		ChapterNumber = chapterNumber;
		VerseNumber = verseNumber;
	}
	
	

	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getChapterNumber() {
		return ChapterNumber;
	}
	public void setChapterNumber(String chapterNumber) {
		ChapterNumber = chapterNumber;
	}
	public int getVerseNumber() {
		return VerseNumber;
	}
	public void setVerseNumber(int verseNumber) {
		VerseNumber = verseNumber;
	}

	@Override
    public String toString() {
        return String.format("Verse1: " + BookName + " , "
        		+ "ChapterNumber1 " + ChapterNumber + "VerseNumber" + VerseNumber);
        		
    }
	
	
}