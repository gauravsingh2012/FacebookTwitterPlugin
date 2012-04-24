package edu.scoe.wss.web.internal.facebook.impl;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.internal.views.FacebookViewPart;


public class FacebookLoginHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof FacebookViewPart){
			FacebookViewPart part = (FacebookViewPart) activePart;
			part.facebooklogin(); 
		}
		return null;
	}

}
