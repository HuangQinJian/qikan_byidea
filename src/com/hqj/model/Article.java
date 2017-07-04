/**
 *
 */
package com.hqj.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Article {
    public int id;
    public String title;
    @JSONField(format = "yyyy-MM-dd")
    public Date publishdate;
    public Author autor;
    public String content;
    public String advice;
    public Editor editor;
    public Expert expert;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", publishdate="
                + publishdate + ", autor=" + autor + ", content=" + content
                + ", advice=" + advice + ", editor=" + editor + ", expert="
                + expert + "]";
    }
}
