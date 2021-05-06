package GeneratingsPatterns.Builder;

public class RoleBuilderMain {
    public static void main(String[] args) {
        Role role = new Role.RoleBuilder("User role", 12345L)
                .active(true)
                .type("User")
                .build();
        System.out.println();
        System.out.println(role);
        System.out.println();
    }
}
