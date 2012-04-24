package edu.scoe.wss.web.internal.twitter.impl;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.internal.views.TwitterViewPart;

public class TwitterLoginHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof TwitterViewPart){
			TwitterViewPart part = (TwitterViewPart) activePart;
			part.login();
		}
		return null;
	}

}
