package edu.scoe.wss.web.internal.views;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import edu.scoe.wss.web.internal.bookmark.impl.BookmarkFileManager;


public class BookmarkViewPart extends ViewPart {

	private Browser browser;
	
	public String text;
	
	File f = new File(BookmarkFileManager.getManager().getFilePath());

	public BookmarkViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

		GridLayout layout = new GridLayout();
		layout.numColumns =1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		parent.setLayout(layout);

		final Composite parentBrowser = new Composite(parent, SWT.BORDER);
		GridData layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.FILL;
		parentBrowser.setLayoutData(layoutData);
		
		layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		parentBrowser.setLayout(layout);

		browser = new Browser(parentBrowser,SWT.None);
		
		layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.FILL;
		browser.setLayoutData(layoutData);
		
		if (f.exists())
		{
		browser.setUrl(BookmarkFileManager.getManager().getFilePath());
		}

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
	public void retrieveURL(String TextURL) throws IOException {
		writeToFile();
	}
	
	private void writeToFile() throws IOException {
		BookmarkFileManager.getManager().writeBookmarkToFile(text);
		browser.setUrl(BookmarkFileManager.getManager().getFilePath());
	}
	
	public void refresh() throws IOException {
		if (f.exists())
		{
		browser.setUrl(BookmarkFileManager.getManager().getFilePath());
		}
		//browser.refresh();
	}
	
	public void clear() {
		if (f.exists())
		{
			f.delete();
		}
		browser.setUrl("about:blank"); //$NON-NLS-1$
	}

}
