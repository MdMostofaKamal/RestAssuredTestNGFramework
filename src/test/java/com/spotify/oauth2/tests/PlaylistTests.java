package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import com.spotify.oauth2.utils.FakerUtils;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static com.spotify.oauth2.utils.FakerUtils.generateDescription;
import static com.spotify.oauth2.utils.FakerUtils.generateName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify Api Oauth 2.0")
@Feature("Playlist Api")
public class PlaylistTests extends BaseTest {
    @Story("Create a playlist Story")
    @Link("https://open.spotify.com/")
    @Link(name = "spotify", type = "spotify-link")
    @Issue("41")
    @TmsLink("test-1-create-playlist")
    @Description("Create Playlist of Spotify Api")
    @Test(description = "Should be able to create playlist")
    public void ShouldBeAbleToCreatePlaylist() {

        Playlist requestPlayList = playlistBuilder(generateName(),generateDescription(),false);
        Response response = PlaylistApi.post(requestPlayList); // deserialize
        assertStatusCode(response.statusCode(), StatusCode.CODE_201 );
        assertPlaylistEqual(response.as(Playlist.class),requestPlayList);


//        Playlist requestPlayList = new Playlist().
//                setName("New Playlist").
//                setDescription("New playlist description").
//                setPublic(false);


//        Playlist responsePlayList  = given().spec(getRequestSpec()).
//                body(requestPlayList).
//
//                when().
//                post("/users/31ljn37vm767ndzozl7t5kztl5xq/playlists").
//
//                then().spec(getResponseSpec()).
//                assertThat().
//                statusCode(201).
//                extract().
//                response().as(Playlist.class);

//        assertThat(responsePlayList.getName(),equalTo(requestPlayList.getName()));
//        assertThat(responsePlayList.getDescription(),equalTo(requestPlayList.getDescription()));
//        assertThat(responsePlayList.getPublic(),equalTo(requestPlayList.getPublic()));
    }

    @Test
    public void ShouldBeAbleToGetPlaylist(){

        Playlist requestPlayList = playlistBuilder("Playlist6F 26z Gwn","Descriptionj41.T#0Jc9T++oV0m+m&amp;",false);
        Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlayListId());
        assertStatusCode(response.statusCode(),StatusCode.CODE_200);
        assertPlaylistEqual(response.as(Playlist.class),requestPlayList);

//        Playlist requestPlayList = new Playlist().
//                setName("New Playlist").
//                setDescription("New playlist description").
//                setPublic(false);


//        Playlist responsePlayList = given().spec(getRequestSpec()).
//                when().
//                get("/playlists/5pwLm2vfabf3Fck8EC013s").
//
//                then().spec(getResponseSpec()).
//                assertThat().
//                statusCode(200).
//                extract().
//                response().
//                as(Playlist.class);

//        assertThat(responsePlayList.getName(),equalTo(requestPlayList.getName()));
//        assertThat(responsePlayList.getDescription(),equalTo(requestPlayList.getDescription()));
//        assertThat(responsePlayList.getPublic(),equalTo(requestPlayList.getPublic()));
    }


    @Test
    public void ShouldBeAbleToUpdatePlaylist(){

        Playlist requestPlayList = playlistBuilder(generateName(),generateDescription(),false);
        Response response = PlaylistApi.update(DataLoader.getInstance().getUpdatePlayListId(),requestPlayList);
        assertStatusCode(response.statusCode(),StatusCode.CODE_200);
        //assertPlaylistEqual(response.as(Playlist.class),requestPlayList); //update json validation korte hoi na,
        //only status code korlei hoi.



//        Playlist requestPlayList = new Playlist().
//                setName("New Playlist").
//                setDescription("New playlist description").
//                setPublic(false);

//        given().spec(getRequestSpec()).
//                body(requestPlayList).
//
//                when().
//                put("/playlists/5pwLm2vfabf3Fck8EC013s").
//
//                then().spec(getResponseSpec()).
//                assertThat().
//                statusCode(200);

    }
    //negative Scenarios
    @Story("Create a playlist Story")
    @Test
    public void ShouldNotAbleToCreatePlaylistWithoutName() {
        Playlist requestPlayList = playlistBuilder("",generateDescription(),false);
        Response response = PlaylistApi.post(requestPlayList);
        assertStatusCode(response.statusCode(),StatusCode.CODE_400);
        assertError(response.as(Error.class),StatusCode.CODE_400);

//         Error responsError = response.as(Error.class);

//        Playlist requestPlayList = new Playlist().
//                setName("").
//                setDescription("New playlist description").
//                setPublic(false);

//        Error responsError = given().spec(getRequestSpec()).
//                body(requestPlayList).
//
//                when().
//                post("/users/31ljn37vm767ndzozl7t5kztl5xq/playlists").
//
//                then().spec(getResponseSpec()).
//                assertThat().
//                statusCode(400).
//                extract().
//                response().
//                as(Error.class);

//        assertThat(responsError.getError().getStatus(),equalTo(400));
//        assertThat(responsError.getError().getMessage(),equalTo("Missing required field: name"));
    }
    @Story("Create a playlist Story")
    @Test
    public void ShouldNotAbleToCreatePlaylistWithExperiedToken() {

        String invalid_token = "12345";

        Playlist requestPlayList = playlistBuilder(generateName(),generateDescription(),false);
        Response response = PlaylistApi.post(invalid_token,requestPlayList);
        assertStatusCode(response.statusCode(),StatusCode.CODE_401);
        assertError(response.as(Error.class),StatusCode.CODE_401);


//        Playlist requestPlayList = new Playlist().
//                setName("New Playlist").
//                setDescription("New playlist description").
//                setPublic(false);

//        assertThat(response.statusCode(),equalTo(401));
//        Error responsError = response.as(Error.class);

//        Error responsError = given().
//                baseUri("https://api.spotify.com").
//                basePath("/v1").
//                header("Authorization","Bearer "+"12345mh23kiuDGHop").
//                contentType(ContentType.JSON).
//                //log().all().
//                body(requestPlayList).
//
//                when().
//                post("/users/31ljn37vm767ndzozl7t5kztl5xq/playlists").
//
//                then().spec(getResponseSpec()).
//                assertThat().
//                statusCode(401).
//                extract().response().as(Error.class);

//        assertThat(responsError.getError().getStatus(),equalTo(401));
//        assertThat(responsError.getError().getMessage(),equalTo("Invalid access token"));
    }

    @Step
    public Playlist playlistBuilder(String name,String description,boolean _public){
        return  Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();
    }
    @Step
    public void assertPlaylistEqual(Playlist responsePlayList,Playlist requestPlayList){
        assertThat(responsePlayList.getName(),equalTo(requestPlayList.getName()));
        assertThat(responsePlayList.getDescription(),equalTo(requestPlayList.getDescription()));
        assertThat(responsePlayList.get_public(),equalTo(requestPlayList.get_public()));
    }

    public void assertError(Error responsError,StatusCode statusCode){
        assertThat(responsError.getError().getStatus(),equalTo(statusCode.code));
        assertThat(responsError.getError().getMessage(),equalTo(statusCode.msg));
    }
    @Step
    public void assertStatusCode(int actualStatusCode,StatusCode statusCode){
        assertThat(actualStatusCode,equalTo(statusCode.code));
    }
}
