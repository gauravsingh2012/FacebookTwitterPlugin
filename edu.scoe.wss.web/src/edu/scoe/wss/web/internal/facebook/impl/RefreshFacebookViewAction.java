package edu.scoe.wss.web.internal.facebook.impl;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import edu.scoe.wss.web.internal.views.FacebookViewPart;

public class RefreshFacebookViewAction extends AbstractHandler implements IHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
		if(activePart instanceof FacebookViewPart){
			FacebookViewPart part = (FacebookViewPart) activePart;
			try {
				part.refresh();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	

}
