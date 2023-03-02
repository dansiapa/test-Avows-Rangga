package com.test.gmart.controller.troli;

import com.test.gmart.dto.troli.TroliDTO;
import com.test.gmart.model.troli.TrolliModel;
import com.test.gmart.response.DataResponse;
import com.test.gmart.response.HandlerResponse;
import com.test.gmart.service.troli.TroliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/v1/troli", produces = {"application/json"})
public class TroliController {
    @Autowired
    private TroliService troliService;

    @PostMapping("/add")
    public void addTrolli(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("idProduk") int idProduk,
                           @RequestParam("idUser") int idUser,
                           @RequestParam("qty") int qty) throws Exception {


        TrolliModel addTroli = troliService.addTroli(idProduk, idUser, qty);

        if (Objects.nonNull(addTroli)) {
            DataResponse<TrolliModel> dataResponse = new DataResponse<>();
            dataResponse.setData(addTroli);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "001", "Something Wrong");
        }
    }

    @GetMapping("/all")
    public void getAll(HttpServletRequest request, HttpServletResponse response,
                       @RequestParam("idUser") int idUser) throws Exception {


        List<TroliDTO> addTroli = troliService.getAll(idUser);

        if (Objects.nonNull(addTroli)) {
            DataResponse<List<TroliDTO> > dataResponse = new DataResponse<>();
            dataResponse.setData(addTroli);
            HandlerResponse.responseSuccessWithData(response, dataResponse);
        } else {
            HandlerResponse.responseBadRequest(response, "001", "Something Wrong");
        }
    }
}
