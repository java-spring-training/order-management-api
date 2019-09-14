package api.domain.entities.object;

import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.util.StringUtils;

public class Employee {
    private String email;

    public Employee(String email) {
        Preconditions.checkArgument(!StringUtils.isEmpty(email), "Email is invalid");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
