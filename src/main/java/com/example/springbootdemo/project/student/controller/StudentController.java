package com.example.springbootdemo.project.student.controller;

import com.example.springbootdemo.project.student.domain.Student;
import com.example.springbootdemo.project.student.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生表(Student)表控制层
 *
 * @author xiaojie
 * @since 2020-08-22 13:33:23
 */
@Controller
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private IStudentService studentService;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    @ResponseBody
    @GetMapping("queryAll")
    public List<Student> queryAll(Student student) {
        return this.studentService.queryAll(student);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 反馈信息
     */
    @ResponseBody
    @PostMapping("insertSave")
    public String insert(Student student) {
        return this.studentService.insert(student) > 0 ? "操作成功" : "操作失败";
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 反馈信息
     */
    @ResponseBody
    @PostMapping("updateSave")
    public String update(Student student) {
        return this.studentService.update(student) > 0 ? "操作成功" : "操作失败";
    }

    /**
     * 删除数据
     *
     * @param sId 主键
     * @return 反馈信息
     */
    @ResponseBody
    @PostMapping("delete")
    public String deleteById(String sId) {
        return this.studentService.deleteById(sId) ? "操作成功" : "操作失败";
    }

}