package fr.pierrelemee.puzzles.model;

/**
 * Represents a pet in the Cats vs. Dogs TV show universe.
 *
 * A pet is either a cat or a dog, and is identified by a number, from 1 to n
 */
public class Pet {

    protected PetKind kind;
    protected int identifier;

    public Pet(PetKind kind, int identifier) {
        this.kind = kind;
        this.identifier = identifier;
    }

    public boolean isSameKind(Pet pet) {
        return this.kind == pet.kind;
    }

    public boolean equals(Pet pet) {
        return this.isSameKind(pet) && this.identifier == pet.identifier;
    }

    public static Pet fromString(String value) {
        return new Pet(PetKind.fromChar(value.charAt(0)), Integer.parseInt(value.substring(1)));
    }

    @Override
    public String toString() {
        return String.format("%s%d", this.kind, this.identifier);
    }
}
