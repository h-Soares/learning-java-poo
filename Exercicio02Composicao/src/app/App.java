package app;

import java.time.LocalDateTime;
import entities.Comment;
import entities.Post;

public class App {
    public static void main(String[] args) {
        Post post1 = new Post(LocalDateTime.now(), "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
        post1.addComment(new Comment("Have a nice trip"));
        post1.addComment(new Comment("Wow that's awesome!"));

        System.out.println(post1);
        post1.showComments();
        System.out.println();

        Post post2 = new Post(LocalDateTime.now(), "Good night guys", "See you tomorrow", 5);
        post2.addComment(new Comment("Good night"));
        post2.addComment(new Comment("May the Force be with you"));

        System.out.println(post2);
        post1.showComments();
    }
}