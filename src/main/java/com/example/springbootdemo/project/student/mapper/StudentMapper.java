package com.example.springbootdemo.project.student.mapper;

import com.example.springbootdemo.project.student.domain.Student;

import java.util.List;

/**
 * 学生表(Student)表数据库访问层
 *
 * @author xiaojie xiaojie
 * @since 2020-08-22 13:33:20
 */
public interface StudentMapper {


    /**
     * 通过主键查询
     *
     * @param sId 主键
     * @return Student实例
     */
    Student queryById(String sId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return Student列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 影响行数
     */
    int deleteById(String sId);

}