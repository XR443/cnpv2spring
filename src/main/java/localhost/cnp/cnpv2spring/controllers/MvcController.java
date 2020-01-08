/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package localhost.cnp.cnpv2spring.controllers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import localhost.cnp.cnpv2spring.calculation.PropertyType;
import localhost.cnp.cnpv2spring.entities.Contract;
import localhost.cnp.cnpv2spring.services.ContractService;
import localhost.cnp.cnpv2spring.services.PolicyHolderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HardLOLMaster
 */
@Controller
public class MvcController {

    private final ContractService contractService = new ContractService();
    private final PolicyHolderService phService = new PolicyHolderService();

    @GetMapping("/view/contracts")
    public String contracts(Model model) {
        model.addAttribute("contracts", contractService.getAll());
        return "contracts";
    }

    @GetMapping("/view/contract")
    public String contract(
            @RequestParam(name = "id", required = false) Long id,
            Model model) {
        Contract contract = (id == null) ? new Contract() : contractService.getById(id);
        List<PropertyType> types = Arrays.asList(
                new PropertyType[]{PropertyType.APARTAMENT,
                    PropertyType.HOUSE,
                    PropertyType.ROOM});
        model.addAttribute("contract", contract);
        model.addAttribute("propertyType", types);
        model.addAttribute("years",
                IntStream.range(1900, (LocalDate.now().getYear() + 1)).toArray());

        return "contract";
    }

    @GetMapping("/view/find")
    public String find(Model model) {
        return "chooseClient";
    }

    @GetMapping("/view/newClient")
    public String create(Model model) {
        return "createClient";
    }

    @GetMapping("/view/updateClient")
    public String update(
            @RequestParam(name = "id", required = true) Long id,
            Model model) {
        model.addAttribute("client", phService.getById(id));
        return "updateClient";
    }
}
