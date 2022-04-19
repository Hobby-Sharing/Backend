package com.hobby.sharing.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    ADDRESS_SEARCH_FAILED(500, "SERVER-500-2", "Address Search Failed"),

    INVALID_INPUT_VALUE(400, "COMMON-400-1", " Invalid Input Value"),
    HANDLE_ACCESS_DENIED(403, "COMMON-403-1", "Access is Denied"),
    METHOD_NOT_ALLOWED(405, "COMMON-405-1", "Method Not Allowed"),

    EXPIRED_TOKEN(401, "AUTH-401-1", "Expired Token"),
    INVALID_TOKEN(401, "AUTH-401-2", "Invalid Token"),
    PASSWORD_MISMATCH(401, "AUTH-401-3", "The Password incorrect"),
    TOKEN_REFRESH_FAILED(401, "AUTH-401-4", "Token Refresh Failed"),
    NOT_CLUB_ADMIN(401, "AUTH-401-5", "Admin authority do not exist"),

    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    USER_ALREADY_EXISTS(409, "USER-409-1", "This email is already registered"),

    HOBBY_NOT_FOUND(404, "HOBBY-404-1", "Hobby Not Found"),
    LIKE_HOBBY_NOT_FOUND(404, "HOBBY-404-2", "Like Hobby Not Found"),
    LIKE_HOBBY_ALREADY_EXISTS(409, "HOBBY-409-1", "Hobby already like"),

    CLUB_NOT_FOUND(404, "CLUB-404-1", "Club Not Found"),
    CLUB_APPLY_NOT_FOUND(404, "CLUB_404-2", "Club Apply Not Found"),
    CLUB_MEMBER_NOT_FOUND(404, "CLUB_404-3", "Club Member Not Found"),
    CLUB_ALREADY_EXISTS(409, "CLUB-409-1", "Club name already exists"),
    CLUB_APPLY_ALREADY_EXISTS(409, "CLUB-409-2", "Club apply already exists"),
    CLUB_MEMBER_ALREADY_EXISTS(409, "CLUB-409-3", "Club member already exists"),

    PROFILE_ALREADY_EXISTS(409, "PROFILE-409-1", "This is a registered profile");

    private final int status;
    private final String code;
    private final String message;
}