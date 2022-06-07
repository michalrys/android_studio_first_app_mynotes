package com.michalrys.my_notes.db;

public class Note {
    private Long id;
    private String title;
    private String content;
    private String created;

    public Note() {
    }

    public Note(Long id, String title, String content, String created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("{Note '%s': %s}", title, content);
    }
}