/**
 *
 */
package com.hqj.service;

import com.hqj.model.Article;
import com.hqj.model.Expert;

import java.util.Date;

public interface ExpertService {
    public boolean add(Expert expert);

    public boolean search(String name, String password);

    public boolean addarticle(Article article);

    public boolean updatearticle(int id, String expertname, String expertidea, Date experttime);

    public boolean delarticle(Article article);
}
