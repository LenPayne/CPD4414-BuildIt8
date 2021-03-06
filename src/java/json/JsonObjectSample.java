/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package json;

import java.io.StringReader;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
@Path("/object")
public class JsonObjectSample {
    /**
     * Produces a basic JSON Object using the JSON Object API
     * @return - The JSON Object
     */
    @GET
    @Produces("application/json")
    public String getAll() {
        JsonObject json = Json.createObjectBuilder()
                            .add("apple", "red")
                            .add("banana", "yellow")
                            .build();
        return json.toString();
    }
    
    /**
     * Consumes a JSON Object and displays its top-level Key/Values to the console
     * @param str - the JSON Object
     */
    @POST
    @Consumes("application/json")
    public void readJson(String str) {
        JsonReader reader = Json.createReader(new StringReader(str));
        JsonObject json = reader.readObject();
        for (String k : json.keySet()) {
            System.out.printf("%s : %s\n", k, json.getString(k));
        }
    }
}
