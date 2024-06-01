package embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(@Column(name="first_name") String firstName,
                         @Column(name="last_name") String lastName) {}
