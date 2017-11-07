package com.lanou.test;

import com.lanou.domain.User;
import com.lanou.domain.UserExt;
import com.lanou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class UserTest {

    private SqlSession session;
    private UserMapper mapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        /*打开一个数据库连接对象,同时设置自动提交机制*/
        session = sessionFactory.openSession(true);
    }

    @After
    public void close(){
        session.close();//关闭数据库连接
    }

    @Test
    public void insert(){
        //获得接口对象
        mapper = session.getMapper(UserMapper.class);
        //创建一个用户对象
        User user =new User();
        user.setLoginName("一一");
        user.setLoginPassword("123");
        user.setGender("男");
        user.setAge(13);
        int id = mapper.insertUser(user);//执行插入操作
        System.out.println(id);
    }

    @Test
    public void findAll(){
        mapper = session.getMapper(UserMapper.class);
        //查询所有
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findById(){
        mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(3);
        System.out.println(user);
    }

    @Test
    public void findByName(){
        mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findByName("一一");
        System.out.println(users);
    }

    @Test
    public void deleteById(){
        mapper = session.getMapper(UserMapper.class);
        //返回值代表删除的条数
        int count = mapper.deleteById(2);
        System.out.println(count);
    }
    @Test
    public void updateById(){
        mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(4);

        user.setLoginName("二二");
        user.setLoginName("1");
        mapper.updateById(user);
    }

    @Test
    public void findByNameOrPassword(){
        mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.findByNameOrPassword(null);
        System.out.println(users);

        System.out.println("******");


        User user = new User();
        user.setLoginName("尔尔");
        user.setLoginPassword("123");
        UserExt ext = new UserExt();
        ext.setUser(user);

        List<User> users1 = mapper.findByNameOrPassword(ext);
        System.out.println(users1);
    }

    @Test
    public void updateById2(){
        mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(3);
        user.setLoginName("呜呜");
        user.setLoginPassword("555");
        //动态更新
        int count = mapper.updateById2(user);
        System.out.println(count);
    }

    @Test
    public void findByIds(){
        //构建查询参数
        mapper = session.getMapper(UserMapper.class);
        UserExt userExt = new UserExt();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(3);
        ids.add(4);
        ids.add(5);
        userExt.setIdList(ids);

        //调用批量查询
        List<User> users = mapper.findByIds(userExt);
        System.out.println(users);

    }
}
