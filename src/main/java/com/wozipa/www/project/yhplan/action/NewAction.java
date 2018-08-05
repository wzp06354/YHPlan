package com.wozipa.www.project.yhplan.action;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 * Created by wozipa on 18-6-25.
 */
public class NewAction extends Action{

    public NewAction()
    {
        super();
        this.setText("新建");
        this.setAccelerator(SWT.SHIFT+SWT.ALT+'N');
        this.setEnabled(true);
    }

    @Override
    public void run() {
        super.run();
    }
}
