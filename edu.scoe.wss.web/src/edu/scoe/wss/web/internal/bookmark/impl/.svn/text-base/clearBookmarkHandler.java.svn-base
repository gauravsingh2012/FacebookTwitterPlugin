package edu.scoe.wss.web.internal.bookmark.impl;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.internal.views.BookmarkViewPart;

public class clearBookmarkHandler extends AbstractHandler implements IHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof BookmarkViewPart){
			BookmarkViewPart part = (BookmarkViewPart) activePart;
			part.clear();
			}
		return null;
	}
	
	

}

