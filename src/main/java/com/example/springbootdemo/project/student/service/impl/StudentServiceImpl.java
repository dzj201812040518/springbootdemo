package com.example.springbootdemo.project.student.service.impl;

import com.example.springbootdemo.project.student.domain.Student;
import com.example.springbootdemo.project.student.mapper.StudentMapper;
import com.example.springbootdemo.project.student.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生表(Student)表服务实现类
 *
 * @author xiaojie xiaojie
 * @since 2020-08-22 13:33:22
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Resource
    private StudentMapper studentMapper;

    /**
     * 通过主键查询
     *
     * @param sId 主键
     * @return Student实例
     */
    @Override
    public Student queryById(String sId) {
        return this.studentMapper.queryById(sId);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return Student列表
     */
    @Override
    public List<Student> queryAll(Student student) {
        return this.studentMapper.queryAll(student);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @Override
    public int insert(Student student) {
        return this.studentMapper.insert(student);
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    /**
     * 通过主键删除数据
     *
     * @param sId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String sId) {
        return this.studentMapper.deleteById(sId) > 0;
    }
}