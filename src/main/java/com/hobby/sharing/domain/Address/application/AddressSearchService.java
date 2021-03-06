package com.hobby.sharing.domain.Address.application;

import com.hobby.sharing.domain.Address.exception.AddressSearchFailedException;
import com.hobby.sharing.global.util.client.KakaoLocalClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressSearchService {

    @Value("${kakao.restapi.key}")
    private String restApikey;

    private final KakaoLocalClient kakaoLocalClient;

    public String execute(String keyword) {
        try {
            String json = kakaoLocalClient.searchAddress(restApikey, keyword);
            JSONArray jsonArray = new JSONObject(json).getJSONArray("documents");
            return jsonArray.toString();
        } catch (Exception e) {
            throw AddressSearchFailedException.EXCEPTION;
        }
    }
}
