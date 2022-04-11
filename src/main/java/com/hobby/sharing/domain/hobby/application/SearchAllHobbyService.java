package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.CustomHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import com.hobby.sharing.domain.user.dto.request.PagingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchAllHobbyService {

    private final CustomHobbyRepository customHobbyRepository;

    @Transactional(readOnly = true)
    public List<HobbyListResponse> execute(PagingRequest request) {
        return customHobbyRepository.getAllHobby(request);
    }
}
