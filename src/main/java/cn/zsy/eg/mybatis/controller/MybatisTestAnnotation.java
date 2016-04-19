package cn.zsy.eg.mybatis.controller;


import cn.zsy.eg.mybatis.entity.Blog;
import cn.zsy.eg.mybatis.entity.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTestAnnotation {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper blogMapper = session.getMapper(BlogMapper.class);
            Blog blog = blogMapper.findById(1);
            System.out.println(blog);

//            Blog blog1 = new Blog();
//            blog1.setName("xiaoying");
//            blog1.setOld("77");
//            blogMapper.insertBlogAn(blog1);
//            session.commit();

//            blogMapper.deleteBlogAn(8);
//            session.commit();

            Blog blog2 = new Blog();
            blog2.setId(7);
            blog2.setName("shuiying");
            blog2.setOld("47");
            blogMapper.updateBlogAn(blog2);
            session.commit();

        } finally {
            session.close();
        }
    }

}
