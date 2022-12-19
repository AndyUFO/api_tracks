package org.bedu.spotify.repository.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.bedu.spotify.entity.Track;
import org.bedu.spotify.repository.ISpotifyRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Repository
@Slf4j
public class ISpotifyRepositoryImpl implements ISpotifyRepository {
    private String uri ="https://accounts.spotify.com/api/token";
    private String clientID = "13c9d0a6fc404b039ddadae05db16622";
    private String secret = "d9fc3bf75322454e86c84d845ba08990";
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    @Override
    public String getToken() throws IOException, InterruptedException {
        String formatted = clientID + ":" + secret;
        String encoded = Base64.getEncoder().encodeToString((formatted).getBytes());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .headers("Accept", "application/json", "Content-Type", "application/x-www-form-urlencoded","Authorization", "Basic " + encoded)
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials")).build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        var objectMapper = new ObjectMapper();

        String requestBody = objectMapper.readTree(response.body().toString()).get("access_token").toString();

        requestBody = requestBody.replaceAll("\"","");

        log.debug("token limpio:"+requestBody);

        return requestBody;
    }

    @Override
    public List<Track> findTracks(String token, String search) throws Exception {
        String uri="https://api.spotify.com/v1/search?q="+search+"&type=track&market=ES&limit=10&offset=5";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .headers("Accept", "application/json", "Content-Type", "application/json","Authorization", "Bearer " + token)
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        JsonNode root = mapper.readTree(response.body());
        log.debug("toString :"+root.get("tracks").get("items"));

        Track[] trackList = mapper.readValue(root.get("tracks").get("items").toString(),Track[].class);
        log.info("El tamaño de la lista encontrada en Spotify es de "+trackList.length);

        if(trackList.length > 0){
            return Arrays.stream(trackList).toList();
        }else{
            String errMsg = "No existen tracks con la palabra :" +search;
            log.error(errMsg);
            throw new Exception(errMsg);
        }
    }

    @Override
    public List<Track> findTracks(String token, String search,int size) throws Exception {
        String uri="https://api.spotify.com/v1/search?q="+search+"&type=track&market=ES&limit="+size+"&offset=5";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .headers("Accept", "application/json", "Content-Type", "application/json","Authorization", "Bearer " + token)
                .GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        JsonNode root = mapper.readTree(response.body());
        log.debug("toString :"+root.get("tracks").get("items"));

        Track[] trackList = mapper.readValue(root.get("tracks").get("items").toString(),Track[].class);
        log.info("El tamaño de la lista encontrada en Spotify es de "+trackList.length);

        if(trackList.length > 0){
            return Arrays.stream(trackList).toList();
        }else{
            String errMsg = "No existen tracks con la palabra :" +search;
            log.error(errMsg);
            throw new Exception(errMsg);
        }
    }
}
