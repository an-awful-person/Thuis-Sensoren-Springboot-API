package thuissensoren;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thuissensoren.model.Measurement;

@Repository
public interface ThuisSensorenRepository extends JpaRepository<Measurement, String> {

}
