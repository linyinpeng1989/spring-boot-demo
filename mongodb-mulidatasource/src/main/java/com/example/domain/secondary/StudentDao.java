package com.example.domain.secondary;

/**
 * @author: Yinpeng.Lin
 * @desc:
 * @date: Created in 2018/8/30 18:53
 */
public interface StudentDao {
    /**
     * 新增学生
     * @param student
     */
    void saveStudent(Student student);

    /**
     * 根据姓名查找学生
     * @param name
     * @return
     */
    Student findStudentByName(String name);

    /**
     * 更新学生
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 删除学生
     * @param id
     */
    void deleteStudentById(Long id);
}
