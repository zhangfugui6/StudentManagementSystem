package zhang.fugui.studentmanagementsystem.dao;


import zhang.fugui.studentmanagementsystem.bean.AnalyzeResult;
import zhang.fugui.studentmanagementsystem.bean.Student;
import zhang.fugui.studentmanagementsystem.bean.User;

import java.util.HashMap;
import java.util.Vector;


//数据库业务处理类
public class ManageHelp {
	private JdbcHelp helper;	//与数据库通信的对象
	
	
	
	/**
	 * 登陆业务处理
	 */
	public boolean Login(User user){
		boolean b = true;
		helper = new JdbcHelp();	//创建与数据库通信的对象
		User newUser = helper.getUser(user);	//获得用户数据
		if(!user.getPassword().equals(newUser.getPassword())){	//比对密码与数据库中的对应密码是否一致
			b = false;
		}
		helper.close();//关闭资源
		return b;
	}

	/**
	 * 检查是否重复登陆的方法
	 */
	public boolean Check_IsLogin(User user){
		boolean b = true;
		int isLogin;
		helper = new JdbcHelp();//创建与数据库通信的对象
		User newUser = helper.getUser(user);
		if(newUser.getIsLogin()==0){
			b = false;
		}
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 返回成功修改登陆情况
	 */
	public boolean  Update_IsLogin(User user){
		helper = new JdbcHelp();//创建与数据库通信的对象
		boolean b = helper.update_IsLogin(user);
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 修改密码业务处理
	 */
	public boolean update_Password(User user,String new_Password){
		boolean b;
		helper = new JdbcHelp();//创建与数据库通信的对象
		b = helper.update_Password(user, new_Password);
		helper.close();//关闭资源
		return b;
	}
	
	
	
	/**
	 * 获得所有院系
	 */	
	public HashMap<String, String>getAllDepartment(){
		helper = new JdbcHelp();
		HashMap<String, String> map;
		map = helper.getAllDepartment();
		helper.close();//关闭资源
		return map;
	}
	
	
	
	/**
	 * 获得所有专业
	 */
	public HashMap<String, String>getAllMajor(){
		helper = new JdbcHelp();
		HashMap<String, String> map;
		map = helper.getAllMajor();
		helper.close();//关闭资源
		return map;
	}
	
	
	
	/**
	 * 根据department_ID返回对应的专业
	 */
	public Vector<String> getMajor(String department_ID){
		helper = new JdbcHelp();
		Vector<String> vector;
		vector = helper.getMajor(department_ID);
		helper.close();
		return vector;
	}

	
	/**
	 * 添加学生业务
	 */
	public boolean addStudent(Student student){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.addStudent(student);
		helper.close();//关闭资源
		return b;
	}
	
	
	/**
	 * 修改学生业务
	 */
	public boolean updateStudent(Student newStudent,String oldStudentID){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.updateStudent(newStudent, oldStudentID);
		helper.close();//关闭资源
		return b;
	}
	
	
	/**
	 * 删除学生业务
	 */
	public boolean deleteStudent(String studentID){
		boolean b = true;
		helper = new JdbcHelp();
		b = helper.deleteStudent(studentID);
		helper.close();
		return b;
	}
	
	
	/**
	 * 根据sql语句返回特定的学生对象集合
	 */
	public Vector<Student> getStudent(String sql){
		Vector<Student> students;
		helper = new JdbcHelp();
		students = helper.getStudent(sql);
		helper.close();
		return students;
	}
	
	
	/**
	 * 根据年级和专业编号编号返回对应的班级
	 */
	public Vector<String> getAllClasse(String grade,String major_ID){
		Vector<String> vector;
		helper = new JdbcHelp();
		vector = helper.getAllClasse(grade,major_ID);
		helper.close();
		return vector;
		
	}
	
	
	
	
	/**
	 *  根据专业编号返回对应的所有课程
	 */
	public Vector<String> getCourse(String major_Id,String grade){
		Vector<String> vector;
		helper = new JdbcHelp();
		vector = helper.getCourse(major_Id,grade);
		helper.close();
		return vector;
	}
	
	
	/**
	 * 添加学生成绩
	 */
	public boolean addStudentScore(Student student,Vector<String> courses){
		boolean b;
		helper = new JdbcHelp();
		b = helper.addStudentScore(student,courses);
		helper.close();
		return b;
	}
	
	
	
	/**
	 * 修改学生成绩
	 */
	public boolean updateStudentScore(String student_Id,String course_Name,String score){
		boolean b;
		helper = new JdbcHelp();
		b = helper.updateStudentScore(student_Id, course_Name, score);
		helper.close();
		return b;
	}
	
	/**
	 * 查询学生成绩
	 */
	public HashMap<String, String> getStudentScore(String student_Id){
		HashMap<String, String> map;
		helper = new JdbcHelp();
		map = helper.getStudentScore(student_Id);
		helper.close();
		return map;
		
	}
	
//	/**
//	 * 根据学号和课程名查询指定的成绩
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
	 * 根据特定的sql语句返回学生集合
	 */
	public Vector<Student> getScores(String sql){
		Vector<Student> students;
		helper = new JdbcHelp();
		students = helper.getScores(sql);
		helper.close();
		return students;
	}

	/**
	 * 获得班级总成绩
	 */
	public String getClasse_SumScore(String classe,String grade,String major){
		String sum = null;
		helper = new JdbcHelp();
		sum = helper.getClasse_SumScore(classe, grade, major);
		helper.close();
		return sum;
	}
	
	
	/**
	 * 根据学生id返回该学生的平均成绩
	 */
	public String getStudentAvgScore(String student_Id){
		String avg = null;
		helper = new JdbcHelp();
		avg = helper.getStudentAvgScore(student_Id);
		helper.close();
		return avg;
	}
	
	/**
	 * 根据学生专业，年级，班级，科目，考试成绩类型(优，良，中，及格，不及格)返回该类型的学生人数
	 */
	public String getCount_ScoreType(String grade,String classe,String major,String type,String course_Name){
		String count = null;
		helper = new JdbcHelp();
		count = helper.getCount_ScoreType(grade, classe, major, type, course_Name);
		helper.close();
		return count;
	}
	
	/**
	 * 获得课程的平均分
	 */
	public String getCourseAvg(String course,String major,String classe,String grade){
		String avg = null;
		helper = new JdbcHelp();
		avg = helper.getCourseAvg(course, major, classe, grade);
		helper.close();
		return avg;
	}
	
	/**
	 * 获得单科成绩的最高分
	 */
	public String getCourseHighestScore(String course,String major,String classe,String grade){
		String highest = null;
		helper = new JdbcHelp();
		highest = helper.getCourseHighestScore(course, major, classe, grade);
		helper.close();
		return highest;
	}
	
	/**
	 * 获得单科成绩的最低分
	 */
	public String getCourseLowestScore(String course,String major,String classe,String grade){
		String lowest = null;
		helper = new JdbcHelp();
		lowest = helper.getCourseLowestScore(course, major, classe, grade);
		helper.close();
		return lowest;
	}
	
	/**
	 * 获得班级的平均成绩
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
	 * 获得成绩分析的结果
	 */
	public Vector<AnalyzeResult> analyzeScore(String major, String classe, String grade ){
		Vector<AnalyzeResult> vector ;
		helper = new JdbcHelp();
		vector = helper.analyzeScore(major, classe, grade);
		helper.close();
		return vector;
	}
	
}
