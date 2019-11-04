import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(9);
        student.setSn(1009);
        student.setName("小红");
        student.setQqMail("11523631@qq.com");
        student.setClassesId(3);
        System.out.println(new Insert().insertStudent(student));
    }

    public boolean insertStudent(Student student){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into student(id,"+"sn,name,qq_mail,classes_id) values " +
                    "(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,student.getId());
            ps.setInt(2,student.getSn());
            ps.setString(3,student.getName());
            ps.setString(4,student.getQqMail());
            ps.setInt(5,student.getClassesId());
            int num = ps.executeUpdate();
            return num > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,null);
        }
        return false;
    }
}
