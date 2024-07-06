package ilab.projeto.up.ilab.up.mapper;

import java.util.List;
import java.util.stream.Collectors;

import ilab.projeto.up.ilab.up.dto.FigurinhaRequestDTO;
import ilab.projeto.up.ilab.up.dto.FigurinhaResponseDTO;
import ilab.projeto.up.ilab.up.model.Figurinha;

public class FigurinhaMapper {

    public static Figurinha toEntity(FigurinhaRequestDTO requestDTO) {
        return new Figurinha(
            requestDTO.getNomeFigurinha(),
            requestDTO.getDescricao(),
            requestDTO.getTag(),
            requestDTO.getFoto(),
            null // Neste exemplo, a foto não está sendo mapeada
        );
    }

    public static FigurinhaResponseDTO toResponseDTO(Figurinha entity) {
        FigurinhaResponseDTO responseDTO = new FigurinhaResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setNomeFigurinha(entity.getNomeFigurinha());
       
        responseDTO.setDescricao(entity.getDescricao());
        
        responseDTO.setTag(entity.getTag());
        responseDTO.setAlbum(entity.getAlbum());
        return responseDTO;
    }

     public static List<FigurinhaResponseDTO> toResponseDTOList(List<Figurinha> figurinhas) {
        return figurinhas.stream()
                .map(FigurinhaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
