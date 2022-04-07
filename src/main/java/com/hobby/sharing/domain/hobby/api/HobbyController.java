package com.hobby.sharing.domain.hobby.api;

import com.hobby.sharing.domain.hobby.application.CreateLikeHobbyService;
import com.hobby.sharing.domain.hobby.application.HobbyListService;
import com.hobby.sharing.domain.hobby.dto.request.CreateLikeHobbyRequest;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController {

    private final HobbyListService hobbyListService;
    private final CreateLikeHobbyService createLikeHobbyService;

    @GetMapping("/hobby")
    public List<HobbyListResponse> getHobbyList() {
        return hobbyListService.execute();
    }

    @PostMapping("/hobby") @PreAuthorize("isAuthenticated()")
    public void createLikeHobby(@RequestBody @Valid CreateLikeHobbyRequest request) {
        createLikeHobbyService.execute(request);
    }
}
