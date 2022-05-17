package ru.kpfu.itis.baigulova.springsemesterwork.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.AccountDto;
import ru.kpfu.itis.baigulova.springsemesterwork.dto.PostDto;
import ru.kpfu.itis.baigulova.springsemesterwork.helper.TextHelper;
import ru.kpfu.itis.baigulova.springsemesterwork.model.Post;

import ru.kpfu.itis.baigulova.springsemesterwork.model.Account;
import ru.kpfu.itis.baigulova.springsemesterwork.security.details.AccountUserDetails;
import ru.kpfu.itis.baigulova.springsemesterwork.service.AccountService;

import ru.kpfu.itis.baigulova.springsemesterwork.service.PostService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PostController {

    private final PostService postService;
    private final AccountService accountService;

    @Autowired
    public PostController(PostService postService, AccountService accountService) {
        this.postService = postService;
        this.accountService = accountService;
    }

    @GetMapping("/allPosts")
    public String getAllPosts(Model model) {

        List<PostDto> allPosts = postService.getAll();
        Collections.reverse(allPosts);

        allPosts = allPosts.stream()
                .map(post -> new PostDto(post.getId(), post.getTitle(), TextHelper.editText(post.getText()),
                         post.getData(), post.getAccountId(), post.getAccountEmail()))
                .collect(Collectors.toList());

        model.addAttribute("allPosts", allPosts);

        return "allPostsPage";
    }

    @GetMapping("/allFindPosts")
    @ResponseBody
    public List<PostDto> getAllPostsByTitle(@RequestParam(value = "title",required = false) String title) {
        List<PostDto> posts = postService.getPostsByTitleLike(title);
        posts = posts.stream()
                .peek(post -> post.setText(TextHelper.editText(post.getText())))
                .collect(Collectors.toList());

        Collections.reverse(posts);

        return posts;
    }


    @GetMapping("/detailPost/{postId}")
    public String getDetailPost(@PathVariable("postId") Long postId, Model model) {

        PostDto post = postService.getPostById(postId);
        AccountDto author = accountService.getAccountById(post.getAccountId());

        model.addAttribute("author", author);
        model.addAttribute("detailPost", post);

        return "detailsPost";
    }

    @GetMapping("/createPost")
    public String createPost() {

        return "addPost";
    }

    @PostMapping("/createPost")
    public String savePost(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {

        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();

        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        Post post = new Post(title, content, formatForDateNow.format(date), account);

        postService.save(post);

        return "redirect:/allPosts";
    }


}
