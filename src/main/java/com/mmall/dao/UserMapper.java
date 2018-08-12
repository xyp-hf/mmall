package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条用户数据
     * @param record 用户信息
     */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    /**
     * 更新用户信息
     * @param record 用户信息
     */
    int updateByPrimaryKeySelective(User record);
    /**
    * kkkkkk
    * @since 2018年08月03日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param record 
    * @return
    */
    int updateByPrimaryKey(User record);

    /**
     * 查询用户名个数
     * @param username 用户名
     * @return 用户名个数
     */
    int checkUsername(String username);

    /**
     * 查询邮箱
     * @param email 邮箱
     */
    int checkEmail(String email);
    // Mybatis在传递多个参数的时候，需要用到Param注解
    // 用了这注解之后我们在写SQL对应的时候,我们就要对应注解里面的String
    // 如果不声明的时候是和这个相同的,如果声明的话就对应注解里面的String

    /**
     * 查询用户是否存在
     * @param username 用户名
     * @param password 用户密码
     * @return user 不等于 null 即用户存在
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 查询密码找回问题
     * @param username 用户名
     */
    String selectQuestionUsername(String username);

    /**
     * 校验密码找回问题答案
     * @param username 用户名
     * @param question 密码找hiU问题
     * @param answer 密码找回答案
     */
    int checkAnswer(@Param("username")String username,@Param("question")String question, @Param("answer")String answer);

    /**
     * 更新密码
     * @param username 用户名
     * @param passwordNew 新密码
     */
    int updatePasswordByUsername(@Param("username")String username,@Param("passwordNew")String passwordNew);

    /**
     * 重置密码
     * @param password 用户名
     * @param userId 用户id
     */
    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    /**
     * 校验邮箱是否存在
     * @param email 邮箱
     * @param userId 用户id
     */
    int checkEmailByUserId(@Param(value="email")String email,@Param(value="userId")Integer userId);
}