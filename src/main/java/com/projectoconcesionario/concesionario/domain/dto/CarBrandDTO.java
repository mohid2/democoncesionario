package com.projectoconcesionario.concesionario.domain.dto;

import lombok.*;

/**
 * Pojo de marca coche
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString @Builder
public class CarBrandDTO {
    private Integer id;
    private String description;
}
