package edu.scoe.wss.web.internal.bookmark.impl;

import java.io.IOException;

import edu.scoe.wss.web.Activator;

public class BookmarkFileManager {
	
	private static BookmarkFileManager manager;
	
	public static BookmarkFileManager getManager(){
		if(manager == null){
			manager = new BookmarkFileManager();
		}
		return manager;
	}
	
	public static final String bookmarkHTMLFile = "bookmark.html"; //$NON-NLS-1$
	
	private String filePath = Activator.getDefault().getStateLocation().append(bookmarkHTMLFile).toOSString();
	public String getFilePath(){
		return filePath;
	}

	public void writeBookmarkToFile(String text) throws IOException{
		BookmarkFileWriter writer = new BookmarkFileWriter(BookmarkFileManager.getManager().getFilePath());
		writer.writeURLToHTML(text);
	}
}
