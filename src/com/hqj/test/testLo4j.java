package com.hqj.test;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Created by 11157 on 2017/7/11.
 */
public class testLo4j {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Test
    public void one() {
        logger.info("into one method");
        try {
            System.out.println(9 / 0);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        }
        logger.info("out one method");
    }

    public static void main(String[] args) {
        new testLo4j().one();
    }
}
