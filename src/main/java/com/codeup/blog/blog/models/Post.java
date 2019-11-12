package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<PostImage> postImage;

    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn( name = "user_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;

    //    Empty Constructor
    public Post(){

    }

//    Constructor
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<PostImage> getPostImage() {
        return postImage;
    }

    public void setPostImage(List<PostImage> postImage) {
        this.postImage = postImage;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
