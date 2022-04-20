package com.hobby.sharing

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class HobbySharingApplicationTest extends Specification {
    def "contextLoads" () {
        expect:
        true
    }
}
