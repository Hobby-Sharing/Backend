package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.CustomHobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.HobbyResponse;
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
    public List<HobbyResponse> execute(PagingRequest request) {
        return customHobbyRepository.getAllHobby(request);
    }
}
