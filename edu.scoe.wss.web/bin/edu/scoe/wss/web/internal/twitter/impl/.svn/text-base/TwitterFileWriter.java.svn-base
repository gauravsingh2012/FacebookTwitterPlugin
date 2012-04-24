package edu.scoe.wss.web.internal.twitter.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterFileWriter {

	private static String FILEPATH = ""; //$NON-NLS-1$
	
	public TwitterFileWriter(String filePath) {
		FILEPATH = filePath;
	}
	
	public void writeFeedsToHTML(TwitterOperationsHandler operations){
		Writer output = null;
		try{
			File file = new File(FILEPATH);
			output = new BufferedWriter(new FileWriter(file));
			
			List<Status> statuses = operations.getTimeLines();
			initializeHTML(output);
			for (Status status : statuses) {
				URL imageurl;
				imageurl=status.getUser().getProfileImageURL();
				writeImage(output, imageurl.toString());
				writeText(output, status.getUser().getName() +  "  : " + //$NON-NLS-1$
						status.getText());
				writeNewLine(output);
			}
			
			finalizeHTML(output);
						
		} catch (TwitterException te) {
			if(401 == te.getStatusCode()){
				System.out.println("Unable to get the access token."); //$NON-NLS-1$
			}else{
				te.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(output!=null){
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void initializeHTML(Writer output) throws IOException{
		output.write("<html>"); //$NON-NLS-1$
		output.write("<body>"); //$NON-NLS-1$
		output.write("<b>"); //$NON-NLS-1$
		output.write("<marquee HEIGHT=500  behavior=\"scroll\" direction=\"up\" scrollamount=\"3\">"); //$NON-NLS-1$
	}
	
	private void finalizeHTML(Writer output) throws IOException{
		output.write("</marquee></b></body></html>"); //$NON-NLS-1$
	}
	
	private void writeImage(Writer output, String imagePath) throws IOException{
		output.write("<img src=\"" + imagePath + " \" "); //$NON-NLS-1$ //$NON-NLS-2$
		output.write("alt=\"some_text\"/>"); //$NON-NLS-1$
	}
	
	private void writeText(Writer out, String text) throws IOException{
		int index = text.indexOf('<');
		if(index == -1)
		{
			out.write(text);
		}
		else
		{
			String strreplace="&#60;"; //$NON-NLS-1$
			text = text.replaceAll("<", strreplace); //$NON-NLS-1$
			out.write(text);
		}
	}
	
	private void writeNewLine(Writer output) throws IOException{
		output.write("<br><br>"); //$NON-NLS-1$
	}
	
	public String getFilePath(){
		return FILEPATH;
	}
	
}
