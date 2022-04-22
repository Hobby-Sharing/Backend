package com.hobby.sharing.domain.Address.application

import com.hobby.sharing.domain.Address.exception.AddressSearchFailedException
import com.hobby.sharing.global.util.client.KakaoLocalClient
import spock.lang.Specification

class AddressSearchServiceTest extends Specification {

    AddressSearchService addressSearchService;
    KakaoLocalClient kakaoLocalClient = Stub()

    def setup() {
        addressSearchService = new AddressSearchService(kakaoLocalClient);
    }

    def "Address Search Service"() {
        given:
        kakaoLocalClient.searchAddress() >> { throw new Exception() }

        when:
        addressSearchService.execute()

        then:
        thrown(AddressSearchFailedException)
    }
}