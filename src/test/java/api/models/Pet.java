package api.models;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public Pet() {
        this.photoUrls = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Category {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Tag {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Pet pet;

        public Builder() {
            pet = new Pet();
        }

        public Builder id(Long id) {
            pet.setId(id);
            return this;
        }

        public Builder name(String name) {
            pet.setName(name);
            return this;
        }

        public Builder status(String status) {
            pet.setStatus(status);
            return this;
        }

        public Builder category(Long id, String name) {
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            pet.setCategory(category);
            return this;
        }

        public Builder photoUrl(String url) {
            pet.getPhotoUrls().add(url);
            return this;
        }

        public Builder tag(Long id, String name) {
            Tag tag = new Tag();
            tag.setId(id);
            tag.setName(name);
            pet.getTags().add(tag);
            return this;
        }

        public Pet build() {
            return pet;
        }
    }
}
