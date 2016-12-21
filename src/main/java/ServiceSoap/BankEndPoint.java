package ServiceSoap;

import io.spring.guides.gs_producing_web_service.GetListBankRequest;
import io.spring.guides.gs_producing_web_service.GetListBankResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by oshchepkovayu on 21.12.16.
 */
@Endpoint
public class BankEndPoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private BankRepository bankRepository = new BankRepository();

//    @Autowired
//    public BankEndPoint(BankRepository bankRepository) {
//        this.bankRepository = bankRepository;
//    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getListBankRequest")
    @ResponsePayload
    public GetListBankResponse getCountrys(@RequestPayload GetListBankRequest request) {
        GetListBankResponse response = new GetListBankResponse();
        response.setBank(bankRepository.getListBank());

        return response;
    }
}
