package edu.scoe.wss.web.internal.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class BrowserViewPart extends ViewPart {
	private Browser browser;
	public String bkmarkUrl;
	

	public BrowserViewPart() {
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

		
		final Composite compositeForURL = new Composite(parent, SWT.NONE);
		GridLayout layoutUpdateStatus = new GridLayout();
		layoutUpdateStatus.numColumns = 2;
		compositeForURL.setLayout(layoutUpdateStatus);
		final Text location = new Text(compositeForURL, SWT.BORDER);

		GridData layoutData1 = new GridData(300,20);
		layoutData1.grabExcessHorizontalSpace = true;
		layoutData1.grabExcessVerticalSpace = false;
		location.setLayoutData(layoutData1);

		Button go = new Button(compositeForURL, SWT.PUSH);
		go.setText("GO"); //$NON-NLS-1$

		parent.setSize(300, 300);

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
		browser.setUrl("http://www.google.co.in"); //$NON-NLS-1$
		
		Listener goListener = new Listener() {
			public void handleEvent(Event event) {
				
				browser.setUrl(location.getText());
			}
		};
	
	    browser.addProgressListener(new ProgressListener() {
	        public void changed(ProgressEvent event) {
	            if (event.total == 0) return;                            
	                
	        }
	        public void completed(ProgressEvent event) {
	        location.setText(browser.getUrl());
	        }
	      });
		go.addListener(SWT.MouseDown, goListener);
		go.addListener(SWT.KeyUp, goListener);
		location.addListener(SWT.DefaultSelection, goListener)	;
		 
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public void refresh() {
		browser.refresh();
	}
	public void back() {
		browser.back();
	}
	public void forward() {
		browser.forward();
	}
	public void stop() {
		browser.stop();
	}
	public String bookmark() {
		bkmarkUrl = browser.getUrl();
		return bkmarkUrl;
	}
}
