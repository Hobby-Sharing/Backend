package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.HobbyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchHobbyNameService {

    private final HobbyRepository hobbyRepository;

    @Transactional(readOnly = true)
    public List<HobbyResponse> execute(String keyword) {
        return hobbyRepository.findByNameContains(keyword, Sort.by(Sort.Direction.ASC, "hobbyName"))
                .stream()
                .map(HobbyResponse::from)
                .toList();
    }
}
