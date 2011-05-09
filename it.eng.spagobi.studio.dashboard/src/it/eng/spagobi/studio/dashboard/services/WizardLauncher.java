package it.eng.spagobi.studio.dashboard.services;

import it.eng.spagobi.studio.dashboard.wizards.SpagoBINewDashboardWizard;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WizardLauncher {

	private static Logger logger = LoggerFactory.getLogger(WizardLauncher.class);

	
	static public void wizardLaunch(){
		logger.debug("IN");
		SpagoBINewDashboardWizard sbindw = new SpagoBINewDashboardWizard();
		sbindw.setCalledFromMenu(true);

		// from menu has no selection
		sbindw.init(PlatformUI.getWorkbench(), null);
		// Create the wizard dialog
		WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),sbindw);
		// Open the wizard dialog
		dialog.open();

		logger.debug("OUT");

	}
	
}
