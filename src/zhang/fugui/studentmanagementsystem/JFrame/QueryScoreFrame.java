package zhang.fugui.studentmanagementsystem.JFrame;



import zhang.fugui.studentmanagementsystem.dao.ManageHelp;
import zhang.fugui.studentmanagementsystem.model.ScoreModel;
import zhang.fugui.studentmanagementsystem.utils.WindowUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;


//��ѯ�ɼ�����
public class QueryScoreFrame extends JDialog{
	private ManageHelp helper;
	private ScoreModel sm;
	private Vector<String> courses;
	private JDialog jd;
	private HashMap<String, JTextField> jtextFieldHashMap;//�����ı���ļ���
	private JButton confirm_button;	//"ȷ����ť"
	private HashMap<String, String> scores;	//ѧ�����гɼ�

	public QueryScoreFrame(JDialog owner, String title, boolean modal, ScoreModel sm, int rowNum){
		super(owner, title, modal);
		this.jd = this;
		this.setLayout(null);
		
		helper = new ManageHelp();
		this.sm = sm;
		jtextFieldHashMap = new HashMap<String, JTextField>();
		courses = helper.getCourse(helper.getAllMajor().get(sm.getValueAt(rowNum, 6)),sm.getValueAt(rowNum, 3).toString());//������пγ�
		scores = helper.getStudentScore(sm.getValueAt(rowNum, 0).toString());//����ѧ�Ż�ø�ѧ�������п�Ŀ�ɼ�
		
	
		int vgap = 0;	//��ֱ���
		for(int i=0;i<courses.size();i++){
			JLabel jLabel = new JLabel(courses.get(i)+":");
			jLabel.setBounds(78, 48+vgap, 120, 20);
			JTextField field = new JTextField();
			field.setEditable(false);
			field.setText(scores.get(courses.get(i)));//���ı�����ӳɼ�
			field.setBounds(206, 48+vgap, 150, 20);
			jtextFieldHashMap.put(courses.get(i),field);	//���������ı���ļ���
			this.add(jLabel);
			this.add(field);
			vgap += 30;
		}
		confirm_button = new JButton("ȷ��");
		confirm_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();
			}
		});
		confirm_button.setBounds(215, 48+vgap+5, 60, 20);
		this.add(confirm_button);
		this.setSize(450, 48+vgap+78);
		WindowUtil.setFrameCenter(this);
		this.setVisible(true);
		
	}
}
