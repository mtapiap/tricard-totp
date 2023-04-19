package cl.tricotcorp.financial.totp.repository.impl;


import cl.tricotcorp.financial.totp.entity.lockresponse.LockResp;
import cl.tricotcorp.financial.totp.repository.SqlRepository;
import cl.tricotcorp.financial.totp.entity.clients.ClientsResp;
import cl.tricotcorp.financial.totp.model.dbResetResponse.DbResetResp;
import cl.tricotcorp.financial.totp.model.dbSetupResponse.DbSetupResp;
import cl.tricotcorp.financial.totp.model.dbVerifyResponse.DbVerifyResp;
import cl.tricotcorp.financial.totp.entity.movements.MovementsReq;
import cl.tricotcorp.financial.totp.entity.movements.MovementsResp;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;

/*
 * Created by Voxcom S.A. on July, 2019
 * Email : contacto@voxcom.cl
 */


@Repository
public class FuncionesJdbcRepository implements SqlRepository {

    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Autowired
    public FuncionesJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public DbSetupResp setupClient(String id, String key, String os) {

        DbSetupResp dbSetupResp;

        //Integer retorno=0;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id)
                                                           .addValue("pinv_key",key)
                                                            .addValue("pinv_os",os);
        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_totp_setup")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR),
                            new SqlParameter("pinv_key", Types.VARCHAR),
                            new SqlParameter("pinv_os", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            dbSetupResp = new Gson().fromJson(result, DbSetupResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return dbSetupResp;
    }

    @Override
    public DbVerifyResp verifyClient(String id, String code) {

        DbVerifyResp dbVerifyResp;

        //Integer retorno=0;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id)
                .addValue("pinv_code",code);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_verify_code")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR),
                            new SqlParameter("pinv_code", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            dbVerifyResp = new Gson().fromJson(result, DbVerifyResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return dbVerifyResp;
    }
    @Override
    public DbResetResp updateValidCode(String id) {

        DbResetResp dbResetResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_update_valid_code")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            dbResetResp = new Gson().fromJson(result, DbResetResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return dbResetResp;
    }
    @Override
    public DbResetResp updateInvalidCode(String id) {

        DbResetResp dbResetResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_update_invalid_code")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            dbResetResp = new Gson().fromJson(result, DbResetResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return dbResetResp;
    }
    @Override
    public LockResp lockClient(String id) {

        LockResp lockResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_locked_client")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            lockResp = new Gson().fromJson(result, LockResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return lockResp;
    }
    @Override
    public DbResetResp lockedCode(String id) {

        DbResetResp dbResetResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_update_locked_code")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            dbResetResp = new Gson().fromJson(result, DbResetResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return dbResetResp;
    }

    @Override
    public ClientsResp getClient(String id) {

        ClientsResp clientsResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_get_client_id")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            clientsResp = new Gson().fromJson(result, ClientsResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return clientsResp;
    }
    @Override
    public ClientsResp getClients() {

        ClientsResp clientsResp;

        //SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", id);

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_get_client_all")
                    .withSchemaName("totp");
//                    .declareParameters(
//                            new SqlParameter("pinv_id", Types.VARCHAR));

//            String result =  simpleJdbcCall.executeFunction(String.class,in);
            String result =  simpleJdbcCall.executeFunction(String.class);
            System.out.println("result: " + result);
            clientsResp = new Gson().fromJson(result, ClientsResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return clientsResp;
    }

    @Override
    public MovementsResp getMovements(MovementsReq movementsReq) {

        MovementsResp movementsResp;

        SqlParameterSource in = new MapSqlParameterSource().addValue("pinv_id", movementsReq.getId())
                .addValue("pinv_fechadesde", movementsReq.getDateFrom())
                .addValue("pinv_fechahasta", movementsReq.getDateUntil())
                .addValue("pinv_status", movementsReq.getStatus());

        try {
            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    //.withProcedureName("get_managers")
                    .withFunctionName("fnc_get_movements_id_all_date_status")
                    .withSchemaName("totp")
                    .declareParameters(
                            new SqlParameter("pinv_id", Types.VARCHAR),
                            new SqlParameter("pinv_fechadesde", Types.VARCHAR),
                            new SqlParameter("pinv_fechahasta", Types.VARCHAR),
                            new SqlParameter("pinv_status", Types.VARCHAR));

            String result =  simpleJdbcCall.executeFunction(String.class,in);
            System.out.println("result: " + result);
            movementsResp = new Gson().fromJson(result, MovementsResp.class);
        }catch (Exception e){
            System.err.println("Error en BD-generate : "+e.toString());
            throw e;
        }
        return movementsResp;
    }

}