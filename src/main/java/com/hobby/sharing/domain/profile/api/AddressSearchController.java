package com.hobby.sharing.domain.profile.api;

import com.hobby.sharing.domain.profile.application.AddressSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AddressSearchController {

    private final AddressSearchService addressSearchService;

    @GetMapping("/address/search")
    public String searchAddress(@RequestParam String keyword) {
        return addressSearchService.execute(keyword);
    }
}
