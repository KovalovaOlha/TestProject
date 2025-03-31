package lesson4;

public enum BookGenre {
    FICTION("Fiction", "A literary work based on imagination"),
    NON_FICTION("Non-Fiction", "Based on real events or facts"),
    FANTASY("Fantasy", "Magical worlds and mythical creatures"),
    SCIENCE_FICTION("Science Fiction", "Futuristic science and technology"),
    MYSTERY("Mystery", "Detective stories and thrillers"),
    BIOGRAPHY("Biography", "Life stories of real people"),
    HISTORY("History", "Books about historical events"),
    ROMANCE("Romance", "Love stories and relationships"),
    HORROR("Horror", "Scary and supernatural themes"),
    SELF_HELP("Self-Help", "Books for personal development");

    private final String displayName;
    private final String description;

    BookGenre(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}

