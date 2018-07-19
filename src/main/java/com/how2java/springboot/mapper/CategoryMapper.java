package com.how2java.springboot.mapper;

        import java.util.List;

        import org.apache.ibatis.annotations.Delete;
        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Mapper;
        import org.apache.ibatis.annotations.Select;
        import org.apache.ibatis.annotations.Update;

        import com.how2java.springboot.pojo.Category;
/**
 * 使用注解@Mapper 表示这是一个Mybatis Mapper接口。
 */
@Mapper
public interface CategoryMapper {
    /**
     *使用@Select注解表示调用findAll方法会去执行对应的sql语句。
     */
    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert(" insert into category_ ( name ) values (#{name}) ")
    public int save(Category category);

    @Delete(" delete from category_ where id= #{id} ")
    public void delete(int id);

    @Select("select * from category_ where id= #{id} ")
    public Category get(int id);

    @Update("update category_ set name=#{name} where id=#{id} ")
    public int update(Category category);

}


