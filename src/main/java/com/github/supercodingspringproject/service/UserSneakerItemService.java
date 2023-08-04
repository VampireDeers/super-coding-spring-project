package com.github.supercodingspringproject.service;

import com.github.supercodingspringproject.repository.sneaker.Sneaker;
import com.github.supercodingspringproject.repository.sneaker.SneakerRepository;
import com.github.supercodingspringproject.repository.sneakerModelTraits.SneakerModelTrait;
import com.github.supercodingspringproject.repository.sneakerModelTraits.SneakerTrait;
import com.github.supercodingspringproject.web.dto.SimpleSneakerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSneakerItemService {

    private final SneakerRepository sneakerRepository;

    public Page<SimpleSneakerInfo> findPopularSimpleSneakerInfo(Pageable pageable) {
         Page<Sneaker> sneakers =  sneakerRepository.findAll(pageable);
        return sneakers.map( sneaker ->
            new SimpleSneakerInfo(
                    sneaker.getId(),
                    sneaker.getSneakerModelTraits().stream().map(SneakerModelTrait::getTrait).map(SneakerTrait::getDescriptions).collect(Collectors.toList())
            ));
    }
}
