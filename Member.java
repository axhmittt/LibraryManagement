package models;

public class Member {
    public String memberId;
    public String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String toString() {
        return memberId + " - " + name;
    }
}
