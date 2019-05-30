package com.example.zuoye2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.ArrayList;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class Bean_Three {

    @Id
            private Long id;
    @Property
            private String category;
    @Property
            private String author_name;
    @Property
            private String thumbnail_pic_s02;
@Generated(hash = 1511611055)
public Bean_Three(Long id, String category, String author_name,
        String thumbnail_pic_s02) {
    this.id = id;
    this.category = category;
    this.author_name = author_name;
    this.thumbnail_pic_s02 = thumbnail_pic_s02;
}
@Generated(hash = 1244374561)
public Bean_Three() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getCategory() {
    return this.category;
}
public void setCategory(String category) {
    this.category = category;
}
public String getAuthor_name() {
    return this.author_name;
}
public void setAuthor_name(String author_name) {
    this.author_name = author_name;
}
public String getThumbnail_pic_s02() {
    return this.thumbnail_pic_s02;
}
public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
    this.thumbnail_pic_s02 = thumbnail_pic_s02;
}

}
