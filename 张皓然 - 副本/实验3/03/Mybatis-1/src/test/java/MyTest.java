import com.lyrpx.mapper.EmployeeMapper;
import com.lyrpx.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void test01() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employee = mapper.selectAll();
        for (Employee employees : employee) {
            System.out.println(employees);
        }
        System.out.println("=====================================");
        Employee employees = mapper.selectById(2);
        System.out.println(employees);
    }
    @Test
    public void test02() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println("=====================================");
        Employee users = new Employee(4, "王六", 26, "扫地工");
        int n = mapper.add(users);
        if (n != 0) {
            System.out.println("成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test03() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee users = new Employee();
        users.setId(3);
        users.setName("易班");
        users.setAge(19);
        users.setPosition("总经理");
        int n = mapper.update(users);
        if (n != 0) {
            System.out.println("成功");

        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test04() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int result = mapper.delete(4);
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();

    }
}