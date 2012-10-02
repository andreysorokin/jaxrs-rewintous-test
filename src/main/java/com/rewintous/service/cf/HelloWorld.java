package com.rewintous.service.cf;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.core.*;
import com.wordnik.swagger.jaxrs.JavaHelp;

import javax.ws.rs.*;

@Path("/hello.json")
@Api(value = "/hello", description = "Operations about echo service")
@Produces({"application/json"})
public class HelloWorld extends JavaHelp {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    @ApiOperation(value = "Returns unmodified inbound message", notes = "Simple echo service", responseClass = "java.lang.String")
//    @ApiErrors(value = { @ApiError(code = 400, reason = ""),
//    @ApiError(code = 404, reason = "") })
    public String ping(@ApiParam(value = "Input message", required = true) @PathParam("input") String input) {
        return input;
    }

    @GET
	@Path("/echodouble/{input}")
	@Produces("text/plain")
	@ApiOperation(value = "Returns inbound message doubled", notes = "Simple echo service", responseClass = "java.lang.String")
	public String ping2(@ApiParam(value = "Input message", required = true) @PathParam("input") String input) {
		return input+input;
	}
	
	@GET
	@Path("/echotriple/{input}")
	@Produces("text/plain")
	@ApiOperation(value = "Returns inbound message tripled", notes = "Simple echo service", responseClass = "java.lang.String")
	public String ping3(@ApiParam(value = "Input message", required = true) @PathParam("input") String input) {
		return ping2(input) + ping(input);
	}
	
	@GET
	@Path("/echoquartruple/{input}")
	@Produces("text/plain")
	@ApiOperation(value = "Returns inbound message quadrupled", notes = "Simple echo service", responseClass = "java.lang.String")
	public String ping4(@ApiParam(value = "Input message", required = true) @PathParam("input") String input) {
		return ping2(ping2(input));
	}	
	

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    @ApiOperation(value = "Returns inbound message with updated val2 with val1", notes = "Simple echo service",    	
    	responseClass = "com.rewintous.service.cf.JsonBean")
    public Response modifyJson(@ApiParam(value = "Inbound data structure", required = true) JsonBean input) {
	input.setVal2(input.getVal1());
	return Response.ok().entity(input).build();
    }
    
}

