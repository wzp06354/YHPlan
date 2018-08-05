package com.wozipa.www.project.yhplan.main;

import com.wozipa.www.project.yhplan.action.XDLGroupSixAction;
import com.wozipa.www.project.yhplan.action.XDLGroupThreeAction;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Listener;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.*;

/**
 * Created by wozipa on 18-6-25.
 */
public class MainWindow extends ApplicationWindow{

    private static final Logger LOGGER = Logger.getLogger(MainWindow.class);

    private static MainWindow app = null;

    public static MainWindow getApp(){
        return app;
    }

    private XDLGroupThreeAction xdlGroupThreeAction = null;
    private XDLGroupSixAction xdlGroupSixAction = null;

    private CTabFolder content = null;

    public MainWindow(){
        this(null);
        app = this;
        // 初始化工具栏
        this.xdlGroupThreeAction = new XDLGroupThreeAction();
        this.xdlGroupSixAction = new XDLGroupSixAction();
        //
        this.addMenuBar();
        this.addToolBar(SWT.FILL);
        this.addStatusLine();
        LOGGER.info("start to initlize the windows");

    }

    public MainWindow(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setText("YHPlan");
        shell.setMaximized(true);
        shell.setSize(1200,800);
    }

    @Override
    protected Control createContents(Composite parent) {
        parent.setBackground(new Color(null, new RGB(255, 255, 255)));
        content=new CTabFolder(parent,SWT.NONE);
        content.setBackground(new Color(null, new RGB(255, 255, 255)));
        content.addCTabFolder2Listener(new CTabFolder2Listener() {

            @Override
            public void showList(CTabFolderEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void restore(CTabFolderEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("restore");
            }

            @Override
            public void minimize(CTabFolderEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void maximize(CTabFolderEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void close(CTabFolderEvent arg0) {

            }
        });
        return parent;
    }

    @Override
    protected MenuManager createMenuManager() {
        MenuManager menu = new MenuManager();
        //
        MenuManager xdlMenu = new MenuManager("新德里1.5");
        menu.add(xdlMenu);
        xdlMenu.add(this.xdlGroupThreeAction);
        xdlMenu.add(this.xdlGroupSixAction);
        //
        MenuManager sscMenu = new MenuManager("重庆时时彩");
        menu.add(sscMenu);


        return menu;
    }

    public CTabFolder getContent(){
        return this.content;
    }

    public static void main(String[] args){
        MainWindow window=new MainWindow();
        window.setBlockOnOpen(true);
        window.open();
        Display.getCurrent().dispose();
    }

}
