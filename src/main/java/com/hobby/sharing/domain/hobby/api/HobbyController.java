package com.hobby.sharing.domain.hobby.api;

import com.hobby.sharing.domain.hobby.application.HobbyListService;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController {

    private final HobbyListService hobbyListService;

    @GetMapping("/hobby")
    public List<HobbyListResponse> getHobbyList() {
        return hobbyListService.execute();
    }
}
