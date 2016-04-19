package cn.zsy.eg.mybatis.entity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BlogMapper {

    @Select("select * from Blog where id = #{id}")
    public Blog findById(int id);

    @Insert("insert into Blog(name, old) values(#{name}, #{old})")
    public void insertBlogAn(Blog blog);

    @Update("update Blog set name=#{name}, old=#{old} where id=#{id}")
    public void updateBlogAn(Blog blog);

    @Delete("delete from Blog where id=#{id}")
    public void deleteBlogAn(int id);

}
