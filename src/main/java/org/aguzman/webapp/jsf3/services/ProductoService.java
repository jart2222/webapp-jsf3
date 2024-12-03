package org.aguzman.webapp.jsf3.services;

import jakarta.ejb.Local;
import org.aguzman.webapp.jsf3.entities.Producto;

import java.util.List;
import java.util.Optional;

@Local// necesario el EJB para que se maneje las transacciones
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
