package com.test.gmart.service.troli;

import com.test.gmart.dto.troli.TroliDTO;
import com.test.gmart.model.troli.TrolliModel;
import com.test.gmart.repository.troli.TroliRepository;
import com.test.gmart.repository.troli.TrolliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TroliService {
    @Autowired
    private TroliRepository troliRepository;
    @Autowired
    private TrolliRepository trolliRepository;

    //Get All Items
    public List<TroliDTO> getAll(int userId) {
        List<TroliDTO> results = new ArrayList<>();
        List<TrolliModel> troli = troliRepository.findAllByUserId(userId);
        if (troli != null) {
            troli.forEach(troliModel -> {
                TroliDTO dto = new TroliDTO();
                Integer totalHarga = troliRepository.getTotalHarga(troliModel.getIdTroli());
                String titleProduct = troliRepository.getTitleProduct(troliModel.getIdTroli());
                Integer hargaProduct = troliRepository.getHargaProduct(troliModel.getIdTroli());
                String userName = troliRepository.getUserName(troliModel.getIdTroli());
                dto.setTitleProduct(titleProduct);
                dto.setHargaProduct(hargaProduct);
                dto.setUserName(userName);
                dto.setQtyProduct(troliModel.getQtyTroli());
                dto.setTotalHarga(totalHarga);

                results.add(dto);
            });
        }
        return results;
    }

    public TrolliModel addTroli(int idProduk, int idUser, int qty){
        TrolliModel troliModel = new TrolliModel();
        troliModel.setIdProduk(idProduk);
        troliModel.setIdUser(idUser);
        troliModel.setQtyTroli(qty);
        troliModel.setCreatedAt(LocalDateTime.now());

        return troliRepository.save(troliModel);
    }


//    public AddTroliDTO updateTroli(int idTroli,TroliModel model){
//        Optional<TroliModel> findById = troliRepository.findById(idTroli);
//        if (findById.isEmpty()){
//            return null;
//        } else {
//            TroliModel get = findById.get();
//            TroliModel troliModel = new TroliModel();
//            troliModel.setProductModel(model.getProductModel());
//            troliModel.setUserModel(get.getUserModel());
//            troliModel.setQtyTroli(model.getQtyTroli());
//            troliModel.setCreatedAt(get.getCreatedAt());
//            troliModel.setUpdatedAt(model.getUpdatedAt());
//
//            return converDTO(troliModel);
//        }
//
//    }

}
