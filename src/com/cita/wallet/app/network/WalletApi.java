package com.cita.wallet.app.network;

import com.cita.wallet.app.models.LdapResponse;
import com.cita.wallet.app.models.WalletStatement;
import com.cita.wallet.app.models.WalletUser;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by admin on 5/26/14.
 */
public interface WalletApi {

	@GET("/User/{student_id}/")
	WalletUser userInfo(@Path("student_id") String studentId);

	@GET("/Statement_Search")
	WalletStatement.List allStatements(
			@Query("statement_student") String studentId);

	@GET("/Statement_Search")
	WalletStatement.List statementsByDate(
			@Query("statement_student") String studentId,
			@Query("max_date") String finalDate,
			@Query("min_date") String startDate);

	@GET("/ldap/")
	LdapResponse ldapResponse(@Header("Authorization") String encoded);

}
