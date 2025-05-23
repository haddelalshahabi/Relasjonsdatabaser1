package oslomet.relasjonsdatabaser1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorvognRepository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(MotorvognRepository.class);

    public void lagreMotorvogn(Motorvogn motorvogn) {
        String sql = "INSERT INTO Motorvogn (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        db.update(sql,motorvogn.getPersonnr(),motorvogn.getNavn(),motorvogn.getAdresse(),motorvogn.getKjennetegn(),
                motorvogn.getMerke(),motorvogn.getType());
    }

    public List<Motorvogn> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn";
        return db.query(sql,new BeanPropertyRowMapper(Motorvogn.class));
    }

    //oppgave 2
    public void slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn WHERE personnr=?";
        db.update(sql,personnr);
    }

    public void slettAlleMotorvogner () {
        String sql = "DELETE FROM Motorvogn";
        db.update(sql);
    }

    public List<Bil> hentAlleBiler(){
        String sql = "SELECT * FROM Bil";
        return db.query(sql,new BeanPropertyRowMapper(Bil.class));
    }
}
