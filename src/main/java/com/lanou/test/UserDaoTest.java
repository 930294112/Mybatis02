package com.lanou.test;

import com.lanou.domain.User;
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
import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class UserDaoTest {

    private SqlSession session;


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

        //创建一个用户对象
        User user =new User();
        user.setLoginName("四四");
        user.setLoginPassword("123");
        user.setGender("男");
        user.setAge(13);
        //原始dao层的写法,直接调用映射文件中的id
        //其中test对应namespace的值
        //第二个参数的user对应insertUser中需要参数
        session.insert("test.insertUser",user);

    }
//
//    @Test
//    public void findAll(){
//
//        //查询所有
//        List<User> users = mapper.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void findById(){
//
//        User user = mapper.findById(3);
//        System.out.println(user);
//    }
//
//    @Test
//    public void findByName(){
//
//        List<User> users = mapper.findByName("一一");
//        System.out.println(users);
//    }
//
//    @Test
//    public void deleteById(){
//
//        mapper.deleteById(2);
//    }
//    @Test
//    public void updateById(){
//
//        User user = mapper.findById(4);
//
//        user.setLoginName("二二");
//        user.setLoginName("1");
//        mapper.updateById(user);
//    }
}
