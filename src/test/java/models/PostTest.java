package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;


public class PostTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts(); //clear out allll the posts before each test.
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreates_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", post.getContent());
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainsAllPosts_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post ("How to pair successfully");
        assertEquals(true, Post.getAll().contains(post));
        assertEquals(true, Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Post myPost = new Post("Day 1: Intro");
        assertEquals(false, myPost.getPublished()); //should never start as published
    }
    public Post newPost(){
        return new Post("Day1: Intro");
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Post myPost = newPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }
    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception{
        Post.clearAllPosts();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Post myPost = new Post("Day 1: Intro");
        assertEquals(1, myPost.getId());
    }

}