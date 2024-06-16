package com.ruoyi.resturant.mapper;

import com.ruoyi.resturant.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
   //接口只有声明
    List<Student> queryAll();
    /**
     * 查询学生列表
     *
     * @param Student 学生
     * @return 学生集合
     */
    public List<Student> selectStudentList(Student Student);


    /**
     * 查询学生
     *
     * @param id 学生主键
     * @return 学生
     */
    public Student selectStudentById(Long id);


    /**
     * 新增学生
     *
     * @param Student 学生
     * @return 结果
     */
    public int insertStudent(Student Student);

    /**
     * 修改学生
     *
     * @param Student 学生
     * @return 结果
     */
    public int updateStudent(Student Student);

    /**
     * 删除学生
     *
     * @param id 学生主键
     * @return 结果
     */
    public int deleteStudentById(Long id);
}
