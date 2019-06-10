package com.lrving.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonTreeData {

    public String id;       //json id
    public String pid;      //
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public Attributes attributes;
    public List<JsonTreeData> children;       //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<JsonTreeData> getChildren() {
        return children;
    }

    public void setChildren(List<JsonTreeData> children) {
        this.children = children;
    }
}