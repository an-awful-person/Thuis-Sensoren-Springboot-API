package thuissensoren;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ThuisSensorenRouteBuilder.class)
public class ThuisSensorenProcessor implements Processor {
	
	private DataMine dataMine;

	@Autowired
    private ThuisSensorenRepository thuisSensorenRepository;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		if (this.dataMine == null) {
            this.dataMine = this.createDataMine();
        }

        this.dataMine.mine();
	}
	
	protected DataMine createDataMine() {
		return new DataMine(thuisSensorenRepository);
    }

}
