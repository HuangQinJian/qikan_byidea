/**
 *
 */
package com.hqj.service;

import com.hqj.model.Article;
import com.hqj.model.Editor;

public interface EditorService {

    public boolean add(Editor editor);

    public boolean search(String name, String password);

    public boolean addarticle(Article article);

    public boolean updatearticle(Article article);

    public boolean delarticle(Article article);
}
