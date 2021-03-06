package com.hobby.sharing.domain.club.application.facade

import com.hobby.sharing.domain.club.dao.ClubMemberRepository
import com.hobby.sharing.domain.club.dao.ClubRepository
import com.hobby.sharing.domain.club.dao.CustomClubRepository
import com.hobby.sharing.domain.club.domain.embed.ClubEmbed
import com.hobby.sharing.domain.club.exception.*
import spock.lang.Specification

class ClubFacadeTest extends Specification {

    private static final Long userId = 1
    private static final Long clubId = 1

    ClubFacade clubFacade
    ClubRepository clubRepository = Stub()
    CustomClubRepository customClubRepository = Stub()
    ClubMemberRepository clubMemberRepository = Stub()

    def setup() {
        clubFacade = new ClubFacade(
                clubRepository,
                customClubRepository,
                clubMemberRepository)
    }

    def "CheckClubNameNotExists"() {
        given:
        final String clubName = "썬더일레븐"
        clubRepository.existsByName(clubName) >> true

        when:
        clubFacade.checkClubNameNotExists(clubName)

        then:
        thrown(ClubAlreadyExistsException)
    }

    def "CheckClubMemberExists"() {
        given:
        final ClubEmbed clubEmbed = new ClubEmbed(userId, clubId)
        clubMemberRepository.existsById(clubEmbed) >> false

        when:
        clubFacade.checkClubMemberExists(clubEmbed)

        then:
        thrown(ClubMemberNotFoundException)
    }

    def "CheckClubMemberNotExists"() {
        given:
        customClubRepository.existsClubMember(_, _) >> true

        when:
        clubFacade.checkClubMemberNotExists(userId, clubId)

        then:
        thrown(ClubMemberAlreadyExistsException)
    }

    def "CheckClubApplyExists"() {
        given:
        customClubRepository.existsClubApply(_, _) >> false

        when:
        clubFacade.checkClubApplyExists(userId, clubId)

        then:
        thrown(ClubApplyNotFoundException)
    }

    def "CheckClubApplyNotExists"() {
        given:
        customClubRepository.existsClubApply(_, _) >> true

        when:
        clubFacade.checkClubApplyNotExists(userId, clubId)

        then:
        thrown(ClubApplyAlreadyExistsException)
    }

    def "CheckClubAdminByUserId"() {
        given:
        customClubRepository.confirmClubAdmin(_, _) >> false

        when:
        clubFacade.checkClubAdmin(userId, clubId)

        then:
        thrown(ClubAdminException)
    }
}
