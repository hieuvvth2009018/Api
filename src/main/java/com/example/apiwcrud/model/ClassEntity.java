package com.example.apiwcrud.model;

import javax.persistence.*;
import java.util.Objects;

public class ClassEntity {
    @Entity
    @Table(name = "class", schema = "class", catalog = "")
    public class classEntity {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "id")
        private int id;
        @Basic
        @Column(name = "name")
        private String name;
        @Basic
        @Column(name = "room")
        private String room;
        @Basic
        @Column(name = "note")
        private String note;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRoom() {
            return room;
        }

        public void setRoom(String room) {
            this.room = room;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.example.apiwcrud.model.ClassEntity that = (com.example.apiwcrud.model.ClassEntity) o;
            return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(note, that.note);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, room, note);
        }
    }

}
