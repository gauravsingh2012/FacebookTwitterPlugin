package edu.scoe.wss.web.internal.views;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import twitter4j.TwitterException;

import edu.scoe.wss.web.Activator;
import edu.scoe.wss.web.internal.facebook.impl.FaceBookOperations;
import edu.scoe.wss.web.internal.facebook.impl.FacebookFileWriter;

public class FacebookViewPart extends ViewPart {
	private Browser browser;
	private static final String facebookHTMLFile = "facebook.html"; //$NON-NLS-1$
	private String API_KEY = "164302190291616"; //$NON-NLS-1$
	private String Secret = "c5e50a4242da72f8fb74bf8631c1d84d"; //$NON-NLS-1$
	final private static FaceBookOperations fbOperations = new FaceBookOperations();
	String Token="";
	String Search="";
	
	public FacebookViewPart() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		parent.setLayout(layout);
		// Button login = new Button(parent, SWT.PUSH);
		// login.setText("Login");

		final Composite compositeForStatusUpdate = new Composite(parent,
				SWT.NONE);
		GridLayout layoutUpdateStatus = new GridLayout();
		layoutUpdateStatus.numColumns = 2;
		compositeForStatusUpdate.setLayout(layoutUpdateStatus);
		final Text location = new Text(compositeForStatusUpdate, SWT.BORDER);

		GridData layoutData1 = new GridData(300, 20);
		layoutData1.grabExcessHorizontalSpace = true;
		layoutData1.grabExcessVerticalSpace = false;
		location.setLayoutData(layoutData1);

		Button update = new Button(compositeForStatusUpdate, SWT.PUSH);
		update.setText("Update Status"); //$NON-NLS-1$

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

		browser = new Browser(parentBrowser, SWT.None);

		layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.FILL;
		browser.setLayoutData(layoutData);
		
		Listener updateListener = new Listener() {
			public void handleEvent(Event event) {
					String updatemessage = location.getText();
					if(updatemessage!=null && updatemessage.length()>0){
						fbOperations.getmessage(updatemessage);
						try {
							writeToFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
			}
		};
		
	    browser.addProgressListener(new ProgressListener() {
	        public void changed(ProgressEvent event) {
	            if (event.total == 0) return;                            
	                
	        }
	        public void completed(ProgressEvent event) {
	        	Search = browser.getUrl();
	        	int index = Search.indexOf('f');
	        	if(index == 0)
	    		{
	    			location.setText(""); //$NON-NLS-1$
	    		}
	    		else
	    		{
	    			location.setText(Search);
	    		}
	      
	        }
	      });
	    
		update.addListener(SWT.MouseDown, updateListener);
		update.addListener(SWT.KeyUp, updateListener);
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void handleLoginClick() {
		final Shell pinDialogShell = new Shell();
		final Label enterPINLabel;
		final Text pinText;
		final Label enterPINLabel1;
		final Text pinText1;
		pinDialogShell.setLayout(new GridLayout(2, false));
		pinDialogShell.setText("Login form"); //$NON-NLS-1$
		enterPINLabel=new Label(pinDialogShell, SWT.NULL);
		enterPINLabel.setText("Enter Code After =: "); //$NON-NLS-1$
			
		enterPINLabel1=new Label(pinDialogShell, SWT.NULL);
		enterPINLabel1.setText("Enter AccessToken: "); //$NON-NLS-1$

		pinText = new Text(pinDialogShell, SWT.SINGLE | SWT.BORDER);
		pinText.setText(""); //$NON-NLS-1$
		pinText1 = new Text(pinDialogShell, SWT.SINGLE | SWT.BORDER);
		pinText.setText(""); //$NON-NLS-1$
	
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				Button pinDialogSubmitButton=new Button(pinDialogShell,SWT.PUSH);
				pinDialogSubmitButton.setText("Submit Code"); //$NON-NLS-1$
				Button pinDialogSubmitButton1=new Button(pinDialogShell,SWT.PUSH);
				pinDialogSubmitButton1.setText("Submit Access Token"); //$NON-NLS-1$
				
				pinDialogSubmitButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
				String p=pinText.getText();
				//AccessToken accessToken = null;
				if(p==""){ //$NON-NLS-1$
					MessageBox messageBox = new MessageBox(pinDialogShell, SWT.OK |
							SWT.ICON_WARNING |SWT.CANCEL);
					messageBox.setMessage("Enter the Code After = in the Retrieved URL"); //$NON-NLS-1$
					messageBox.open();
				}
				else{
					String URL1 = "https://graph.facebook.com/oauth/access_token?client_id=" + API_KEY + "&redirect_uri=http://www.facebook.com/connect/login_success.html&client_secret="+Secret+"&code="+p; //$NON-NLS-1$
					browser.setUrl(URL1);
				}
				}
				});
				
				pinDialogSubmitButton1.addListener(SWT.Selection, new Listener() {
					public void handleEvent(Event event) {
					String p1=pinText1.getText();
					//AccessToken accessToken = null;
					if(p1==""){ //$NON-NLS-1$
						MessageBox messageBox = new MessageBox(pinDialogShell, SWT.OK |
								SWT.ICON_WARNING |SWT.CANCEL);
						messageBox.setMessage("Enter the Access Token"); //$NON-NLS-1$
						messageBox.open();
					}
					else{
						Token = fbOperations.login(p1);
						try {
							writeToFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					pinDialogShell.close();
						}
					});
					
		pinText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		pinDialogShell.pack();
		if(Token == ""){
			String URL = "https://www.facebook.com/dialog/oauth?client_id=" + API_KEY + "&redirect_uri=http://www.facebook.com/connect/login_success.html& scope=publish_stream,offline_access,create_event,read_stream";
			browser.setUrl(URL);
			pinDialogShell.open();
		}
		else
			try {
				writeToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			}
		});
	}

	public void facebooklogin() {
		handleLoginClick();
	}

	private void writeToFile() throws IOException {
		IPath path = Activator.getDefault().getStateLocation()
		.append(facebookHTMLFile);
		FacebookFileWriter writer = new FacebookFileWriter(path.toOSString());
		writer.writeFeedsToHTML(fbOperations);
		browser.setUrl(writer.getFilePath());
	}

	public void refresh() throws IOException {
		writeToFile();
	}

}
