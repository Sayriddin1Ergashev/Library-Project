package com.company.LibraryProject.service.mapper;

import com.company.LibraryProject.dto.ProductDto;
import com.company.LibraryProject.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-30T18:49:56+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProdId( product.getProdId() );
        productDto.setProdName( product.getProdName() );
        productDto.setProdColor( product.getProdColor() );
        productDto.setProdType( product.getProdType() );
        productDto.setProdPrice( product.getProdPrice() );

        return productDto;
    }
}
