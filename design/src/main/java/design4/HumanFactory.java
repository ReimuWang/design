package design4;

public class HumanFactory extends RoleFactory {

    @Override
    protected Role createRole(String name) {
        return new Human(name);
    }
}