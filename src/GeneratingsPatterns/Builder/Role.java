package GeneratingsPatterns.Builder;

public class Role {
    private final String roleName;
    private final Long roleNumber;
    private final boolean active;
    private final String type;

    Role(RoleBuilder roleBuilder) {
        super();
        this.roleName = roleBuilder.roleName;
        this.roleNumber = roleBuilder.roleNumber;
        this.active = roleBuilder.active;
        this.type = roleBuilder.type;
    }
    public static class RoleBuilder {
        private final String roleName;
        private final Long roleNumber;
        private boolean active;
        private String type;

        public RoleBuilder(String roleName, Long roleNumber) {
            this.roleName = roleName;
            this.roleNumber = roleNumber;
        }

        public RoleBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public RoleBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Role build(){
            return new Role(this);
        }
    }

    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleNumber=" + roleNumber +
                ", active=" + active +
                ", type='" + type + '\'' +
                '}';
    }
}
