/**
 *
 */
package com.hqj.service;

import com.hqj.model.Article;
import com.hqj.model.Expert;

public interface ExpertService {
    public boolean add(Expert expert);

    public boolean search(String name, String password);

    public boolean addarticle(Article article);

    public boolean updatearticle(Article article);

    public boolean delarticle(Article article);
}
