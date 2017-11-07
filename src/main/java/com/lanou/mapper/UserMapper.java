package com.lanou.mapper;

import com.lanou.domain.User;
import com.lanou.domain.UserExt;

import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public interface UserMapper {
    /**
     * 插入一个user对象
     * @param user 要插入的值
     */
    int insertUser(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据名字查询
     * @param name 要查询的名字
     * @return
     */
    List<User> findByName(String name);

    /**
     * 根据主键id进行删除
     * @param id
     */
    int  deleteById(int id);

    /**
     * 根据主键id进行更新
     * @param user 要更新的对象
     */
    void updateById(User user);

    /**
     * 根据user对象动态拼接用户名和密码
     * @param user 要查询的用户名和密码,只对用户名和密码进行动态拼接
     * @return
     */
    List<User> findByNameOrPassword(UserExt user);

    /**
     * 更新user对象
     * @param user 只取用户名和密码进行动态拼接
     * @return
     */
   int updateById2(User user);

    /**
     * 批量查询id
     * @param userExt 该类包含了一个id集合
     * @return
     */
    List<User> findByIds(UserExt userExt);
}
