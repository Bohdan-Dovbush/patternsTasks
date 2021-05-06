package GeneratingsPatterns.Prototype;

public class PrototypePatternsMain {
    public static void main(String[] args) {
        Roles userRole = (Roles) RoleCathe.roleCatheMap.get("User").cloneRole();
        userRole.roleType();
        Roles adminRole = (Roles) RoleCathe.roleCatheMap.get("Admin").cloneRole();
        adminRole.roleType();
    }
}
