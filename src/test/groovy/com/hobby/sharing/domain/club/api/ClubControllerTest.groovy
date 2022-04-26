package com.hobby.sharing.domain.club.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.hobby.sharing.domain.club.dao.ClubApplyRepository
import com.hobby.sharing.domain.club.dao.ClubMemberRepository
import com.hobby.sharing.domain.club.dao.ClubRepository
import com.hobby.sharing.domain.club.domain.Club
import com.hobby.sharing.domain.club.domain.ClubApply
import com.hobby.sharing.domain.club.domain.ClubMember
import com.hobby.sharing.domain.club.domain.role.ClubRole
import com.hobby.sharing.domain.club.dto.request.ClubRequest
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest
import com.hobby.sharing.domain.hobby.dao.CategoryRepository
import com.hobby.sharing.domain.hobby.dao.HobbyRepository
import com.hobby.sharing.domain.hobby.dao.LikeHobbyRepository
import com.hobby.sharing.domain.hobby.domain.Category
import com.hobby.sharing.domain.hobby.domain.Hobby
import com.hobby.sharing.domain.hobby.domain.LikeHobby
import com.hobby.sharing.domain.user.dao.UserRepository
import com.hobby.sharing.domain.user.domain.User
import com.hobby.sharing.global.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static com.hobby.sharing.RequestUtil.makeClubRequest
import static com.hobby.sharing.RequestUtil.makeCreateClubRequest
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ClubControllerTest extends Specification {

    @Autowired
    MockMvc mvc

    @Autowired
    UserRepository userRepository

    @Autowired
    ClubRepository clubRepository

    @Autowired
    HobbyRepository hobbyRepository

    @Autowired
    CategoryRepository categoryRepository

    @Autowired
    LikeHobbyRepository likeHobbyRepository

    @Autowired
    ClubApplyRepository clubApplyRepository

    @Autowired
    ClubMemberRepository clubMemberRepository

    @Autowired
    ObjectMapper objectMapper

    @Autowired
    JwtTokenProvider jwtTokenProvider

    User user
    Club club
    Hobby hobby
    Category category

    def setup() {
        user = User.builder()
                .email("example123@gmail.com")
                .name("테스트")
                .password("a1234567")
                .roadNameAddress("전북 삼성동 100")
                .zipcode(123456)
                .build()
        userRepository.save(user)

        category = new Category("카테고링")
        categoryRepository.save(category)

        hobby = Hobby.builder()
                .name("취미")
                .category(category)
                .build()
        hobbyRepository.save(hobby)

        club = Club.builder()
                .hobby(hobby)
                .name("농구 동아리")
                .managerEmail(user.getEmail())
                .introMessage("주말에 농구하실 분 구함")
                .build()
        clubRepository.save(club)
    }

    def cleanup() {
        userRepository.deleteAll()
    }

    def "Get Club List"() {
        given:
        LikeHobby likeHobby = LikeHobby.builder()
                .user(user)
                .hobby(hobby)
                .build()
        likeHobbyRepository.save(likeHobby)

        String token = jwtTokenProvider.generateAccessToken(user.getEmail())

        when:
        ResultActions result = mvc.perform(get("/club")
                .header("Authorization", "Bearer " + token))
                .andDo(print())

        then:
        result.andExpect(status().is(200))
    }

    def "Create Club"() {
        given:
        String token = jwtTokenProvider.generateAccessToken(user.getEmail())
        CreateClubRequest request = makeCreateClubRequest(hobby.getId() as String, clubName, "주말에 축구하실 분 구합니다.")

        when:
        ResultActions result = mvc.perform(post("/club")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())

        then:
        result.andExpect(status().is(status))

        where:
        clubName || status
        "축구 동아리" || 201
        "농구 동아리" || 409
    }

    def "Join Club Apply"() {
        given:
        String token = jwtTokenProvider.generateAccessToken(user.getEmail())

        when:
        ResultActions result = mvc.perform(post("/club/join-apply/{club_id}", club.getId())
                .header("Authorization", "Bearer " + token))
                .andDo(print())

        then:
        result.andExpect(status().is(201))
    }


    def "Delete Club Join Apply"() {
        given:
        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(memberRole)
                .build()
        clubMemberRepository.save(clubMember)

        ClubApply clubApply = ClubApply.builder()
                .user(user)
                .club(club)
                .build()
        clubApplyRepository.save(clubApply)

        ClubRequest request = makeClubRequest(user.getId(), club.getId())
        String token = jwtTokenProvider.generateAccessToken(user.getEmail())

        when:
        ResultActions result = mvc.perform(delete("/club/join-apply")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())

        then:
        result.andExpect(status().is(status))

        where:
        memberRole     || status
        ClubRole.ADMIN || 204
        ClubRole.USER  || 401
    }


    def "Club Join Accept"() {
        given:
        User clubUser = User.builder()
                .email("club123@gmail.com")
                .name("농구 장인")
                .password("club123")
                .roadNameAddress("대전 어딘가")
                .zipcode(654321)
                .build()
        userRepository.save(clubUser)

        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(memberRole)
                .build()
        clubMemberRepository.save(clubMember)

        ClubApply clubApply = ClubApply.builder()
                .user(clubUser)
                .club(club)
                .build()
        clubApplyRepository.save(clubApply)

        ClubRequest request = makeClubRequest(clubUser.getId(), club.getId())
        String token = jwtTokenProvider.generateAccessToken(user.getEmail())

        when:
        ResultActions result = mvc.perform(post("/club/join")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())

        then:
        result.andExpect(status().is(status))

        where:
        memberRole     || status
        ClubRole.ADMIN || 201
        ClubRole.USER  || 401
    }

    def "Delete Club Member"() {
        given:
        User clubUser = User.builder()
                .email("delete123@gmail.com")
                .name("삭제될 농구장인")
                .password("help123")
                .roadNameAddress("삭제될 예정입니다")
                .zipcode(000000)
                .build()
        userRepository.save(clubUser)

        ClubMember clubMember = ClubMember.builder()
                .user(user)
                .club(club)
                .role(memberRole)
                .build()
        clubMemberRepository.save(clubMember)

        ClubMember clubMemberUser = ClubMember.builder()
                .user(clubUser)
                .club(club)
                .role(ClubRole.USER)
                .build()
        clubMemberRepository.save(clubMemberUser)

        ClubRequest request = makeClubRequest(clubUser.getId(), club.getId())
        String token = jwtTokenProvider.generateAccessToken(user.getEmail())

        when:
        ResultActions result = mvc.perform(delete("/club/member")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .content(objectMapper.writeValueAsString(request)))
                .andDo(print())

        then:
        result.andExpect(status().is(status))

        where:
        memberRole     || status
        ClubRole.ADMIN || 204
        ClubRole.USER  || 401
    }
}
