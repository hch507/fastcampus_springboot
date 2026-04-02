package com.example.simple_board.post.service;

import com.example.simple_board.post.db.PostEntity;
import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.post.model.PostRequest;
import com.example.simple_board.post.model.PostViewRequest;
import com.example.simple_board.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final ReplyService replyService;

    public PostEntity create(
            PostRequest postRequest
    ) {
        var entity = PostEntity.builder()
                .boardId(1L)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        PostEntity post = postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")
                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));

        if (!post.getPassword().equals(postViewRequest.getPassword())) {
            throw new RuntimeException("패스워드 에러");
        }

        var replyList= replyService.findAllByPostId(post.getId());
        post.setReplyList(replyList);

        return post;
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(@Valid PostViewRequest postViewRequest) {
        PostEntity post = postRepository.findById(postViewRequest.getPostId())
                .orElseThrow(() -> new RuntimeException("해당 게시글이 존재하지 않습니다."));

        if (!post.getPassword().equals(postViewRequest.getPassword())) {
            throw new RuntimeException("패스워드 에러");
        }

        post.setStatus("UNREGISTERED");
        postRepository.save(post);


    }
}
