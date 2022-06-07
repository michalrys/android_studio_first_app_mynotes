package com.michalrys.my_notes.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "room_note")
public class RoomNote {
    @PrimaryKey
    private Long id;
    private String title;
    private String content;
    private String created;

    public RoomNote() {
    }

    public RoomNote(String title, String content, String created) {
        this.title = title;
        this.content = content;
        this.created = created;
    }

    public RoomNote(Long id, String title, String content, String created) {
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
        return String.format("'%s' (%s)", title, created);
    }
}