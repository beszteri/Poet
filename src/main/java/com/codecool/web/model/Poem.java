package com.codecool.web.model;

import java.util.Objects;

public class Poem extends AbstractModel{

    private final int userId;
    private final String title;
    private final String content;

    public Poem(int id, int userId, String title, String content) {
        super(id);
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Poem poem = (Poem) o;
        return userId == poem.userId &&
            Objects.equals(title, poem.title) &&
            Objects.equals(content, poem.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, title, content);
    }
}
