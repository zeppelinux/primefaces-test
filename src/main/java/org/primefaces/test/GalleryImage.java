package org.primefaces.test;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class GalleryImage {

    @EqualsAndHashCode.Include
    UUID id;

    String smallImageUrl;

    String largeImageUrl;

    String description;
}
