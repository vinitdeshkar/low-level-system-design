package solutions.librarymanagementsystem.models;

import java.util.List;

public class Book {
    private final String id;
    private final String title;
    private final List<String> authors;
    private final List<String> publishers;

    public Book(String id, String title, List<String> authors, List<String> publishers) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publishers = publishers;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", publishers=" + publishers +
                '}';
    }

    public static BookBuilder newBuilder() {
        return new BookBuilder();
    }


    public static class BookBuilder {

        private String id;
        private String title;
        private List<String> authors;
        private List<String> publishers;

        public BookBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthors(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public BookBuilder setPublishers(List<String> publishers) {
            this.publishers = publishers;
            return this;
        }

        public Book build() {
            return new Book(this.id, this.title, this.authors, this.publishers);
        }
    }
}
