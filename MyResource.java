package mum.bank_restful.RestfulBanking;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs544.exercise5_3.bank.domain.Account;
import cs544.exercise5_3.bank.service.AccountService;


@Path("banking")
@RequestScoped
public class MyResource {

	private AccountService accserv;
	@Inject
	public MyResource(AccountService accserv){
		this.accserv=accserv;
	}
	  
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")    
    public Account createAccount(@QueryParam("acc") String accountNumber,@QueryParam("name") String customerName ) {
    	accserv.createAccount(Long.parseLong(accountNumber), customerName);       
        return accserv.getAccount(Long.parseLong(accountNumber));
    }
}
