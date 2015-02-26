package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.CustomerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dto.CustomerDTO;

/**
 * Cette classe fournit les différentes actions disponibles pour la page
 * customer.jsp
 * 
 * Dans le contexte Spring, les controllers sont des beans décrits par
 * l'annotation @Controller et situé dans la couche présentation.
 * 
 * !!ATTENTION!! Les méthodes des classes Action ne peuvent appeler que des
 * méthodes de la couche Service ! Il est formellement interdit d'appeler une
 * méthode d'un DAO dans la couche présentation !!
 *
 */
@Controller
public class ListCustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6874495899552728610L;

	private static final String SUCCESS = "success";

	private List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
	private CustomerDTO customer;

	/*
	 * Cette annotation permet à Spring d'injecter une dépendance à cette
	 * classe. Spring se chargera alors d'initialiser CustomerService, puis
	 * d'utiliser setCustomerService() afin de l'injecter dans cette classe.
	 * Ceci n'est néanmoins possible que si la classe CustomerService est
	 * effectivement détecté comme étant un bean par Spring, ce qui est possible
	 * en utilisant l'annotation @Service
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * Cette methode est une action (définie dans le fichier struts.xml) qui
	 * permet d'initialiser la liste des clients
	 * 
	 * @return
	 */
	public String listCustomer() {

		/*
		 * Grâce à cette ligne, on fait appel à un service de la couche Métier
		 */
		customerList = customerService.listCustomer();

		return SUCCESS;
	}

	/**
	 * Cette methode permet de supprimer le client fournit en paramètre par la
	 * requête
	 * 
	 * @return
	 */
	public String deleteCustomer() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
		try {
			/*
			 * On récupère dans la requete le paramètre nécessaire au traitement
			 */
			final Long customerId = Long.parseLong(request.getParameter("customerId"));
			if (customerId != null) {
				customerService.deleteCustomer(customerId);
			}
		} catch (final Exception e) {
			// do nothing
		}
		return SUCCESS;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public List<CustomerDTO> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerDTO> customerList) {
		this.customerList = customerList;
	}
}