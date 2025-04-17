package exercise.mapper;

// BEGIN

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProductMapper {
    @Mapping(source = "price", target = "cost")
    @Mapping(source = "title", target = "name")
    @Mapping(source = "vendorCode", target = "barcode")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(source = "cost", target = "price")
    @Mapping(source = "name", target = "title")
    @Mapping(source = "barcode", target = "vendorCode")
    public abstract ProductDTO map (Product model);
    
    @Mapping(source = "price", target = "cost")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);
}
// END
