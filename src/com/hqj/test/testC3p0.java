package com.hqj.test;

import com.hqj.utils.C3p0Utils;
import org.junit.Test;

/**
 * Created by 11157 on 2017/7/13.
 */
public class testC3p0 {
    @Test
    public void test() {
        System.out.print(C3p0Utils.getConnection());
    }
}
