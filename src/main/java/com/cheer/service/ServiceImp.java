package com.cheer.service;

import com.cheer.demo.Emp;
import com.cheer.mapper.EmpMapper;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceImp implements Service {
    public static void main(String[] args) {
        Service s = new ServiceImp();
        s.getEmpList();
    }

    @Override
    public List<Emp> getEmpList() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        List<Emp> list =null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);

            list = empMapper.getList();
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }



}
