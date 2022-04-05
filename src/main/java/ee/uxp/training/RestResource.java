package ee.uxp.training;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.stream.Collectors;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestResource {

    private List<Person> data = new ArrayList<>();

    public RestResource() {
        data.add(new Person().setFirst("First").setLast("Name").setId(UUID.randomUUID()));
        data.add(new Person().setFirst("Second").setLast("Name").setId(UUID.randomUUID()));
        data.add(new Person().setFirst("Third").setLast("Name").setId(UUID.randomUUID()));
        data.add(new Person().setFirst("Fourth").setLast("Name").setId(UUID.randomUUID()));
        data.add(new Person().setFirst("Fifth").setLast("Name").setId(UUID.randomUUID()));
    }

    @GET
    public List<Person> index() {
        return data;
    }

    @POST
    public Person create(Person personData) {
        data.add(
          personData
            .setId(UUID.randomUUID())
        );

        return personData;
    }

    @GET
    @Path("{id}")
    public Person one(@PathParam("id") UUID id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") UUID id) {
        data.remove(
          data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow()
        );

        return Response.ok().build();
    }


}