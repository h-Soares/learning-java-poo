package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime date;
    private String title;
    private String content;
    private int likes; //melhor performance do que Integer
    private List<Comment> comments = new ArrayList<>();

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //static para NÃO FAZER cópia para cada objeto dessa classe.

    public Post() {
    }

    public Post(LocalDateTime date, String title, String content, Integer likes) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public void addComment (Comment comment)
    {
        comments.add(comment);
    }

    public void removeComment (Comment comment)
    {
        comments.remove(comment);
    }

    public void showComments()
    {
        for(Comment comment : comments)
            System.out.println("text = " + comment.getText());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); //essa classe é MELHOR porque não cria um objeto String a cada " " ***, como faz String, 
        sb.append("moment = " + date.format(fmt)); //mas sim concatena em uma mesma string, em um mesmo objeto:
        sb.append("\ntitle = " + title);           //On the other hand StringBuilder is mutable. When you call append(..) 
        sb.append("\ncontent = " + content);        //it alters the internal char array, rather than creating a new string object.
        sb.append("\nlikes = " + likes);
        return sb.toString(); //USAR STRING BUILDER!!
    }//*** "moment = " + date.format(fmt) + "\ntitle = " + title + "\ncontent = " + content + "\nlikes = " + likes;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}