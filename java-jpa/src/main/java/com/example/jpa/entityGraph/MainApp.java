package com.example.jpa.entityGraph;

import com.example.jpa.entityGraph.model.Post;
import com.example.jpa.entityGraph.repo.PostRepository;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 2:56 PM
**/
public class MainApp {
    public static void main(String[] args) {
        Long postId=1L;
        Post post=null;
        PostRepository postRepository=new PostRepository();

        //Using EntityManager.find().
        post=postRepository.find(postId);
        post=postRepository.findWithEntityGraph(postId);
        post=postRepository.findWithEntityeGraph2(postId);

        //Using JPQL: Query and TypedQuery
        post=postRepository.findUsingJpql(postId);

        //Using Criteria API
        post=postRepository.findUsingCriteria(postId);

        postRepository.clean();

    }
}
