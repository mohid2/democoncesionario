package com.projectoconcesionario.concesionario.domain.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String message;
    private String token;
}
