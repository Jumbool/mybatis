package test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.dao.IAccountDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream is;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;
    private IUserDao userDao;

    @Before  //在测试方法之前执行
    public void init() throws Exception {
        //读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建sqlSessionFactory的构建者
        builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂创建sqlSessionFactory
        factory = builder.build(is);
        //4.生产sqlSession对象
        session = factory.openSession(true);
        //5.创建dao接口代理对象
        accountDao = session.getMapper(IAccountDao.class);
        userDao = session.getMapper(IUserDao.class);
    }

    @After    //在测试执行之后执行
    public void destory() throws IOException {
        //提交事务，默认是自动开启，所以得手动提交，不然系统会 roll back
        session.commit();
        //释放资源
        session.close();
        is.close();
    }

    @Test
    public void TestfindAll () {
        assert (accountDao != null);
        System.out.println(accountDao);
        System.out.println(userDao.findTotal());
//        List<User> users = userDao.findAll();
//        System.out.println(users);
//        List<Account> accounts = accountDao.findAll();
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
    }
}
