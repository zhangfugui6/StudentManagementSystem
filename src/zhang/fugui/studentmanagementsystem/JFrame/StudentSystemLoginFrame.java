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
 * �ô���Ϊһ��ѧ����Ϣ����ϵͳ�ĵ�½����.
 * �û������û���������󣬵����¼��ť�����¼�����������������û��������봫�ݸ�ManageHelp���ݿ�ҵ���������е�½
 * ҵ�����ж��û��Ƿ�����������Ƿ���ȷ�������ȷ���ж��Ƿ��Ѿ��������ط���¼������Ѿ���½����ʾ�ظ���½�����أ�
 * ���û�е�½���޸��ѵ�¼״̬���رյ�ǰ���ڲ��������棬�������ȷ����ʾ�û���������������������
 * �ô���ʹ����AWT��Swingͼ�ν��棬�Լ�JDBC�����ݿ���в�����
 */
//��½����
public class StudentSystemLoginFrame extends JFrame{
	
	private JLabel username_Label;	//�û�����ǩ��
	private JLabel password_Label;	//�����ǩ��
	private JTextField username_Text;	//�û����ı���
	private JPasswordField password_Text;	//�����ı���
	private JButton login_Button;	//��½��ť��
	private JComboBox select;    //"���"ѡ�
	private JLabel select_Label;    //"���"��ǩ��
	private JFrame jf;	//��ǰ���� ��
	public StudentSystemLoginFrame(){
		super("ѧ����Ϣ����ϵͳ��¼����");
		this.jf = this;
		this.setLayout(null);//����Ϊ�ղ��֡�
		this.setSize(530,350);//���ô�С��
		Container c = this.getContentPane();
		c.setBackground(Color.CYAN);//���ñ�����ɫ��
		username_Label = new JLabel("�û�:");	//����"�û���"��ǩ��
		username_Label.setFont(new Font("����",Font.BOLD,16));
		username_Label.setBounds(180, 80, 100, 40);	//����"�û���"��ǩλ�á�
		c.add(username_Label);	//���"�û���"��ǩ��
		
		username_Text = new JTextField();	//����"�û���"�ı���
		username_Text.setBounds(240, 80, 150, 30);	//����"�û���"�ı���λ�á�
		username_Text.grabFocus();//��ù�ꡣ
		c.add(username_Text);	//���"�û���"�ı���
		
		password_Label = new JLabel("����:");	//����"����"��ǩ��
		password_Label.setBounds(180, 140, 100, 40);
		password_Label.setFont(new Font("����",Font.BOLD,16));
		c.add(password_Label);	//���"����"��ǩ��
		
		password_Text = new JPasswordField();	//����"����"�ı���
		password_Text.setBounds(240, 140, 150, 30);	//����"����"�ı���λ�á�

		c.add(password_Text);	//���"����"�ı���


		select_Label = new JLabel("�û�����:");
		select_Label.setBounds(153, 192, 100, 40);
		this.add(select_Label);
		select_Label.setFont(new Font("����",Font.BOLD,14));
		select = new JComboBox(new String[]{"", "��ʦ", ""});
		select.setBounds(240, 200, 80, 25);
		this.add(select);

		login_Button = new JButton("��¼");	//����"��¼"��ť��
		login_Button.setBounds(250, 260, 60, 30);	//����"��¼"��ťλ�á�
		login_Button.setFont(new Font("����",Font.BOLD,12));
		//ע��"��¼"��ť�¼�������
		login_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = username_Text.getText().trim();
				String password = new String(password_Text.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jf, "�û�������Ϊ��","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if(password.equals("")){
					JOptionPane.showMessageDialog(jf, "���벻��Ϊ��","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				//��¼ҵ����
				User user = new User();//�����û�����
				user.setUsername(username);
				user.setPassword(password);
				ManageHelp helper = new ManageHelp();//�������ݿ�ҵ�������
				if(helper.Login(user)){	//��½ҵ����
					if(helper.Check_IsLogin(user)){
						JOptionPane.showMessageDialog(jf, "�ظ���½��","",JOptionPane.WARNING_MESSAGE);
						return ;
					}else{
						JOptionPane.showMessageDialog(jf, "��½�ɹ���");
						jf.dispose();//�رյ�ǰ���ڡ�
						//�޸ĵ�½���
						user.setIsLogin(1);//�޸ĳ�Ϊ�Ѿ���½��
						helper.Update_IsLogin(user);
						//��������
						user.setPassword("");//��������
						StudentSystemMainFrame frame = new StudentSystemMainFrame(user);
						return ;
					}
				}else{
					JOptionPane.showMessageDialog(jf, "�û������������");
					 Reset();	//����
					return ;
				}
				
			}
		});
		c.add(login_Button);	//���"��¼"��ť ��
		
		

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);	//���ô�С���ɸı䡣
		WindowUtil.setFrameCenter(this);//���ô��ھ��С�
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.setVisible(true);	//���ô���ɼ���
	}
	
		//����
		public void Reset(){
			username_Text.setText("");
			password_Text.setText("");
		}
}
