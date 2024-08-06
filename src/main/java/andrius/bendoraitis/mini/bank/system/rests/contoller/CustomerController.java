package andrius.bendoraitis.mini.bank.system.rests.contoller;

import andrius.bendoraitis.mini.bank.system.rests.dto.CustomerDto;
import andrius.bendoraitis.mini.bank.system.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(CustomerController.URL)
@RequiredArgsConstructor
public class CustomerController {

    public static final String URL = "/customer";

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        // Todo: create exception handler for unique entity violation
        try {
            return new ResponseEntity<>(customerService.saveCustomerAndAssignToAccount(customerDto), HttpStatus.OK);
        } catch (Exception e) {
            log.error("CreateCustomer finished with error. Cause error:", e);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
