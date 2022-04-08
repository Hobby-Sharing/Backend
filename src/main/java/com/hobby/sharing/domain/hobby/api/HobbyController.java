package com.hobby.sharing.domain.hobby.api;

import com.hobby.sharing.domain.hobby.application.CreateLikeHobbyService;
import com.hobby.sharing.domain.hobby.application.HobbyListService;
import com.hobby.sharing.domain.hobby.application.HobbyUnlikeService;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController {

    private final HobbyListService hobbyListService;
    private final HobbyUnlikeService hobbyUnlikeService;
    private final CreateLikeHobbyService createLikeHobbyService;

    @GetMapping("/hobby")
    public List<HobbyListResponse> getHobbyList() {
        return hobbyListService.execute();
    }

    @PostMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public void createLikeHobby(@RequestBody LikeHobbyRequest request) {
        createLikeHobbyService.execute(request);
    }

    @DeleteMapping("/hobby/unlike")
    public void unlikeHobby(@RequestBody LikeHobbyRequest request) {
        hobbyUnlikeService.execute(request);
    }
}
