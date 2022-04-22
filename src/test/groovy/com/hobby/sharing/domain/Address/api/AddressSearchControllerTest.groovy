package com.hobby.sharing.domain.Address.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class AddressSearchControllerTest extends Specification {

    @Autowired
    MockMvc mvc

    def "SearchAddress"() {
        when:
        def actions = mvc.perform(get("/address/search")
                .param("keyword", "삼성동 100"))
                .andDo(print())

        then:
        actions.andExpect(status().is(200))
        actions.andExpect(jsonPath('$..address').exists())
    }
}
