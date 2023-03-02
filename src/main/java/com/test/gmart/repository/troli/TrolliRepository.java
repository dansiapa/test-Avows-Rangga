package com.test.gmart.repository.troli;

import com.test.gmart.model.troli.TrolliModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrolliRepository extends JpaRepository<TrolliModel,Integer> {

    @Query("select tm from TrolliModel tm where tm.idUser = :userId")
    List<TrolliModel> findAllByUserId(int userId);

    @Query(value = "SELECT (p.harga * t.qty) as total_harga from " +
            "tbl_troli t inner join tbl_produk p on " +
            "t.id_product = p.id " +
            "where t.id = :idTroli", nativeQuery = true)
    Integer getTotalHarga(int idTroli);
}
