package design4;

public abstract class RoleFactory {

    public Role create(String name) {
        return this.createRole(name);
    }

    protected abstract Role createRole(String name);
}