package com.example.jpa.entityGraph.repo;

import com.example.jpa.entityGraph.model.Post;
import com.example.jpa.entityGraph.model.User;

import java.util.Map;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;

/*
    Create by Atiye Mousavi 
    Date: 6/18/2022
    Time: 2:05 PM
**/
public class PostRepository {

    private EntityManagerFactory emf = null;

    public PostRepository(){
        Map properties=new HashMap();
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");

        emf= Persistence.createEntityManagerFactory("entity-graph-pu",properties);
    }
    public Post find(Long id){
        EntityManager entityManager= emf.createEntityManager();

        Post post=entityManager.find(Post.class,id);

        entityManager.close();
        return post;
    }
    public Post findWithEntityGraph(Long id){
        EntityManager entityManager= emf.createEntityManager();

        EntityGraph entityGraph= entityManager.getEntityGraph("post-entity-graph");
        Map<String,Object> properties=new HashMap<>();
        properties.put("javax.persistence.fetchgraph",entityGraph);
        Post post=entityManager.find(Post.class,id,properties);

        entityManager.close();
        return post;
    }
    public Post findWithEntityeGraph2(Long id){
        EntityManager entityManager= emf.createEntityManager();

        EntityGraph<Post> entityGraph= entityManager.createEntityGraph(Post.class);
        entityGraph.addAttributeNodes("subject");
        entityGraph.addAttributeNodes("user");
        entityGraph.addKeySubgraph("comments")
                .addAttributeNodes("user");
        Map<String,Object> properties=new HashMap<>();
        properties.put("javax.persistence.fetchgraph",entityGraph);
        Post post=entityManager.find(Post.class,properties);
        entityManager.close();
        return post;
    }
    public Post findUsingJpql(Long id){
        EntityManager entityManager= emf.createEntityManager();

        EntityGraph entityGraph=entityManager.getEntityGraph("post-entity-graph-with-comment-users");
        Post post=entityManager.createQuery("Select p from Post p where p.id=:id",Post.class)
                .setParameter("id",id)
                .setHint("javax.persistence.fetchgraph",entityGraph)
                .getSingleResult();

        entityManager.close();
        return post;
    }
    public Post findUsingCriteria(Long id){
        EntityManager entityManager= emf.createEntityManager();

        EntityGraph entityGraph=entityManager.getEntityGraph("post-entity-graph-with-comment-users");
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery=criteriaBuilder.createQuery(Post.class);
        Root<Post> root=criteriaQuery.from(Post.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
        TypedQuery<Post> typedQuery=entityManager.createQuery(criteriaQuery);
        typedQuery.setHint("javax.persistence.loadgraph",entityGraph);
        Post post=typedQuery.getSingleResult();

        entityManager.close();
        return post;
    }
    public Post findWithEntityGraph2(Long id) {
        EntityManager entityManager = emf.createEntityManager();

        EntityGraph<Post> entityGraph = entityManager.createEntityGraph(Post.class);
        entityGraph.addAttributeNodes("subject");
        entityGraph.addAttributeNodes("user");
        entityGraph.addSubgraph("comments")
                .addAttributeNodes("user");

        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Post post = entityManager.find(Post.class, id, properties);

        entityManager.close();
        return post;
    }
    public void clean(){emf.close();}

    public User find2(Long id){
        EntityManager entityManager= emf.createEntityManager();

        User post=entityManager.find(User.class,id);

        entityManager.close();
        return post;
    }
}
