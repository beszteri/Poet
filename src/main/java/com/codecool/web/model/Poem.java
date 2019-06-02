package com.codecool.web.model;

import java.util.Objects;

public class Poem extends AbstractModel{

    private final int poetId;
    private final String title;
    private final String content;

    public Poem(int id, int poetId, String title, String content) {
        super(id);
        this.poetId = poetId;
        this.title = title;
        this.content = content;
    }

    public int getPoetId() {
        return poetId;
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
        return poetId == poem.poetId &&
            Objects.equals(title, poem.title) &&
            Objects.equals(content, poem.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poetId, title, content);
    }
}
