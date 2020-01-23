package com.utpl.plansvalidator.planes_api;

import com.utpl.plansvalidator.sql.plandocente.PlanDocente;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlanesApiService {
    @GET("/plan/planificacion/{periodo}/{componente}")
    Call<PlanDocente> getPlanDocente(@Path("periodo") String periodo, @Path("componente") String componente);
}
