package org.shm.crawley.helper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.ocpsoft.prettytime.PrettyTime;
import org.shm.crawley.domain.Latitude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public final class MapperHelper {


    private final Logger log = LoggerFactory.getLogger(MapperHelper.class);

    public MapperHelper() {
    }


    public String latitude2json(Latitude Latitude) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(Latitude);
        } catch (JsonGenerationException e) {
            log.error("latitude2json error", e);
        } catch (JsonMappingException e) {
            log.error("latitude2json error", e);
        } catch (IOException e) {
            log.error("latitude2json error", e);
        }
        return result;
    }

    public static List<Latitude> json2List(String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<Latitude>>() {
        });

    }

    public static Map<String, List<Latitude>> json2Map(String json)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,
                new TypeReference<Map<String, List<Latitude>>>() {
                });

    }


    public static String list2json(Map<String, List<Latitude>> Latitudes)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(Latitudes);

    }

    static public Long getTimeStampFourSquare(String latitude) {
        String value = extractValue(latitude, "createdAt\":", ",");
        return Long.parseLong(value.trim());
    }

    static public String getPrettyTime(Long timeInMillis, Locale locale) {
        String text = "";
        if (timeInMillis != null) {
            Calendar calendar = Calendar.getInstance();
            timeInMillis = timeInMillis * 1000;
            calendar.setTimeInMillis(timeInMillis);
            PrettyTime p = new PrettyTime(locale);
            text = p.format(calendar.getTime());
        }
        return text;
    }

    static private String extractValue(String json, String beginTag,
                                       String endTag) {
        int index = json.indexOf(beginTag) + beginTag.length();
        int endIndex = json.indexOf(endTag, index);
        return json.substring(index, endIndex);
    }


    static public Latitude foureSquareJson2Object(String json, Locale locale) {
        Latitude newLatitude = new Latitude();

        String authors = JsonPath.read(json, "$.meta.code");
        //List<String> authors = JsonPath.read(json, "$.meta.code[1].lat");


        System.out.print("ici" + authors);

        Long timeStamp = getTimeStampFourSquare(json);
        String prettyTime = getPrettyTime(timeStamp, locale);

        String lat = extractValue(json, "lat\":", ",");
        String lng = extractValue(json, "lng\":", ",");


        newLatitude.setTimeStamp(timeStamp);
        newLatitude.setSince(prettyTime);
        newLatitude.setLocation(lat + "," + lng);
        newLatitude.setXpos(lng);
        newLatitude.setYpos(lat);
        newLatitude.setPhotoUrl("https://lh4.googleusercontent.com/-ImKsKoJzCNE/AAAAAAAAAAI/AAAAAAAAgWw/tERvTyJTamI/photo.jpg?sz=50");

        String name = extractValue(json, "name\":\"", "\",");
        String city = extractValue(json, "city\":\"", "\",");
        String country = extractValue(json, "country\":\"", "\"");
        newLatitude.setReverseGeocode(name + ", " + city + " (" + country + ")");
        return newLatitude;
    }

}
