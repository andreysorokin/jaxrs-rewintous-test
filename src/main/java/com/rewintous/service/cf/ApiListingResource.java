package com.rewintous.service.cf;

import com.wordnik.swagger.core.*;
import com.wordnik.swagger.jaxrs.JavaApiListing;

import javax.ws.rs.*;

@Path("/resources")
@Api("/resources")
@Produces({"application/json"})
public class ApiListingResource extends JavaApiListing {}