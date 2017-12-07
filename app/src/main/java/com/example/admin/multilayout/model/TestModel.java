package com.example.admin.multilayout.model;

/**
 * com.example.admin.multilayout.model
 *
 * @author Swg
 * @date 2017/12/7 11:18
 */
public class TestModel {
    private String img,title,content,tag;

    public TestModel(String img, String title, String content, String tag) {
        this.img = img;
        this.title = title;
        this.content = content;
        this.tag = tag;
    }

    public String getImg() {
        return img;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
