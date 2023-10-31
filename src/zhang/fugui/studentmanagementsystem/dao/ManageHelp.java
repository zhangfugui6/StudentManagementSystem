package zhang.fugui.studentmanagementsystem.dao;


import zhang.fugui.studentmanagementsystem.bean.AnalyzeResult;
import zhang.fugui.studentmanagementsystem.bean.Student;
import zhang.fugui.studentmanagementsystem.bean.User;

import java.util.HashMap;
import java.util.Vector;


//���ݿ�ҵ������
public class ManageHelp {
	private JdbcHelp helper;	//�����ݿ�ͨ�ŵĶ���
	
	
	
	/**
	 * ��½ҵ����
	 */
	public boolean Login(User user){
		boolean b = true;
		helper = new JdbcHelp();	//���������ݿ�ͨ�ŵĶ���
		User newUser = helper.getUser(user);	//����û�����
		if(!user.getPassword().equals(newUser.getPassword())){	//�ȶ����������ݿ��еĶ�Ӧ�����Ƿ�һ��
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}

	/**
	 * ����Ƿ��ظ���½�ķ���
	 */
	public boolean Check_IsLogin(User user){
		boolean b = true;
		int isLogin;
		helper = new JdbcHelp();//���������ݿ�ͨ�ŵĶ���
		User newUser = helper.getUser(user);
		if(newUser.getIsLogin()==0){
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ���سɹ��޸ĵ�½���
	 */
	public boolean  Update_IsLogin(User user){
		helper = new JdbcHelp();//���������ݿ�ͨ�ŵĶ���
		boolean b = helper.update_IsLogin(user);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * �޸�����ҵ����
	 */
	public boolean update_Password(User user,String new_Password){
		boolean b;
		helper = new JdbcHelp();//���������ݿ�ͨ�ŵĶ���
		b = helper.update_Password(user, new_Password);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * �������Ժϵ
	 */	
	public HashMap<String, String>getAllDepartment(){
		helper = new JdbcHelp();
		HashMap<String, String> map;
		map = helper.getAllDepartment();
		helper.close();//�ر���Դ
		return map;
	}
	
	
	
	/**
	 * �������רҵ
	 */
	public HashMap<String, String>getAllMajor(){
		helper = new JdbcHelp();
		HashMap<String, String> map;
		map = helper.getAllMajor();
		helper.close();//�ر���Դ
		return map;
	}
	
	
	
	/**
	 * ����department_ID���ض�Ӧ��רҵ
	 */
	public Vector<String> getMajor(String department_ID){
		helper = new JdbcHelp();
		Vector<String> vector;
		vector = helper.getMajor(department_ID);
		helper.close();
		return vector;
	}

	
	/**
	 * ���ѧ��ҵ��
	 */
	public boolean addStudent(Student student){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.addStudent(student);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * �޸�ѧ��ҵ��
	 */
	public boolean updateStudent(Student newStudent,String oldStudentID){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.updateStudent(newStudent, oldStudentID);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * ɾ��ѧ��ҵ��
	 */
	public boolean deleteStudent(String studentID){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.deleteStudent(studentID);
		helper.close();
		return b;
	}
	
	
	/**
	 * ����sql��䷵���ض���ѧ�����󼯺�
	 */
	public Vector<Student> getStudent(String sql){
		Vector<Student> students;
		helper = new JdbcHelp();
		students = helper.getStudent(sql);
		helper.close();
		return students;
	}
	
	
	/**
	 * �����꼶��רҵ��ű�ŷ��ض�Ӧ�İ༶
	 */
	public Vector<String> getAllClasse(String grade,String major_ID){
		Vector<String> vector;
		helper = new JdbcHelp();
		vector = helper.getAllClasse(grade,major_ID);
		helper.close();
		return vector;
		
	}
	
	
	
	
	/**
	 *  ����רҵ��ŷ��ض�Ӧ�����пγ�
	 */
	public Vector<String> getCourse(String major_Id,String grade){
		Vector<String> vector;
		helper = new JdbcHelp();
		vector = helper.getCourse(major_Id,grade);
		helper.close();
		return vector;
	}
	
	
	/**
	 * ���ѧ���ɼ�
	 */
	public boolean addStudentScore(Student student,Vector<String> courses){
		boolean b;
		helper = new JdbcHelp();
		b = helper.addStudentScore(student,courses);
		helper.close();
		return b;
	}
	
	
	
	/**
	 * �޸�ѧ���ɼ�
	 */
	public boolean updateStudentScore(String student_Id,String course_Name,String score){
		boolean b;
		helper = new JdbcHelp();
		b = helper.updateStudentScore(student_Id, course_Name, score);
		helper.close();
		return b;
	}
	
	/**
	 * ��ѯѧ���ɼ�
	 */
	public HashMap<String, String> getStudentScore(String student_Id){
		HashMap<String, String> map;
		helper = new JdbcHelp();
		map = helper.getStudentScore(student_Id);
		helper.close();
		return map;
		
	}
	
//	/**
//	 * ����ѧ�źͿγ�����ѯָ���ĳɼ�
//	 */
//	public String getStudentScore(String student_Id,String course_Name){
//		String score = null;
//		helper = new JdbcHelper();
//		score = helper.getStudentScore(student_Id, course_Name);
//		helper.close();
//		return score;
//	}
//	

	/**
	 * �����ض���sql��䷵��ѧ������
	 */
	public Vector<Student> getScores(String sql){
		Vector<Student> students;
		helper = new JdbcHelp();
		students = helper.getScores(sql);
		helper.close();
		return students;
	}

	/**
	 * ��ð༶�ܳɼ�
	 */
	public String getClasse_SumScore(String classe,String grade,String major){
		String sum = null;
		helper = new JdbcHelp();
		sum = helper.getClasse_SumScore(classe, grade, major);
		helper.close();
		return sum;
	}
	
	
	/**
	 * ����ѧ��id���ظ�ѧ����ƽ���ɼ�
	 */
	public String getStudentAvgScore(String student_Id){
		String avg = null;
		helper = new JdbcHelp();
		avg = helper.getStudentAvgScore(student_Id);
		helper.close();
		return avg;
	}
	
	/**
	 * ����ѧ��רҵ���꼶���༶����Ŀ�����Գɼ�����(�ţ������У����񣬲�����)���ظ����͵�ѧ������
	 */
	public String getCount_ScoreType(String grade,String classe,String major,String type,String course_Name){
		String count = null;
		helper = new JdbcHelp();
		count = helper.getCount_ScoreType(grade, classe, major, type, course_Name);
		helper.close();
		return count;
	}
	
	/**
	 * ��ÿγ̵�ƽ����
	 */
	public String getCourseAvg(String course,String major,String classe,String grade){
		String avg = null;
		helper = new JdbcHelp();
		avg = helper.getCourseAvg(course, major, classe, grade);
		helper.close();
		return avg;
	}
	
	/**
	 * ��õ��Ƴɼ�����߷�
	 */
	public String getCourseHighestScore(String course,String major,String classe,String grade){
		String highest = null;
		helper = new JdbcHelp();
		highest = helper.getCourseHighestScore(course, major, classe, grade);
		helper.close();
		return highest;
	}
	
	/**
	 * ��õ��Ƴɼ�����ͷ�
	 */
	public String getCourseLowestScore(String course,String major,String classe,String grade){
		String lowest = null;
		helper = new JdbcHelp();
		lowest = helper.getCourseLowestScore(course, major, classe, grade);
		helper.close();
		return lowest;
	}
	
	/**
	 * ��ð༶��ƽ���ɼ�
	 */
	public String getClasseAvg(String classe,String grade,String major){
		String sum = getClasse_SumScore(classe,grade,major);
		helper = new JdbcHelp();
		String num = helper.getHaveScoreCount(major, classe, grade);
		if(sum!=null && num!=null){
			return String.valueOf((Double.parseDouble(sum)/Double.parseDouble(num)));
		}else{
			return "";
		}
	}
	

	/**
	 * ��óɼ������Ľ��
	 */
	public Vector<AnalyzeResult> analyzeScore(String major, String classe, String grade ){
		Vector<AnalyzeResult> vector ;
		helper = new JdbcHelp();
		vector = helper.analyzeScore(major, classe, grade);
		helper.close();
		return vector;
	}
	
}
