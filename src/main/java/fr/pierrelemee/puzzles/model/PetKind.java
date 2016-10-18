package fr.pierrelemee.puzzles.model;

public enum PetKind {

    CAT,
    DOG;

    public static PetKind fromChar(char character) {
        for (PetKind kind: values()) {
            if (kind.name().charAt(0) == character) {
                return kind;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return name().substring(0, 1);
    }
}
