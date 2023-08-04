package com.github.supercodingspringproject.web.controller;

import com.github.supercodingspringproject.service.UserSneakerItemService;
import com.github.supercodingspringproject.web.dto.SimpleSneakerInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user-items")
@RequiredArgsConstructor
@Slf4j
public class UserSneakerItemController {

    private final UserSneakerItemService userSneakerItemService;

    @GetMapping("/sneakers")
    public Page<SimpleSneakerInfo> findPageableSneakers(Pageable pageable){
        return userSneakerItemService.findPopularSimpleSneakerInfo(pageable);
    }

}
