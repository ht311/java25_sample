
public record User(String name, int age) {
    // ここは元々レコードで実現可能な実装
    public User {
        if (age < 0) {
            throw new IllegalArgumentException("age must be non-negative");
        }
        if (name == null || name.isBlank()) { // isBlank()はJava11で追加、空白も検査できるため、isEmpty()よりも便利なことが多い
            throw new IllegalArgumentException("name must be non-null and non-blank");
        }
    }

    public User(String firstName, String lastName, int age) {
        // コンストラクタのオーバーロードをした際に、firstName, lastNameのバリデーションを効かせた後に、
        // this()の宣言が可能になり、より柔軟な実装が可能に
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName must be non-null and non-blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName must be non-null and non-blank");
        }
        var name = firstName + " " + lastName;
        this(name, age);
    }
}
