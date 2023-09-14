package com.example.android_course_ata_2023.Section101.Firebase;

public class Post {
    private int id;
    private String postTitle;
    private String postContent;

    public Post(){

    }

    public Post(int id, String postTitle, String postContent) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postTitle='" + postTitle + '\'' +
                ", postContent='" + postContent + '\'' +
                '}'+"\n";
    }
}
