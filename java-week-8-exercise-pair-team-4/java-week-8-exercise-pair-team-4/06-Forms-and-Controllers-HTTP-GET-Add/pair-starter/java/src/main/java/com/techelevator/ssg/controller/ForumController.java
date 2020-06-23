package com.techelevator.ssg.controller;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ForumController {

    private ForumDao forumDao;

    @RequestMapping("/submitPost")
    public String showSubmitPostPage() {

        return "submitPost";
    }

    @RequestMapping("/savePost")
    public String saveNewPost(@RequestParam String userName, String subject, String message){
        forumDao.save(new ForumPost(userName, subject, message, LocalDateTime.now()));
        return "viewPosts";
    }

    @RequestMapping ("/viewPosts")
    public String viewAllPosts(ModelMap modelMap){
        List<ForumPost> allPosts = forumDao.getAllPosts();
        modelMap.put("allPosts", allPosts);
        return "viewPosts";
    }



}
