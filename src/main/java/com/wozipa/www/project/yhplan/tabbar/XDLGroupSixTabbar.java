package com.wozipa.www.project.yhplan.tabbar;

import com.wozipa.www.project.yhplan.enums.MoneyUnit;
import com.wozipa.www.project.yhplan.enums.Positions;
import com.wozipa.www.project.yhplan.plan.XDLGroupSixPlan;
import javafx.geometry.Pos;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import javax.swing.text.Position;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wozipa on 18-6-25.
 */
public class XDLGroupSixTabbar extends CTabItem {

    private CTabFolder content = null;
    private int style ;

    private String id = null;
    private Text jobIdText = null;

    private Composite composite = null;

    private Text planName = null;
    private Text planUrl = null;
    private Button planBeforeBtn = null;
    private Button planMidleBtn = null;
    private Button planLastBtn = null;
    private Text planMoney = null;
    private Button planYuanUnit = null;
    private Button planJiaoUnit = null;
    private Button planFenUnit = null;
    private Button planLiUnit = null;
    private Text planWaitCycle = null;
    private Text planAddCycle = null;
    private Text planTimeCycle = null;

    public XDLGroupSixTabbar(CTabFolder parent, int style) {
        super(parent,style);
        //
        this.content = parent;
        this.style = style;
        this.setText("组六方法");
        this.setShowClose(true);
        composite=new Composite(parent,style);
        this.setControl(composite);
        composite.setBackground(new Color(null, new RGB(255, 255, 255)));
        composite.setLayout(new GridLayout(10, false));
        //　创建随机ＩＤ值
        this.id= UUID.randomUUID().toString();
    }

    public void createContent(){
        createNameArea();
        createUrlAre();
        createPositionArea();
//        createMoneyArea();
//        createUnitArea();
        createWaitCycleArea();
        createAddCycleArea();
//        createTimeCycleArea();
        createSubmitArea();
    }

    public void createNameArea()
    {
        Text label=new Text(composite, SWT.NONE);
        label.setText("名称");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        planName=new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planName.setText("新德里1.5分彩,组六计划页面");
    }

    public void createUrlAre(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("链接");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        planUrl=new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planUrl.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planUrl.setText("http://i8wj.yhyl357.com/view/game/game.html?code=xdlxyssc");
    }

    public void createPositionArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("位置");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        Group group=new Group(this.composite, SWT.NONE);
        group.setBackground(new Color(null, new RGB(255, 255, 255)));
        group.setLayout(new RowLayout());

        planBeforeBtn = new Button(group,SWT.RADIO | SWT.LEFT);
        planBeforeBtn.setData("value", Positions.FrontThree.getValue());
        planBeforeBtn.setText(" 前三组六 ");
        planBeforeBtn.setSelection(true);

        planMidleBtn = new Button(group,SWT.RADIO | SWT.CENTER);
        planMidleBtn.setData("value",Positions.MiddleThree.getValue());
        planMidleBtn.setText(" 中三组六 ");

        planLastBtn = new Button(group,SWT.RADIO | SWT.RIGHT);
        planLastBtn.setText("后三组六 ");
        planLastBtn.setData("value", Positions.BehindThree.getValue());
        group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 9, 1));
    }

    public void createMoneyArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("开始单位");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        //
        planMoney=new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planMoney.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planMoney.setText("1");
    }

    public void createUnitArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("开始单位");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

        Group group=new Group(this.composite, SWT.NONE);
        group.setBackground(new Color(null, new RGB(255, 255, 255)));
        group.setLayout(new RowLayout());
        planYuanUnit = new Button(group,SWT.RADIO | SWT.LEFT);
        planYuanUnit.setData("value", MoneyUnit.YUAN.getValue());
        planYuanUnit.setText(" 元 ");
        planJiaoUnit = new Button(group,SWT.RADIO | SWT.CENTER);
        planJiaoUnit.setData("value",MoneyUnit.JIAO.getValue());
        planJiaoUnit.setText(" 角 ");
        planFenUnit = new Button(group,SWT.RADIO | SWT.RIGHT);
        planFenUnit.setText("分 ");
        planFenUnit.setData("value",MoneyUnit.FEN.getValue());
        planLiUnit = new Button(group,SWT.RADIO | SWT.RIGHT);
        planLiUnit.setText("厘 ");
        planLiUnit.setData("value",MoneyUnit.LI.getValue());
        planLiUnit.setSelection(true);
        group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 9, 1));
    }


    public void createWaitCycleArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("等待周期");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        //
        planWaitCycle = new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planWaitCycle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planWaitCycle.setText("10");
    }

    public void createAddCycleArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("投资周期");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        //
        planAddCycle = new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planAddCycle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planAddCycle.setText("12");
    }

    public void createTimeCycleArea(){
        Text label=new Text(composite, SWT.NONE);
        label.setText("时间周期(s)");
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        //
        planTimeCycle = new Text(composite, SWT.BORDER|SWT.MULTI|SWT.SCROLL_LINE);
        planTimeCycle.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 9, 1));
        planTimeCycle.setText("90");
    }

    public void createSubmitArea()
    {
        Label label=new Label(this.composite,SWT.NONE);
        label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 2));

        Button button=new Button(this.composite, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 9, 2));
        button.setText("开始执行计划");
        button.addSelectionListener(new StartPlanListern());
    }


    class StartPlanListern implements SelectionListener {

        @Override
        public void widgetSelected(SelectionEvent selectionEvent) {
            Positions positions = getPosition();
            System.out.println("开始执行组六计划。。。。");
            System.out.println("ID:" + id);
            System.out.println("URL:" + planUrl.getText());
            System.out.println(positions);
            System.out.println(planWaitCycle.getText());
            System.out.println(planAddCycle.getText());
            XDLGroupSixPlan plan = new XDLGroupSixPlan(id,planUrl.getText(),positions,
                    Integer.parseInt(planWaitCycle.getText()),
                    Integer.parseInt(planAddCycle.getText()));
            plan.start();
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent selectionEvent) {

        }
    }

    public Positions getPosition(){
        if(planMidleBtn.getSelection()){
            return Positions.MiddleThree;
        }
        else if(planBeforeBtn.getSelection()){
            return  Positions.FrontThree;
        }
        else return Positions.BehindThree;
    }

    
}
