/**
 *
 */
package com.hqj.test;

import com.hqj.model.DB;

public class testDB {
    public static void main(String[] args) {
        if (DB.getConn() != null)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
