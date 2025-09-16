package tech.build.consultas.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public enum UsuarioTipo {
    ADMIN,
    DEFAULT
}
