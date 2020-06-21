package thuissensoren;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ThuisSensorenRouteBuilder extends RouteBuilder implements ApplicationContextAware {

	@Value("${processor.class.name}")
    String processorClassName;
	
    @Value("${scheduler.delay}")
    Integer schedulerDelay;
	
	ApplicationContext applicationContext;
	
	@Override
	public void configure() throws Exception {
		Class<?> clazz = Class.forName(this.processorClassName);

        ThuisSensorenProcessor thuisSensorenProcessor = this.applicationContext.getBean((Class<ThuisSensorenProcessor>) clazz);

        from(String.format("scheduler://dataharvester?delay=%ds", this.schedulerDelay)).process(
            thuisSensorenProcessor
        );
        
        //this.addApiRoutes();
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
