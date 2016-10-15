package com.michackathon.api.controllers.rest;


import com.google.common.collect.Lists;
import com.michackathon.api.domain.blog.BlogPost;
import com.michackathon.api.domain.blog.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Tomcy John
 */

@Transactional
@RestController
@RequestMapping("/posts")
@PreAuthorize(value = "hasRole('ROLE_USER')")
public class BlogPostRestController {

    private static final Logger log = LoggerFactory.getLogger(BlogPostRestController.class);

    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostConstruct
    public void fillData() {
        List<BlogPost> posts = this.getPosts();
        if (posts.isEmpty()) {
            for (int i = 1; i <= 10; i++) {
                BlogPost post = new BlogPost("Sample blog post title #" + i, "Sample blog post content #" + i);
                blogPostRepository.save(post);
                log.warn(post.toString());
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<BlogPost> getPosts() {
        return Lists.newArrayList(blogPostRepository.findAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BlogPost savePost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
    public BlogPost deletePost(@PathVariable("postId") Long postId) {
        BlogPost blogPost = blogPostRepository.findOne(postId);
        if (blogPost != null) {
            blogPostRepository.delete(blogPost);
        }
        return blogPost;
    }

}
