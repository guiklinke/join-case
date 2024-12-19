package com.join.mappers.qualifiers;

import com.join.entities.Categoria;
import com.join.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriaQualifier {
    private final CategoriaRepository categoriaRepository;

    @Named("idToCategoria")
    public Categoria idToCategoria(final long id) {
        return categoriaRepository.getReferenceById(id);
    }
}
