package GeneratingsPatterns.Prototype;

import java.util.HashMap;
import java.util.Map;

public class RoleCathe {
    public static final Map<String, Roles> roleCatheMap = new HashMap<>();

    static {
        Roles userRole = new UserRole();
        Roles adminRole = new AdminRole();
        roleCatheMap.put("User", userRole);
        roleCatheMap.put("Admin", adminRole);
    }
}
