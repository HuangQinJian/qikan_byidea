/**
 *
 */
package com.hqj.test;

import com.hqj.model.DB;

public class testDB {
    public static DB db = new DB();

    public static void main(String[] args) {
        if (db.getConn() != null)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
