package com.hobby.sharing.domain.hobby.application;

import com.hobby.sharing.domain.hobby.dao.HobbyRepository;
import com.hobby.sharing.domain.hobby.dto.response.HobbyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SelectAllHobbyService {

    private final HobbyRepository hobbyRepository;

    @Transactional(readOnly = true)
    public List<HobbyListResponse> execute() {
        return hobbyRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream()
                .map(HobbyListResponse::from)
                .toList();
    }
}
