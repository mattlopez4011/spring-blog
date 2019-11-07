package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts_details") //Table name
public class PostDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean isAwesome;
    @Column(columnDefinition = "TEXT")
    private String historyOfPost;

    @Column(columnDefinition = "VARCHAR(255)")
    private  String topicDescription;

    @OneToOne(mappedBy = "postDetails")
    private Post post;

    public PostDetails() {
    }

    public PostDetails(boolean isAwesome, String historyOfPost, String topicDescription, Post post) {
        this.isAwesome = isAwesome;
        this.historyOfPost = historyOfPost;
        this.topicDescription = topicDescription;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

     //√ 2. Add the needed annotations to map the one-to-one relationship between Post and PostDetails.
        //√ 3. Seed a couple of entries into the PostDetails and Posts table
            // 4. Add a GetMapping method to the PostController that returns a simple view that displays a given post's historyOfPost detail.
