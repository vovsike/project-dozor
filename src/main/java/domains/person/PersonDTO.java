package domains.person;

import embeded.PersonName;
import io.smallrye.common.constraint.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record PersonDTO(
        @NotNull @Schema(readOnly = true) Long id,
        @NotNull PersonName name,
        Long accountId,
        @NotNull PersonType type
        ) {
}
