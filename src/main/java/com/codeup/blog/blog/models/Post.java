package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts") // Table name
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private long id;
    @Column( nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;


    @OneToOne
    private PostDetails postDetails;

//    Empty Constructor
    public Post(){

    }

//    Constructor
    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }
}
