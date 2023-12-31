package zhang.fugui.studentmanagementsystem.utils;
//生成sql语句的工具类
public class CreateSql {

	//根据查询内容、选项从学生表里返回特定的sql语句
	public static String getStudent_Sql(String str,String option){
		String sql = null;
		if("全部".equals(option)){
			sql = "select * from table_Student" ;
		}else if("学号".equals(option)){
			sql = "select * from table_Student where Student_Id like '%"+str+"%'";
		}else if("姓名".equals(option)){
			sql = "select * from table_Student where Student_Name like '%"+str+"%'";
		}else if("性别".equals(option)){
			sql = "select * from table_Student where Student_Sex like '%"+str+"%'";
		}else if("年级".equals(option)){
			sql = "select * from table_Student where Grade like '%"+str+"%'";
		}else if("班级".equals(option)){
			sql = "select * from table_Student where Classe like '%"+str+"%'";
		}else if("专业".equals(option)){
			sql = "select * from table_Student where Major_Name  like '%"+str+"%'";
		}else if("院系".equals(option)){
			sql = "select * from table_Student where Department_Name like '%"+str+"%'";
		}
		return sql;
	}
	

	//根据查询内容、选项从学生表里返回特定的sql语句
		public static String getStudent_Sql(String grade,String major,String str,String option){
			String sql = null;
			if("全部".equals(option)){
				sql = "select * from table_Student where Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("学号".equals(option)){
				sql = "select * from table_Student where Student_Id like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("姓名".equals(option)){
				sql = "select * from table_Student where Student_Name like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("性别".equals(option)){
				sql = "select * from table_Student where Student_Sex like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("年级".equals(option)){
				sql = "select * from table_Student where Grade like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("班级".equals(option)){
				sql = "select * from table_Student where Classe like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}
			return sql;
		}
	
	
	
	
}
