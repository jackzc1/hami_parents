package com.soft.service;

import com.soft.model.Mtype;
import com.soft.query.MtypeQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MtypeServiceTest {

    @Autowired
    private MtypeService mtypeService;


    @Test
    public void selectByCondition() {
        MtypeQuery mtypeQuery = new MtypeQuery();
        mtypeQuery.setTname("摇");
        List<Mtype> mtypes = mtypeService.selectByCondition(mtypeQuery);
        for (Mtype mtype : mtypes) {
            System.out.println(mtype);
        }
    }

    @Test
    public void deleteByPrimaryKey() {

        mtypeService.deleteByPrimaryKey(21);
        mtypeService.deleteByPrimaryKey(22);
        mtypeService.deleteByPrimaryKey(23);

    }

    @Test
    public void insert() {

        Mtype mtype = new Mtype();
        mtype.setTname("金属");
        mtype.setTdesc("重金属音乐");
        mtypeService.insert(mtype);

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}