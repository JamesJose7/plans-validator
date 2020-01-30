package com.utpl.plansvalidator.planes_api;

import com.utpl.plansvalidator.sql.plandocente.Plan;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlanesApiService {
    @GET("/plan/planificacion/{periodo}/{componente}")
    Call<Plan> getPlanDocente(@Path("periodo") String periodo, @Path("componente") String componente);
}
