package com.hobby.sharing.domain.hobby.api;

import com.hobby.sharing.domain.hobby.application.*;
import com.hobby.sharing.domain.hobby.dto.request.LikeHobbyRequest;
import com.hobby.sharing.domain.hobby.dto.response.HobbyResponse;
import com.hobby.sharing.domain.hobby.dto.response.LikeHobbyResponse;
import com.hobby.sharing.domain.user.dto.request.PagingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class HobbyController {

    private final HobbyLikeService hobbyLikeService;
    private final HobbyUnlikeService hobbyUnlikeService;
    private final SearchAllHobbyService searchAllHobbyService;
    private final SearchHobbyNameService searchHobbyNameService;
    private final SearchLikeHobbyService searchLikeHobbyService;


    @GetMapping("/hobby")
    public List<HobbyResponse> getHobbyList(@RequestParam("page") @Min(0) int page,
                                            @RequestParam("size") @Min(1) @Max(50) int size) {
        return searchAllHobbyService.execute(new PagingRequest(page-1, size));
    }

    @GetMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public List<LikeHobbyResponse> getLikeHobbyList() {
        return searchLikeHobbyService.execute();
    }

    @GetMapping("/hobby/search")
    public List<HobbyResponse> searchByHobbyName(@RequestParam("name") String hobbyName) {
        return searchHobbyNameService.execute(hobbyName);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public void hobbyLike(@RequestBody LikeHobbyRequest request) {
        hobbyLikeService.execute(request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/hobby/like") @PreAuthorize("isAuthenticated()")
    public void hobbyUnlike(@RequestBody LikeHobbyRequest request) {
        hobbyUnlikeService.execute(request);
    }
}
