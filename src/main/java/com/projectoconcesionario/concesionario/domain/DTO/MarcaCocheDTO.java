package com.projectoconcesionario.concesionario.domain.DTO;

import lombok.*;

/**
 * Pojo de marca coche
 */
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class MarcaCocheDTO {
    private Integer id;
    private String description;
}
