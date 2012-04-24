package edu.scoe.wss.web.internal.facebook.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import com.restfb.types.Post;
import com.restfb.types.Post.Comments;

public class FacebookFileWriter {

	private static String FILEPATH = ""; //$NON-NLS-1$
	
	public FacebookFileWriter(String filePath) {
		FILEPATH = filePath;
	}
	
	public void writeFeedsToHTML(FaceBookOperations fboperations) throws IOException{
		Writer output = null;

		File file = new File(FILEPATH);
		output = new BufferedWriter(new FileWriter(file));

		initializeHTML(output);
		for(Post post : fboperations.getFeeds().getData()){
			 String message = post.getMessage();
			 String Id = post.getFrom().getId();
			 String user = post.getFrom().getName();
			 String Name = post.getName();
			 String Desc = post.getDescription();
			 String Link = post.getPicture();
			 Long like = post.getLikesCount();
			 Date datepost= post.getUpdatedTime();
			 Comments comment = post.getComments();
			 
			 String likec = "Number of Likes : "; //$NON-NLS-1$
			 String commentc = "Number of Comments Made By Other Facebook Users : "; //$NON-NLS-1$
			 String walldate = "PUBLISHED ON : "; //$NON-NLS-1$
			 
			 writeImage(output,Id);
			 writeText(output,user);
			 writeNewLine(output);
			 if (Name!=null)
			 {
				 writeText(output, Name);
				 
				if (Desc == null)
				{
					if (Link!= null)
				 	{
					 	writeImage1(output,Link);
				 	}
					writeNewLine(output);
					writeText(output,walldate);
					writeText(output, datepost.toString());
					 writeNewLine(output);
					 separator(output);
				}
			 }
			 if (Desc!=null)
			 {
				 writeText(output,Desc);
				 if (Link!= null)
				 	{
					 	writeImage1(output,Link);
				 	}
				 writeNewLine(output);
				 writeText(output,walldate);
				 writeText(output, datepost.toString());
				 writeNewLine(output);
				 separator(output);
			}
			
			  if(message== null) continue;
			 writeText(output, message);
			 writeNewLine(output);
			 if (like != null)
			 {
				 writeText(output,likec);
				 writeText(output,like.toString());
				 writeNewLine(output);
			 }
			 if (comment != null)
			 {
				 Long commentcount = post.getComments().getCount();
				 writeText(output,commentc);
				 writeText(output,commentcount.toString());
				 writeNewLine(output);
			 }
			 writeText(output,walldate);
			 writeText(output, datepost.toString());
			 writeNewLine(output);
			 separator(output);
			
		}
		
		
		for(Post post : fboperations.getFeeds1().getData()){
			 String message = post.getMessage();
			 String Id = post.getFrom().getId();
			 String user = post.getFrom().getName();
			 String Name = post.getName();
			 String Desc = post.getDescription();
			 String Link = post.getPicture();
			 Long like = post.getLikesCount();
			 Date datepost= post.getUpdatedTime();
			 Comments comment = post.getComments();
			 
			 String likec = "Number of Likes : "; //$NON-NLS-1$
			 String commentc = "Number of Comments Made By Other Facebook Users : "; //$NON-NLS-1$
			 String walldate = "PUBLISHED ON : "; //$NON-NLS-1$
			 
			 writeImage(output,Id);
			 writeText(output,user);
			 writeNewLine(output);
			 if (Name!=null)
			 {
				 writeText(output, Name);
				 
				if (Desc == null)
				{
					if (Link!= null)
				 	{
					 	writeImage1(output,Link);
				 	}
					writeNewLine(output);
					writeText(output,walldate);
					writeText(output, datepost.toString());
					 writeNewLine(output);
					 separator(output);
				}
			 }
			 if (Desc!=null)
			 {
				 writeText(output,Desc);
				 if (Link!= null)
				 	{
					 	writeImage1(output,Link);
				 	}
				 writeNewLine(output);
				 writeText(output,walldate);
				 writeText(output, datepost.toString());
				 writeNewLine(output);
				 separator(output);
			}
			
			  if(message== null) continue;
			 writeText(output, message);
			 writeNewLine(output);
			 if (like != null)
			 {
				 writeText(output,likec);
				 writeText(output,like.toString());
				 writeNewLine(output);
			 }
			 if (comment != null)
			 {
				 Long commentcount = post.getComments().getCount();
				 writeText(output,commentc);
				 writeText(output,commentcount.toString());
				 writeNewLine(output);
			 }
			 writeText(output,walldate);
			 writeText(output, datepost.toString());
			 writeNewLine(output);
			 separator(output);
			
		}
		finalizeHTML(output);
		output.flush();
		output.close();
		

	}
	
	private void initializeHTML(Writer output) throws IOException{
		output.write("<html>"); //$NON-NLS-1$
		output.write("<body>"); //$NON-NLS-1$
		output.write("<b>"); //$NON-NLS-1$
	}
	
	private void finalizeHTML(Writer output) throws IOException{
		output.write("</b></body></html>"); //$NON-NLS-1$
	}
	
	private void writeImage(Writer output, String imagePath) throws IOException{
		output.write("<img src=\"https://graph.facebook.com/" + imagePath + "/picture\""); //$NON-NLS-1$ //$NON-NLS-2$
		output.write("alt=\"some_text\"/>"); //$NON-NLS-1$
		
	}
	private void writeImage1(Writer output, String imagePath1) throws IOException{
		output.write("<img src=\"" + imagePath1 + " \" "); //$NON-NLS-1$ //$NON-NLS-2$
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
	private void separator(Writer output) throws IOException{
		output.write("<hr />"); //$NON-NLS-1$
	}
	
	public String getFilePath(){
		return FILEPATH;
	}
	
}
