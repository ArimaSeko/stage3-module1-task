package com.mjc.school.repository.implementation.model;

public class Author {
    private long id;
    private String name;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author() {}

    public static class AuthorBuilder{
        private Author author;
        public AuthorBuilder(){
            author = new Author();
        }
        public void setId(long id){author.setId(id);}
        public void setName(String name){author.setName(name);}
        public Author build (){return author;}
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
