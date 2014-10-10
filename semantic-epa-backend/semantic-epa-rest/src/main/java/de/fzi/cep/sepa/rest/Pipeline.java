package de.fzi.cep.sepa.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fzi.cep.sepa.rest.util.Utils;
import de.fzi.cep.sepa.storage.util.ClientModelTransformer;

@Path("/pipelines")
public class Pipeline {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addPipelines(String pipeline)
	{
		
		
		System.out.println(pipeline);
		
		de.fzi.cep.sepa.model.client.Pipeline ServerPipeline = Utils.getGson().fromJson(pipeline, de.fzi.cep.sepa.model.client.Pipeline.class);
		
		System.out.println("TEST");
		
		System.out.println("\n");
		System.out.println("Streams: " + ServerPipeline.getStreams().size());
		
		for (int i = 0; i < ServerPipeline.getStreams().size(); i++){
			System.out.println(ServerPipeline.getStreams().get(i).getName());
			System.out.println(ServerPipeline.getStreams().get(i).getElementId());
		}
		System.out.println("\n");
		System.out.println("Sepas: " + ServerPipeline.getSepas().size());
		for (int i = 0; i < ServerPipeline.getSepas().size(); i++){
			System.out.println(ServerPipeline.getSepas().get(i).getName());
			System.out.println(ServerPipeline.getSepas().get(i).getElementId());
		}
		System.out.println("\n");
		System.out.println("Action: ");
		System.out.println(ServerPipeline.getAction().getName());
		return "success";
	}

}
