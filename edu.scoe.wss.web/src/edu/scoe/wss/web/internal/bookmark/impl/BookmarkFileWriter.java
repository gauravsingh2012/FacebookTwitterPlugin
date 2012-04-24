package edu.scoe.wss.web.internal.bookmark.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class BookmarkFileWriter {

	private static String FILEPATH = ""; //$NON-NLS-1$
	
	public BookmarkFileWriter(String filePath) {
		FILEPATH = filePath;
	}
	
	public void writeURLToHTML(String UrlText) throws IOException{
		Writer output = null;
			File file = new File(FILEPATH);
			output = new BufferedWriter(new FileWriter(file,true));
			initializeHTML(output);
				writeurl(output, UrlText);
				writeNewLine(output);
			
			finalizeHTML(output);
			output.flush();
			output.close();
			
			
			}
	
	private void initializeHTML(Writer output) throws IOException{
		output.write("<html>"); //$NON-NLS-1$
		output.write("<body>"); //$NON-NLS-1$
		
		
	}
	
	private void writeurl(Writer output, String path) throws IOException{
		output.write("<a href=\"" + path + " \">"); //$NON-NLS-1$ //$NON-NLS-2$
		String title = BookmarkTitleExtractor.getPageTitle(path);
		if (title == null)
		{
		output.write(path + "</a>"); //$NON-NLS-1$
		}
		else
		{
		output.write(title + "</a>"); //$NON-NLS-1$
		}
	}
	private void finalizeHTML(Writer output) throws IOException{
		output.write("</body></html>"); //$NON-NLS-1$
	}

	private void writeNewLine(Writer output) throws IOException{
		output.write("<br><br>"); //$NON-NLS-1$
	}
	
	public String getFilePath(){
		return FILEPATH;
	}
	

}
