package com.hobby.sharing.domain.Address.api;

import com.hobby.sharing.domain.Address.application.AddressSearchService;
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
