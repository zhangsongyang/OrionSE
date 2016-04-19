package cn.zsy.eg.mybatis.controller;


import cn.zsy.eg.mybatis.entity.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog = session.selectOne("BlogMapper.selectBlogById", 1);
            System.out.println(blog.toString());

            int blogCount = session.selectOne("BlogMapper.selectBlogCount");
            System.out.println("blogCount: " + blogCount);

            Map<String, Object> map = session.selectOne("BlogMapper.selectBlogByIdWithMap", 1);
            System.out.println(map);


            Map<String, String> mapParam = new HashMap<String, String>();
            mapParam.put("name", "zsy");
            mapParam.put("old", "26");
            List<Blog> blogNameOldList = session.selectList("BlogMapper.selectBlogByNameAndOld", mapParam);
            System.out.println("blogNameOldList: " + blogNameOldList.toString());

//            Blog blogEntity = new Blog();
//            blogEntity.setName("dddddddd");
//            blogEntity.setOld("999");
//            session.insert("BlogMapper.insertBlog", blogEntity);
//            session.commit();

//            int flag = session.delete("BlogMapper.deleteBlog", 10);
//            System.out.println(flag);
//            session.commit();

            Blog blogEntity2 = new Blog();
            blogEntity2.setId(7);
            blogEntity2.setName("dddddddd");
            blogEntity2.setOld("999");
            session.update("BlogMapper.updateBlog", blogEntity2);
            session.commit();

            List<Blog> blogList = session.selectList("BlogMapper.selectBlogList", "2");
            System.out.println(blogList.toString());

        } finally {
            session.close();
        }
    }

}
