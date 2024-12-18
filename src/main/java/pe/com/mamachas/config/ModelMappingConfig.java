package pe.com.mamachas.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.mamachas.dto.DetalleOrdenCompraDTO;
import pe.com.mamachas.entity.DetalleOrdenCompraEntity;

@Configuration
public class ModelMappingConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        configureMapping(modelMapper, new PropertyMap<DetalleOrdenCompraDTO, DetalleOrdenCompraEntity>(){
            @Override
            protected void configure() {
                skip(destination.getOrdenCompra());
            }
        });
        return modelMapper;
    }

    private <S, D> void configureMapping(ModelMapper modelMapper, PropertyMap<S, D> propertyMap) {
        modelMapper.addMappings(propertyMap);
    }
}
