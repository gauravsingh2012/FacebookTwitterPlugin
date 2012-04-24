package edu.scoe.wss.web.internal.views;

import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
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

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import edu.scoe.wss.web.Activator;
import edu.scoe.wss.web.internal.twitter.impl.TwitterAccountManager;
import edu.scoe.wss.web.internal.twitter.impl.TwitterFileWriter;
import edu.scoe.wss.web.internal.twitter.impl.TwitterOperationsHandler;

/**
 * The class for instantiating and populating the Twitter view.
 * @author Gaurav
 *
 */
public class TwitterViewPart extends ViewPart {
	private TwitterAccountManager tManager = new TwitterAccountManager();
	private Browser browser;
	public String text=""; //$NON-NLS-1$

	public static final String twitterHTMLFile = "twitter.html"; //$NON-NLS-1$
	
	public TwitterViewPart() {
	}

	@Override
	public void createPartControl(final Composite parent)  {

		GridLayout layout = new GridLayout();
		layout.numColumns =1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		parent.setLayout(layout);
//		Button login = new Button(parent, SWT.PUSH);
//		login.setText("Login");

		
		final Composite compositeForStatusUpdate = new Composite(parent, SWT.NONE);
		GridLayout layoutUpdateStatus = new GridLayout();
		layoutUpdateStatus.numColumns = 2;
		compositeForStatusUpdate.setLayout(layoutUpdateStatus);
		final Text location = new Text(compositeForStatusUpdate, SWT.BORDER);

		GridData layoutData1 = new GridData(300,20);
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

		browser = new Browser(parentBrowser,SWT.None);
		
		layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.FILL;
		browser.setLayoutData(layoutData);

		Listener updateListener = new Listener() {
			public void handleEvent(Event event) {
				Twitter twitter = tManager.getTwitter();
				Status twitterStatus;
				try {
					twitterStatus = twitter.updateStatus(location.getText());
					writeToFile();
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		};
		update.addListener(SWT.MouseDown, updateListener);
		update.addListener(SWT.KeyUp, updateListener);

//		login.addSelectionListener (new SelectionAdapter () {
//			public void widgetSelected (SelectionEvent e) {
//				handleLoginClick();
//			}
//		});


	}

	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	private void writeToFile() {
		IPath path = Activator.getDefault().getStateLocation().append(twitterHTMLFile);
		TwitterFileWriter writer = new TwitterFileWriter(path.toOSString());
		TwitterOperationsHandler operations = new TwitterOperationsHandler(tManager);
		writer.writeFeedsToHTML(operations);
		browser.setUrl(writer.getFilePath());
	}

	public void refresh() {
		writeToFile();
	}

	private void handleLoginClick(){

		final Shell pinDialogShell = new Shell();
		final Label enterPINLabel;
		final Text pinText;

		pinDialogShell.setLayout(new GridLayout(2, false));
		pinDialogShell.setText("Login form"); //$NON-NLS-1$
		enterPINLabel=new Label(pinDialogShell, SWT.NULL);
		enterPINLabel.setText("Enter PIN: "); //$NON-NLS-1$

		pinText = new Text(pinDialogShell, SWT.SINGLE | SWT.BORDER);
		pinText.setText(""); //$NON-NLS-1$
		pinText.setTextLimit(7);

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try 
				{
					if(tManager.getAccessToken() == null){
						browser.setUrl(tManager.getAuthorizationURL());
					}
					Button pinDialogSubmitButton=new Button(pinDialogShell,SWT.PUSH);
					pinDialogSubmitButton.setText("Submit"); //$NON-NLS-1$
					pinDialogSubmitButton.addListener(SWT.Selection, new Listener() {
						public void handleEvent(Event event) {
							String p=pinText.getText();
							//AccessToken accessToken = null;
							if(p==""){ //$NON-NLS-1$
								MessageBox messageBox = new MessageBox(pinDialogShell, SWT.OK |
										SWT.ICON_WARNING |SWT.CANCEL);
								messageBox.setMessage("Enter the User Name"); //$NON-NLS-1$
								messageBox.open();
							}
							else{
								try{
									if(p.length() > 0){
										tManager.setupPIN(p);
									}
								}catch(TwitterException e){
									e.printStackTrace();
								}
								writeToFile();
							}
							pinDialogShell.close();
						}
					});
					pinText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
					pinDialogShell.pack();
					if(tManager.getAccessToken() == null)
						pinDialogShell.open();
					else
						writeToFile();
				}catch (TwitterException te1){
					te1.printStackTrace();

				} catch( Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public void login() {
		handleLoginClick();
	}



}
