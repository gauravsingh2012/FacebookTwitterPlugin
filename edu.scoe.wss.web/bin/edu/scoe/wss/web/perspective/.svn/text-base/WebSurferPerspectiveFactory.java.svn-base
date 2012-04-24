package edu.scoe.wss.web.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import edu.scoe.wss.web.IWSSConstants;

public class WebSurferPerspectiveFactory implements IPerspectiveFactory {

	
	
	public void createInitialLayout(IPageLayout layout) {

		//layout.addView(IWSSConstants.TWITTER_VIEW_ID,IPageLayout.LEFT,0.30f,layout.getEditorArea());


		IFolderLayout bot = layout.createFolder("bottom",IPageLayout.BOTTOM,(float)0.76f, //$NON-NLS-1$
					layout.getEditorArea());
		bot.addView(IWSSConstants.TWITTER_VIEW_ID);
		bot.addView(IWSSConstants.BOOKMARKS_VIEW_ID);
		bot.addView(IWSSConstants.FACEBOOK_VIEW_ID);
		bot.addView(IWSSConstants.BROWSER_VIEW_ID);

		
	}

}
