package com.wozipa.www.project.yhplan.action;

import com.wozipa.www.project.yhplan.main.MainWindow;
import com.wozipa.www.project.yhplan.tabbar.XDLGroupThreeTabbar;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;

/**
 * Created by wozipa on 18-6-25.
 */
public class XDLGroupThreeAction extends Action{

    public XDLGroupThreeAction(){
        this.setText("组三方法");
        this.setEnabled(true);
    }

    @Override
    public void run() {
        MainWindow window= MainWindow.getApp();
        CTabFolder parent=window.getContent();
        XDLGroupThreeTabbar pageTabbar=new XDLGroupThreeTabbar(parent, SWT.NONE);
        pageTabbar.createContent();
        parent.setSelection(pageTabbar);
    }
}
