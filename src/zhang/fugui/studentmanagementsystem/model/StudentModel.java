package zhang.fugui.studentmanagementsystem.model;

import zhang.fugui.studentmanagementsystem.bean.Student;
import zhang.fugui.studentmanagementsystem.dao.ManageHelp;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//rowData用来存放行数据
//columnNames存放列名

/**
 * 该代码是一个学生表格模型，通过继承AbstractTableModel类，
 * 实现getRowCount，getColumnCount，getValueAt，getColumnName等方法，来展示学生信息。
 * 在构造函数中，使用ManageHelp类中的getStudent方法，获取学生信息，然后将数据存入rowData中，并设置列名。
 * 通过重载getRowCount方法，返回行数；getColumnCount方法，返回列数；getValueAt方法，
 * 返回指定单元格中的数据；getColumnName方法，返回指定列的名称。最后在构造函数中，判断获取到的数据是否为空，
 * 并通过JOptionPane类的showMessageDialog方法，在对话框中显示相应信息。
 */
public class StudentModel extends AbstractTableModel {
	private ManageHelp helper;
	private Vector<Student> students;
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
		
	 public StudentModel(String sql,JDialog jd) {
		helper = new ManageHelp();
		students = helper.getStudent(sql);
		
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年级");
		columnNames.add("班级");
		columnNames.add("院系");
		columnNames.add("专业");
		for(Student student : students){
			Vector<String> hang = new Vector<String>();
			hang.add(student.getStudent_ID());
			hang.add(student.getStudent_Name());
			hang.add(student.getSex());
			hang.add(student.getGrade());
			hang.add(student.getClasse());
			hang.add(student.getDepartment_Name());
			hang.add(student.getMajor_Name());
			rowData.add(hang);
		}
		if(getRowCount()!=0){
			JOptionPane.showMessageDialog(jd, "一共有"+getRowCount()+"条记录！");
			return ;
		}else{
			JOptionPane.showMessageDialog(jd, "没有任何记录！");
			return ;
		}
	}
	
	//得到共有多少行
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.rowData.size();
		}
		//得到共有多少列
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return this.columnNames.size();
		}
		//得到某行某列的数据
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
		}
		
		//重写方法 getColumnName
		@Override  
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return (String)this.columnNames.get(column);
		}

}
