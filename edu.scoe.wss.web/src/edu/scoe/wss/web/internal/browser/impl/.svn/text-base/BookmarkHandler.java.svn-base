package edu.scoe.wss.web.internal.browser.impl;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.IWSSConstants;
import edu.scoe.wss.web.internal.bookmark.impl.BookmarkFileManager;
import edu.scoe.wss.web.internal.views.BookmarkViewPart;
import edu.scoe.wss.web.internal.views.BrowserViewPart;



public class BookmarkHandler extends AbstractHandler implements IHandler {

	String BkmarkUrl;
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof BrowserViewPart){
			BrowserViewPart part = (BrowserViewPart) activePart;
			BkmarkUrl = part.bookmark();
			try {
				BookmarkFileManager.getManager().writeBookmarkToFile(BkmarkUrl);
				BookmarkViewPart bMarkView = findBookmarkView();
				if(bMarkView!=null)
					bMarkView.refresh();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private static BookmarkViewPart findBookmarkView(){

        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if ((window != null) && (window.getActivePage() != null)) {
            IViewReference[] viewRefs = window.getActivePage().getViewReferences();
            IViewReference eventViewRef = null;

            for (int i = 0; i < viewRefs.length; i++) {
                if (IWSSConstants.BOOKMARKS_VIEW_ID.equals(viewRefs[i].getId())) {
                    eventViewRef = viewRefs[i];
                }
            }

            if (eventViewRef != null) {
                IViewPart eventViewPart = eventViewRef.getView(true);

                if (eventViewPart != null) {
                    if (eventViewPart instanceof BookmarkViewPart) {
                        return (BookmarkViewPart) eventViewPart;
                    }
                }
            }
        }

        return null;
    
	}
	
	

}