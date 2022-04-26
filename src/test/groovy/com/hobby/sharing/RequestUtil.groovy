package com.hobby.sharing

import com.hobby.sharing.domain.club.dto.request.ClubRequest
import com.hobby.sharing.domain.club.dto.request.CreateClubRequest

import java.lang.reflect.Field

class RequestUtil {

    static void setField(Object object, String name, Object value) {
        Field field = object.getClass().getDeclaredField(name)
        field.setAccessible(true)
        field.set(object, value)
    }

    static CreateClubRequest makeCreateClubRequest(String hobbyId, String name, String introMessage) {
        CreateClubRequest request = new CreateClubRequest()
        setField(request, "hobbyId", hobbyId)
        setField(request, "name", name)
        setField(request, "introMessage", introMessage)
        return request
    }

    static ClubRequest makeClubRequest(Long userId, Long clubId) {
        ClubRequest request = new ClubRequest();
        setField(request, "userId", userId)
        setField(request, "clubId", clubId)
        return request
    }
}
