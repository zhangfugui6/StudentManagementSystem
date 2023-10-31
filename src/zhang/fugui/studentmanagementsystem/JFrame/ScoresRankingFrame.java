package zhang.fugui.studentmanagementsystem.JFrame;


import zhang.fugui.studentmanagementsystem.model.ScoreAnalyzeModel;
import zhang.fugui.studentmanagementsystem.utils.WindowUtil;

import javax.swing.*;

public class ScoresRankingFrame extends JDialog{

	private JTable jt;
	private JScrollPane jsp;
	

	public ScoresRankingFrame(JDialog owner, String title, boolean modal, ScoreAnalyzeModel model){
		super(owner, title, modal);
		jt = new JTable();
		jsp = new JScrollPane(jt);
		jt.setModel(model);
		jsp.setBounds(20, 20, 860, 460);
		this.add(jsp);
		
		this.setSize(1000,500);
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}
}
