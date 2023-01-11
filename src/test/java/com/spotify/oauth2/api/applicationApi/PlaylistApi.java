package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;


public class PlaylistApi {

    //static String access_token = "BQButTqamwh5dECj3rtXJ9IOvfztgS_KgmncJise3GwmTkzlfy9bGGgUuSQcQG32fx_GczR3g5QbBabrill0Cs8p1jsJoVklxpAtEwNt7mTUSGyv3yIa6lCZjyPkE0lL4yO6woQp2nP14yh9wHcbP9tnDkHMwMNvGedKxyDUswAs_n6KkbfZxAemFly3W-Nk1qnJduVJYAn4DOL-JIirUZzszW14Hp-lnEjrYD8TYKcXhYVm4jTJrzDsoCz4UDKTcsIqn6QoEAKj3hqz";

    @Step
    public static Response post(Playlist requestPlayList) {
        return RestResource.post(USERS +"/"+ConfigLoader.getInstance().getUserId()+PLAYLISTS,getToken(),requestPlayList);
//        return given(getRequestSpec()).
//                body(requestPlayList).
//                header("Authorization","Bearer "+access_token).
//
//                when().
//                post("/users/31ljn37vm767ndzozl7t5kztl5xq/playlists").
//
//                then().spec(getResponseSpec()).
//                extract().
//                response();

    }

    public static Response post(String invalid_token,Playlist requestPlayList) {
        return RestResource.post(USERS+"/"+ConfigLoader.getInstance().getUserId()+PLAYLISTS,invalid_token,requestPlayList);

//        return given(getRequestSpec()).
//                body(requestPlayList).
//                header("Authorization","Bearer "+invalid_token).
//
//                when().
//                post("/users/31ljn37vm767ndzozl7t5kztl5xq/playlists").
//
//                then().spec(getResponseSpec()).
//                extract().
//                response();
    }

    public static Response get(String playlistId) {

        return RestResource.get(PLAYLISTS+"/" + playlistId,getToken());

//        return given(getRequestSpec()).
//                header("Authorization","Bearer "+access_token).
//
//                when().
//                get("/playlists/" + playlistId).
//
//                then().spec(getResponseSpec()).
//                extract().
//                response();
    }

    public static Response update(String playlistId, Playlist requestPlayList) {

        return RestResource.update(PLAYLISTS+"/" + playlistId,getToken(),requestPlayList);

//        return given(getRequestSpec()).
//                body(requestPlayList).
//                header("Authorization","Bearer "+access_token).
//
//                when().
//                put("/playlists/" + playlistId).
//
//                then().spec(getResponseSpec()).
//                extract().
//                response();

    }
}
