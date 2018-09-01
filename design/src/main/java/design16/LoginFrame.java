package design16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

public class LoginFrame extends Frame implements Mediator {

    private static final long serialVersionUID = 1L;

    private static Map<String, String> USERS = new HashMap<String, String>();

    private ColleagueCheckbox checkGuest;

    private ColleagueCheckbox checkLogin;

    private ColleagueTextField textUser;

    private ColleagueTextField textPassword;

    private ColleagueButton buttonOK;

    private ColleagueButton buttonCancel;

    static {
        LoginFrame.USERS.put("reimu", "reimuwang");
    }

    public LoginFrame() {
        super("登陆窗口");
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new GridLayout(4, 2));
        // 生成并初始化设置各组件
        CheckboxGroup group = new CheckboxGroup();
        this.checkGuest = new ColleagueCheckbox(this, "Guest", group, true);
        this.checkLogin = new ColleagueCheckbox(this, "Login", group, false);
        int textTotalLength = 10;
        this.textUser = new ColleagueTextField(this, "", textTotalLength);
        this.textUser.setColleagueEnabled(false);
        this.textPassword = new ColleagueTextField(this, "", textTotalLength);
        this.textPassword.setEchoChar('*');
        this.textPassword.setColleagueEnabled(false);
        this.buttonOK = new ColleagueButton(this, "OK");
        this.buttonCancel = new ColleagueButton(this, "Cancel");
        // 设置Listener
        this.checkGuest.addItemListener(this.checkGuest);
        this.checkLogin.addItemListener(this.checkLogin);
        this.textUser.addTextListener(this.textUser);
        this.textPassword.addTextListener(this.textPassword);
        this.buttonOK.addActionListener(this.buttonOK);
        this.buttonCancel.addActionListener(this.buttonCancel);
        // 调停者记录自身需要管理哪些组员
        this.add(this.checkGuest);
        this.add(this.checkLogin);
        this.add(new Label("Username:"));
        this.add(this.textUser);
        this.add(new Label("Password:"));
        this.add(this.textPassword);
        this.add(this.buttonOK);
        this.add(this.buttonCancel);
        // 设置点击关闭时需执行的操作
        super.addWindowListener(
            new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        // 显示
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void colleagueChanged(Colleague colleague) {
        String mode = this.checkGuest.getState() ? "游客模式" : "登陆模式";
        if (colleague == this.checkGuest) {
            System.out.println("切换至游客模式，用户名输入框被关闭，密码输入框被关闭");
            this.textUser.setColleagueEnabled(false);
            this.textPassword.setColleagueEnabled(false);
            return;
        }
        if (colleague == this.checkLogin) {
            System.out.print("切换至登陆模式，用户名输入框被放开。");
            this.textUser.setColleagueEnabled(true);
            this.controlUser();
            System.out.println();
            return;
        }
        if (colleague == this.textUser) {
            System.out.print(mode + "下向用户名输入框中键入文字。");    // 其实只可能是登陆模式，姑且记录下
            this.controlUser();
            System.out.println();
            return;
        }
        if (colleague == this.textPassword) {
            System.out.print(mode + "下向密码输入框中键入文字。");    // 其实只可能是登陆模式，姑且记录下
            this.controlPassword();
            System.out.println();
            return;
        }
        if (colleague == this.buttonOK) {
            System.out.print(mode + "下OK按钮被按下。");
            if (this.checkGuest.getState()) {
                System.out.println("以游客的身份进入成功，窗体退出");
                System.exit(0);
            } else {
                if (this.textPassword.getText().equals(LoginFrame.USERS.get(this.textUser.getText()))) {
                    System.out.println("登陆成功，窗体退出");
                    System.exit(0);
                } else
                    System.out.println("用户名与密码不比配");
            }
            return;
        }
        if (colleague == this.buttonCancel) {
            System.out.println("取消按钮被按下，窗体退出");
            System.exit(0);
        }
        System.out.println(colleague);
    }

    private void controlUser() {
        if (this.textUser.getText().length() > 0) {
            System.out.print("用户名输入框中有文字，密码输入框被放开。");
            this.textPassword.setColleagueEnabled(true);
            this.controlPassword();
        } else {
            System.out.print("用户名输入框中没有文字，密码输入框，OK按钮关闭。");
            this.textPassword.setColleagueEnabled(false);
            this.buttonOK.setColleagueEnabled(false);
        }        
    }

    private void controlPassword() {
        if (this.textPassword.getText().length() > 0) {
            System.out.print("密码输入框中有文字，OK按钮被放开。");
            this.buttonOK.setColleagueEnabled(true);
        } else {
            System.out.print("密码输入框中没有文字，OK按钮关闭。");
            this.buttonOK.setColleagueEnabled(false);
        }
    }
}