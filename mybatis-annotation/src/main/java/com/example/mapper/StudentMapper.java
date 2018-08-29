package com.example.mapper;

import com.example.domain.Student;
import com.example.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/29 15:03
 */
public interface StudentMapper {

    /**
     * @Select 是查询类的注解，所有的查询均使用这个
     * @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰
     */
    @Select("SELECT * FROM student")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class)
    })
    List<Student> findAll();

    @Select("SELECT * FROM student WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class)
    })
    Student getOne(Long id);

    @Insert("INSERT INTO student(user_name,user_sex) VALUES(#{userName}, #{userSex})")
    void insert(Student student);

    @Update("UPDATE student SET user_name=#{userName} WHERE id =#{id}")
    void update(Student student);

    @Delete("DELETE FROM student WHERE id =#{id}")
    void delete(Long id);
}
