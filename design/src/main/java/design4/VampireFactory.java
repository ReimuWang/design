package design4;

public class VampireFactory extends RoleFactory {

    @Override
    protected Role createRole(String name) {
        return new Vampire(name);
    }
}