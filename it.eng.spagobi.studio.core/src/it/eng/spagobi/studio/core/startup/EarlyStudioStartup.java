/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
**/
package it.eng.spagobi.studio.core.startup;

import java.util.Iterator;
import java.util.Vector;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** this class is used to limit button visibility for SpagoBIPerspective
 * 
 * @author gavardi
 *
 */

public class EarlyStudioStartup implements IStartup {


	private static Logger logger = LoggerFactory.getLogger(EarlyStudioStartup.class);



	String actionsToRemoveStringConstant =
		IWorkbenchActionConstants.M_LAUNCH + " "+
		IWorkbenchActionConstants.M_NAVIGATE + " "+
		IWorkbenchActionConstants.M_PROJECT + " "+
		IWorkbenchActionConstants.M_PROJECT_CONFIGURE;


	public Vector<String> getActionsToDisable(){
		Vector<String> toreturn = new Vector<String>();
		toreturn.add(IWorkbenchActionConstants.M_LAUNCH );
		toreturn.add(IWorkbenchActionConstants.M_NAVIGATE );
		toreturn.add(IWorkbenchActionConstants.M_PROJECT );
		toreturn.add(IWorkbenchActionConstants.M_PROJECT_CONFIGURE );
		return toreturn;
	}

	public boolean isToDisable(Vector<String> actionsToDisable, String action){
		boolean toreturn=false;
		for (Iterator iterator = actionsToDisable.iterator(); iterator.hasNext() && toreturn == false;) {
			String disable = (String) iterator.next();
			if(action.indexOf(disable) != -1){
				toreturn=true;
			}
		}
		return toreturn;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IStartup#earlyStartup()
	 */
	public void earlyStartup() {
		logger.debug("IN");
		/*
		 * The registration of the listener should have been done in the UI thread
		 * since  PlatformUI.getWorkbench().getActiveWorkbenchWindow() returns null
		 * if it is called outside of the UI thread.
		 * */
		//		Display.getDefault().asyncExec(new Runnable() {
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		//		public void run() {
		//				logger.debug("IN");
		//				final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		//				if (workbenchWindow != null) {
		//					workbenchWindow.addPerspectiveListener(new PerspectiveAdapter() {
		//						/* (non-Javadoc)
		//						 * @see org.eclipse.ui.PerspectiveAdapter#perspectiveActivated(org.eclipse.ui.IWorkbenchPage, org.eclipse.ui.IPerspectiveDescriptor)
		//						 */
		//						@Override
		//						public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspectiveDescriptor) {
		//							logger.debug("IN");
		//							super.perspectiveActivated(page, perspectiveDescriptor);
		//
		//							if (perspectiveDescriptor.getId().indexOf(SpagoBIPerspective.PERSPECTIVE_ID) > -1) {
		//								Vector<String> toDisable = getActionsToDisable();
		//								if (workbenchWindow.getActivePage() instanceof WorkbenchPage) {
		//									WorkbenchPage worbenchPage = (WorkbenchPage) workbenchWindow.getActivePage();
		//									// Get the perspective
		//									Perspective perspective = worbenchPage.findPerspective(perspectiveDescriptor);
		//									ArrayList toRemove = new ArrayList();
		//									if (perspective != null) {
		//
		//										logger.debug("Always Off Action Set");
		//										for (IActionSetDescriptor actionSetDescriptor : perspective.getAlwaysOffActionSets()) {
		//											String id = actionSetDescriptor.getId();
		//											logger.debug("Id: "+id + "  - Label: "+actionSetDescriptor.getLabel());
		//											
		//										}
		//										logger.debug("---------------------");
		//										logger.debug("Always On Action Set");
		//
		//										for (IActionSetDescriptor actionSetDescriptor : perspective.getAlwaysOnActionSets()) {
		//											String id = actionSetDescriptor.getId();
		//											logger.debug("Id: "+id + "  - Label: "+actionSetDescriptor.getLabel());
		////											if (id.indexOf("org.eclipse.search.searchActionSet") > -1) {
		////												toRemove.add(actionSetDescriptor);
		////											}
		//											if (actionsToRemoveString.indexOf(id) > -1) {
		//												logger.debug("Disable "+actionSetDescriptor.getId());
		//												toRemove.add(actionSetDescriptor);
		//											}
		//											if(isToDisable(toDisable, id)){
		//												logger.debug("Disable "+actionSetDescriptor.getId());
		//												toRemove.add(actionSetDescriptor);
		//											}
		//
		//
		//										}
		//										perspective.turnOffActionSets((IActionSetDescriptor[]) toRemove.toArray(new IActionSetDescriptor[toRemove.size()]));
		//									}
		//								}
		//							}
		//							logger.debug("OUT");
		//						}
		//					
		//					
		//					});
		//				}
		//				logger.debug("OUT");
		//			}
		//		});
		logger.debug("OUT");



	}
}
