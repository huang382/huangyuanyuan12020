package com.ruoyi.web.controller.resturant;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.resturant.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Test
    public void testlist() {
        Student student = new Student();
        // 存在的用户名称
        student.setName("张三");
        AjaxResult result1 = studentController.list(student);
        // 断言：返回的状态是success
        Assertions.assertTrue(result1.isSuccess());

        List<Student> list1 = (List<Student>)(result1.get("data"));
        // 断言：返回的一条数据
        Assertions.assertEquals(list1.size(), 1);
    }
    @Test
    public void testgetInfo() {//1l ：id是1号 长整型
        AjaxResult result1 = studentController.getInfo(1L);
        // 断言：返回的状态是success
        Assertions.assertTrue(result1.isSuccess());

        Student student = (Student)result1.get("data");
        // 断言：返回学生的id是1
        Assertions.assertEquals(student.getId(), 1l);
    }
    @Test
    public void testadd() {
        Student newStudent = new Student();
        newStudent.setName("测试用户");
        newStudent.setSex("0");
        newStudent.setSno("000002");
        AjaxResult result1 = studentController.add(newStudent);

        // 断言：返回的状态是success
        Assertions.assertTrue(result1.isSuccess());
    }
    @Test
    public void testedit() {
        Student updateStudent = new Student();
        updateStudent.setId(3L);
        updateStudent.setName("测试用户3");
        updateStudent.setSex("0");
        AjaxResult result = studentController.edit(updateStudent);
        // 断言：返回的状态是success
        Assertions.assertTrue(result.isSuccess());
        int updateDatas = (int)result.get("data");
        // 断言：更新用户数1条
        Assertions.assertEquals(updateDatas, 1);
    }
    @Test
    public void testremove() {
        // 删除存在的用户
        AjaxResult result = studentController.remove(6L);
        // 断言：返回的状态是success
        Assertions.assertTrue(result.isSuccess());
        int deleteDatas = (int)result.get("data");
        // 断言：删除用户数1条
        Assertions.assertEquals(deleteDatas, 1);

        // 删除不存在的用户
        AjaxResult result1 = studentController.remove(999L);
        int deleteDatas1 = (int)result1.get("data");
        // 断言：删除用户数0条
        Assertions.assertEquals(deleteDatas1, 0);
    }
}
