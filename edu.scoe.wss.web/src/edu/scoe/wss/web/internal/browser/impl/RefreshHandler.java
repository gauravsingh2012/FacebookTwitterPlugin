package edu.scoe.wss.web.internal.browser.impl;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.internal.views.BrowserViewPart;



public class RefreshHandler extends AbstractHandler implements IHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof BrowserViewPart){
			BrowserViewPart part = (BrowserViewPart) activePart;
			part.refresh();
		}
		return null;
	}
	
	

}