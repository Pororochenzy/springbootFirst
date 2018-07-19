package com.how2java.springboot.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired  CategoryMapper categoryMapper;
    //1. 在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
    @RequestMapping("/listCategory")
    public String listCategory(Model m , @RequestParam(value ="start",defaultValue = "0") int start,@RequestParam(value="size",defaultValue = "5")int size){
        //2. 根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start,size,"id asc");
        //3. 因为PageHelper的作用，这里就会返回当前分页的集合了
        //因为这个 PageHelper工具类会帮我们在XML的id=“listCategory”的那SQl里的 自动为我们拼接limit() 做那些工作
        List<Category> cs = categoryMapper.findAll();
        //4. 根据返回的集合List，创建PageInfo对象
        PageInfo<Category> page = new PageInfo<>(cs);


    //5. 把PageInfo对象扔进model，以供后续显示
        m.addAttribute("page",page);
        return "listCategory";
    }
    @RequestMapping("/addCategory")
    public String  addCategory(Category c ){
        System.out.println(c);
        categoryMapper.save(c);
        return "redirect:listCategory";
    }

    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c){
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }

    @RequestMapping("/updateCategory")
    public String updateCategory(Category c)  {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String editCategory(int id,Model m ){
        Category c = categoryMapper.get(id);
        m.addAttribute("c",c);
        return "editCategory";
    }

    @RequestMapping("/category")
    public void  getCategory(@RequestBody Category category){
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }

    @RequestMapping("submitPage")
    public String submitPage(){

        return "submit";
    }
//    @RequestMapping ("/category")
//    public Category getCategory( int id) throws Exception {
//        Category c= categoryMapper.get(id);
//        System.out.println(c);
//        return c;
//    }

}
