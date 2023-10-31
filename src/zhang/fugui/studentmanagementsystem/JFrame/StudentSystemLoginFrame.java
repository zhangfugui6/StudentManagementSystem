package zhang.fugui.studentmanagementsystem.JFrame;

import zhang.fugui.studentmanagementsystem.bean.User;
import zhang.fugui.studentmanagementsystem.dao.ManageHelp;
import zhang.fugui.studentmanagementsystem.utils.WindowUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 该代码为一个学生信息管理系统的登陆界面.
 * 用户输入用户名和密码后，点击登录按钮触发事件监听器，将输入的用户名和密码传递给ManageHelp数据库业务处理对象进行登陆
 * 业务处理，判断用户是否存在且密码是否正确，如果正确则判断是否已经在其他地方登录，如果已经登陆则提示重复登陆并返回；
 * 如果没有登陆则修改已登录状态，关闭当前窗口并打开主界面，如果不正确则提示用户名或密码错误并重置输入框。
 * 该代码使用了AWT和Swing图形界面，以及JDBC对数据库进行操作。
 */
//登陆界面
public class StudentSystemLoginFrame extends JFrame{
	
	private JLabel username_Label;	//用户名标签。
	private JLabel password_Label;	//密码标签。
	private JTextField username_Text;	//用户名文本域。
	private JPasswordField password_Text;	//密码文本域。
	private JButton login_Button;	//登陆按钮。
	private JComboBox select;    //"身份"选项。
	private JLabel select_Label;    //"身份"标签。
	private JFrame jf;	//当前窗口 。
	public StudentSystemLoginFrame(){
		super("学生信息管理系统登录界面");
		this.jf = this;
		this.setLayout(null);//设置为空布局。
		this.setSize(530,350);//设置大小。
		Container c = this.getContentPane();
		c.setBackground(Color.CYAN);//设置背景颜色。
		username_Label = new JLabel("用户:");	//创建"用户名"标签。
		username_Label.setFont(new Font("黑体",Font.BOLD,16));
		username_Label.setBounds(180, 80, 100, 40);	//设置"用户名"标签位置。
		c.add(username_Label);	//添加"用户名"标签。
		
		username_Text = new JTextField();	//创建"用户名"文本域。
		username_Text.setBounds(240, 80, 150, 30);	//设置"用户名"文本域位置。
		username_Text.grabFocus();//获得光标。
		c.add(username_Text);	//添加"用户名"文本域。
		
		password_Label = new JLabel("密码:");	//创建"密码"标签。
		password_Label.setBounds(180, 140, 100, 40);
		password_Label.setFont(new Font("黑体",Font.BOLD,16));
		c.add(password_Label);	//添加"密码"标签。
		
		password_Text = new JPasswordField();	//创建"密码"文本域。
		password_Text.setBounds(240, 140, 150, 30);	//设置"密码"文本域位置。

		c.add(password_Text);	//添加"密码"文本域。


		select_Label = new JLabel("用户类型:");
		select_Label.setBounds(153, 192, 100, 40);
		this.add(select_Label);
		select_Label.setFont(new Font("黑体",Font.BOLD,14));
		select = new JComboBox(new String[]{"", "教师", ""});
		select.setBounds(240, 200, 80, 25);
		this.add(select);

		login_Button = new JButton("登录");	//创建"登录"按钮。
		login_Button.setBounds(250, 260, 60, 30);	//设置"登录"按钮位置。
		login_Button.setFont(new Font("黑体",Font.BOLD,12));
		//注册"登录"按钮事件监听。
		login_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = username_Text.getText().trim();
				String password = new String(password_Text.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "用户名不能为空","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "密码不能为空","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//登录业务处理。
				User user = new User();//创建用户对象
				user.setUsername(username);
				user.setPassword(password);
				ManageHelp helper = new ManageHelp();//创建数据库业务处理对象
				if(helper.Login(user)){	//登陆业务处理
					if(helper.Check_IsLogin(user)){
						JOptionPane.showMessageDialog(jf, "重复登陆！","",JOptionPane.WARNING_MESSAGE);
						return ;
					}else{
						JOptionPane.showMessageDialog(jf, "登陆成功！");
						jf.dispose();//关闭当前窗口。
						//修改登陆情况
						user.setIsLogin(1);//修改成为已经登陆。
						helper.Update_IsLogin(user);
						//打开主界面
						user.setPassword("");//重置密码
						StudentSystemMainFrame frame = new StudentSystemMainFrame(user);
						return ;
					}
				}else{
					JOptionPane.showMessageDialog(jf, "用户名或密码错误！");
					 Reset();	//重置
					return ;
				}
				
			}
		});
		c.add(login_Button);	//添加"登录"按钮 。
		
		

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	//设置大小不可改变。
		WindowUtil.setFrameCenter(this);//设置窗口居中。
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setVisible(true);	//设置窗体可见。
	}
	
		//重置
		public void Reset(){
			username_Text.setText("");
			password_Text.setText("");
		}
}
