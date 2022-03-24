package com.hobby.sharing.global.util.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "KakaoLocalClient", url = "https://dapi.kakao.com")
public interface KakaoLocalClient {

    @GetMapping("/v2/local/search/address.json")
    String searchAddress(@RequestHeader("Authorization") String restApiKey, @RequestParam String query);
}