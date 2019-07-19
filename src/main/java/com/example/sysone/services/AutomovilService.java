package com.example.sysone.services;

import com.example.sysone.entities.Automovil;
import com.example.sysone.components.AutomovilConverter;
import com.example.sysone.components.AutomovilValidator;
import com.example.sysone.exceptions.NoValidNameOpcional;
import com.example.sysone.exceptions.NoValidaNameAuto;
import com.example.sysone.models.AutomovilModel;
import com.example.sysone.repositories.IAutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author janielcito
 */
@Service
public class AutomovilService implements IAutomovilService{

    @Autowired
    private IAutomovilRepository repository;

    @Autowired
    private AutomovilConverter converter;

    @Autowired
    private AutomovilValidator validator;


    private Log log = LogFactory.getLog(AutomovilService.class);

    @Transactional
    public List<AutomovilModel> getAutos(){

        return this.converter.entityToModelList( (List<Automovil>)this.repository.findAll() );
    }

    @Override
    @Transactional
    public ResponseEntity<AutomovilModel> getAuto(Integer id){

        return new ResponseEntity<>( getAutoById( id ), HttpStatus.OK );

    }

    private AutomovilModel getAutoById(Integer id) throws  NullPointerException{
        Automovil a = this.repository.findById(id).orElse(null);
        AutomovilModel model = this.converter.entityToModel(a);
        return model;
    }

    @Override
    @Transactional
    public ResponseEntity<?> deteleAuto(Integer id){

        try{
            this.repository.deleteById ( id );
            return  new ResponseEntity<>("Auto was deleting successfully", HttpStatus.NO_CONTENT);
        } catch (DataAccessException ex){
            return responseNotDB( ex );
        }

    }

    @Override
    @Transactional
    public ResponseEntity<?> updateAuto(@RequestBody AutomovilModel auto, @PathVariable Integer id){

        try {
            this.validator.validateAuto( auto );
            AutomovilModel a = this.getAutoById( id );
            if (a == null) {
                return this.responseNotFound(id);
            }

            a.update( auto );
            Automovil na = this.converter.modelToEntity( a );
            this.repository.save( na );
            return new ResponseEntity<>( a , HttpStatus.CREATED);
        } catch (DataAccessException ex){
            return responseNotDB( ex );
        } catch (NoValidNameOpcional noValidNameOpcional) {
            return new ResponseEntity<>("Nombre de opcional no valido", HttpStatus.NOT_FOUND);
        } catch (NoValidaNameAuto noValidaNameAuto) {
            return new ResponseEntity<>("Nombre de auto no valido", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> createAuto(AutomovilModel auto){

        try{

            this.validator.validateAuto( auto );
            Automovil e =  this.converter.modelToEntity( auto );
            e = this.repository.save( e );
            return new ResponseEntity<>( this.converter.entityToModel( e ), HttpStatus.OK );

        } catch (DataAccessException ex){
            return responseNotDB( ex );
        } catch (NoValidNameOpcional noValidNameOpcional) {
            return new ResponseEntity<>("Nombre de opcional no valido", HttpStatus.NOT_FOUND);
        } catch (NoValidaNameAuto noValidaNameAuto) {
            return new ResponseEntity<>("Nombre de auto no valido", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param ex
     * @return
     */
    private ResponseEntity<?> responseNotDB(DataAccessException ex){
        this.log.error(ex);
        return new ResponseEntity<>("No se pudo conectar a la BD", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> responseNotFound(Integer id){
        this.log.error( " no se encontro id " + id);
        return new ResponseEntity<>("No encontro auot con id igual a " + id, HttpStatus.NOT_FOUND);
    }


}
