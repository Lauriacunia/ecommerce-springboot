package com.taylor.demoecommerce.persistence.mapper;
import com.taylor.demoecommerce.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import com.taylor.demoecommerce.domain.Category;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings(
        {
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
        }
    )
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "idCategoria", ignore = true)
    Categoria toCategoria(Category category);
}
