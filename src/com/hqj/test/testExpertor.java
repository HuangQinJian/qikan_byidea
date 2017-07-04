package com.hqj.test;

import com.hqj.model.Expert;
import com.hqj.serviceimpl.ExpertServiceImpl;
import org.junit.Test;

/**
 * Created by 11157 on 2017/7/4.
 */
public class testExpertor {
    ExpertServiceImpl expertService = new ExpertServiceImpl().getInstance();

    @Test
    public void add() {
        Expert expert = new Expert();
        expert.setExpename("chen");
        expert.setExpepass("123");
        if (expertService.add(expert))
            System.out.println("yes");
        else
            System.out.println("no");
    }

    @Test
    public void search() {
        Expert expert = new Expert();
        if (expertService.search("chen", "123"))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
