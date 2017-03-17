package peach.main.basicSecurityApp;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/")
public class AppResourceConfig extends ResourceConfig {
	
	public AppResourceConfig() {
        super(MyResource.class);
        register(RolesAllowedDynamicFeature.class);
    }
}
