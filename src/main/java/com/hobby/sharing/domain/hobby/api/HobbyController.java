package com.hobby.sharing.domain.hobby.api;

import com.hobby.sharing.domain.hobby.application.CreateLikeHobbyService;
import com.hobby.sharing.domain.hobby.application.HobbyUnlikeService;
import com.hobby.sharing.domain.hobby.application.SelectAllHobbyService;
import com.hobby.sharing.domain.hobby.application.SelectLikeHobbyService;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import com.hobby.sharing.domain.hobby.dto.response.SelectLikeHobbyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController {

    private final HobbyUnlikeService hobbyUnlikeService;
    private final SelectAllHobbyService selectAllHobbyService;
    private final CreateLikeHobbyService createLikeHobbyService;
    private final SelectLikeHobbyService selectLikeHobbyService;

    @GetMapping("/hobby")
    public List<HobbyListResponse> getHobbyList() {
        return selectAllHobbyService.execute();
    }

    @GetMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public List<SelectLikeHobbyResponse> getAllLikeHobby() {
        return selectLikeHobbyService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public void createLikeHobby(@RequestBody LikeHobbyRequest request) {
        createLikeHobbyService.execute(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/hobby/unlike") @PreAuthorize("isAuthenticated()")
    public void unlikeHobby(@RequestBody LikeHobbyRequest request) {
        hobbyUnlikeService.execute(request);
    }
}
