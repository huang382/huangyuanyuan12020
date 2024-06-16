package com.ruoyi.web.controller.resturant;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.resturant.domain.Student;
import com.ruoyi.resturant.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Anonymous
@Api(tags="学生管理")
@RestController
@RequestMapping("/api/student")
public class StudentController extends BaseController {

    @Autowired
    private IStudentService studentService;
    @ApiOperation(value="取得所有学生列表", notes = "取得所有学生列表")
    @GetMapping("/list0")
    private AjaxResult list0(){

        List<Student> allStudents =  studentService.getStudents();
        return AjaxResult.success(allStudents);
    }
    @ApiOperation(value="取得学生列表",notes = "取得学生列表")

    @ApiImplicitParams({
            @ApiImplicitParam (name = "id",value = "学生id",dataType = "Long",
                    dataTypeClass = Long.class),
            @ApiImplicitParam (name = "sno",value = "学号",dataType = "String",
                    dataTypeClass = String.class),
            @ApiImplicitParam (name = "name",value = "姓名",dataType = "String",
                    dataTypeClass = String.class),
            @ApiImplicitParam (name = "sex",value = "性别",dataType = "String",
                    dataTypeClass = String.class)
    })
    @GetMapping("/list")
    public AjaxResult list(Student student){
        List<Student> list =studentService.selectStudentList(student);
        return AjaxResult.success(list);

    }
    @ApiOperation("根据id查找学生")
    @ApiImplicitParam(name = "id",value = "学生ID",
    required = true,dataType = "long",paramType = "path",
    dataTypeClass = Long.class)

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
       return AjaxResult.success(studentService.selectStudentById(id));
    }
    @ApiOperation("新增学生")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Student student){
        int count = studentService.insertStudent(student);
        if(count > 0){
            return AjaxResult.success();

        }
        return AjaxResult.error();
    }
    @ApiOperation("修改学生信息")
    @PutMapping
    public AjaxResult edit(@RequestBody Student student){
        return AjaxResult.success(studentService.updateStudent(student));
    }
    /**
     * 删除学生信息
     */
    @ApiImplicitParam(name = "id", value = "学生ID",
            required = true, dataType = "long", paramType = "path",
            dataTypeClass = Long.class)
    @ApiOperation("删除学生")
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return AjaxResult.success(studentService.deleteStudentById(id));
    }
}