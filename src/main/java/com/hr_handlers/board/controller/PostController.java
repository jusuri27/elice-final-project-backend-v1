package com.hr_handlers.board.controller;

import com.hr_handlers.board.dto.PostActionResponseDto;
import com.hr_handlers.board.dto.PostDetailResponseDto;
import com.hr_handlers.board.dto.PostRequestDto;
import com.hr_handlers.board.dto.PostResponseDto;
import com.hr_handlers.board.service.PostService;
import com.hr_handlers.global.dto.SuccessResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {

    private final PostService postService;

    @GetMapping
    public SuccessResponse<List<PostResponseDto>> getAllPosts() {
        return postService.getAllPosts();
    }

    // 특정 게시글 상세 조회
    @GetMapping("/{id}")
    public SuccessResponse<PostDetailResponseDto> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    // 게시글 생성
    @PostMapping
    public SuccessResponse<PostActionResponseDto> createPost(@RequestBody PostRequestDto request) {
        return postService.createPost(request);
    }


    // 특정 게시글 수정
    @PutMapping("/{id}")
    public SuccessResponse<PostActionResponseDto> updatePost(@PathVariable Long id, @RequestBody PostRequestDto request) {
        return postService.updatePost(id, request);
    }

    // 특정 게시글 삭제
    @DeleteMapping("/{id}")
    public SuccessResponse<String> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    /*
    // 특정 해시태그로 게시글 조회
    @GetMapping(params = "hashtag")
    public SuccessResponse<List<PostResponseDto>> getPostsByHashtag(@RequestParam String hashtag) {
        return postService.getPostsByHashtag(hashtag);
    }
    */
}
