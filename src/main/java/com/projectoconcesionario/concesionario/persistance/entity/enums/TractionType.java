package com.projectoconcesionario.concesionario.persistance.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TractionType {
    FRONT_WHEEL_DRIVE("Front Wheel Drive"),
    REAR_WHEEL_DRIVE("Rear Wheel Drive"),
    ALL_WHEEL_DRIVE("All Wheel Drive"),
    FOUR_WHEEL_DRIVE("Four Wheel Drive"),
    FOUR_BY_FOUR("Four by Four");

    private final String description;
}
