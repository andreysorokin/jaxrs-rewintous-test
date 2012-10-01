package com.rewintous.service.cf;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input) {
        return input;
    }

	@GET
	@Path("/echodouble/{input}")
	@Produces("text/plain")
	public String ping2(@PathParam("input") String input) {
		return input+input;
	}
	
	@GET
	@Path("/echotriple/{input}")
	@Produces("text/plain")
	public String ping3(@PathParam("input") String input) {
		return ping2(input) + ping(input);
	}
	
	@GET
	@Path("/echoquartruple/{input}")
	@Produces("text/plain")
	public String ping4(@PathParam("input") String input) {
		return ping2(ping2(input));
	}	
	

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) {
	input.setVal2(input.getVal1());
	return Response.ok().entity(input).build();
    }
}

