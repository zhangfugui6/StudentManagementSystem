package zhang.fugui.studentmanagementsystem.utils;
//����sql���Ĺ�����
public class CreateSql {

	//���ݲ�ѯ���ݡ�ѡ���ѧ�����ﷵ���ض���sql���
	public static String getStudent_Sql(String str,String option){
		String sql = null;
		if("ȫ��".equals(option)){
			sql = "select * from table_Student" ;
		}else if("ѧ��".equals(option)){
			sql = "select * from table_Student where Student_Id like '%"+str+"%'";
		}else if("����".equals(option)){
			sql = "select * from table_Student where Student_Name like '%"+str+"%'";
		}else if("�Ա�".equals(option)){
			sql = "select * from table_Student where Student_Sex like '%"+str+"%'";
		}else if("�꼶".equals(option)){
			sql = "select * from table_Student where Grade like '%"+str+"%'";
		}else if("�༶".equals(option)){
			sql = "select * from table_Student where Classe like '%"+str+"%'";
		}else if("רҵ".equals(option)){
			sql = "select * from table_Student where Major_Name  like '%"+str+"%'";
		}else if("Ժϵ".equals(option)){
			sql = "select * from table_Student where Department_Name like '%"+str+"%'";
		}
		return sql;
	}
	

	//���ݲ�ѯ���ݡ�ѡ���ѧ�����ﷵ���ض���sql���
		public static String getStudent_Sql(String grade,String major,String str,String option){
			String sql = null;
			if("ȫ��".equals(option)){
				sql = "select * from table_Student where Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("ѧ��".equals(option)){
				sql = "select * from table_Student where Student_Id like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("����".equals(option)){
				sql = "select * from table_Student where Student_Name like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("�Ա�".equals(option)){
				sql = "select * from table_Student where Student_Sex like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("�꼶".equals(option)){
				sql = "select * from table_Student where Grade like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}else if("�༶".equals(option)){
				sql = "select * from table_Student where Classe like '%"+str+"%' and Grade='"+grade+"' and Major_Name='"+major+"'" ;
			}
			return sql;
		}
	
	
	
	
}
