package fr.pierrelemee.puzzles.model;

/**
 * A voter chooses which cat has to stay and which dog ha sto leave, if the voter is a cat person, the opposite otherwise
 */
public class Vote {

    private Pet keep;
    private Pet release;
    /**
     * Number of voters
     */
    protected int voters;

    public Vote(Pet keep, Pet release) {
        this(keep, release, 1);
    }

    public Vote(Pet keep, Pet release, int voters) {
        this.keep = keep;
        this.release = release;
        this.voters = voters;
    }

    public int getVoters() {
        return voters;
    }

    public Vote addVoter() {
        this.voters++;
        return this;
    }

    /**
     * Two votes are considered as opposed only if
     *
     * @param vote the vote to compare to
     * @return
     */
    public boolean isOpposedTo(Vote vote) {
        return !this.release.equals(vote.release);
    }

    public boolean isOpposedTo(Pet pet) {
        return this.keep.isSameKind(pet) ? this.keep.equals(pet) : this.release.equals(pet);
    }

    public static Vote fromString(String value) throws Exception {
        return new Vote(Pet.fromString(value.substring(0, value.indexOf(' '))), Pet.fromString(value.substring(value.indexOf(' ') + 1)));
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Vote) && this.keep.equals(((Vote) obj).keep) && this.release.equals(((Vote) obj).release);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.keep, this.release);
    }
}
